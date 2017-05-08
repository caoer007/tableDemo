package com.cc.ccspace.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/5/7 11:13.
 */
public class ClassLoadUtil {

    private static final Logger log= LoggerFactory.getLogger(ClassLoadUtil.class);
    /**  * describe: 获取类加载器
    	 * @author CAI.F
    	 * @date:  日期:2017/5/7 时间:11:15
    	 * @param
    	 */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className,boolean isInit){
        Class<?> cl=null;
        try {
            cl=Class.forName(className,isInit,getClassLoader());
        } catch (ClassNotFoundException e) {
             log.error("can't find calss"+className);
             throw new RuntimeException(e);
        }
              return cl;

    }

    /*加载文件夹的类*/
    private static void addClass(Set<Class<?>> classSet, String packagePath,
                                 String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                //获取以.class后缀的文件,以及所有的文件目录
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });

        for(File file : files) {
            String fileName = file.getName();
            if(file.isFile()) {
                //以.class结尾的类文件
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (!StringUtils.isEmpty(className)) {
                    className = packageName + "." + className;
                }
                //加载类
                doAddClass(classSet, className);
                log.info(className);
            } else {
                String subPackagePath = fileName;
                //获取子路径
                if(!StringUtils.isEmpty(subPackagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                //获取子包名
                String subPackageName = fileName;
                if(!StringUtils.isEmpty(subPackageName)) {
                    subPackageName = subPackageName + "." + subPackageName;

                }
                //递归加载子目录下的类
                addClass(classSet, subPackagePath, subPackageName);
            }

        }

    }

   /**  * describe:
   	 * @author CAI.F加载文件夹下特定名称的类
   	 * @date:  日期:2017/5/7 时间:11:32
   	 * @param
   	 */
    private static void addClass(Set<Class<?>> classSet, String packagePath,
                                 String packageName,String specialClassName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                //获取以.class后缀的文件,以及所有的文件目录
                return (file.isFile() && file.getName().endsWith(specialClassName+".class")) || file.isDirectory();
            }
        });

        for(File file : files) {
            String fileName = file.getName();
            if(file.isFile()) {
                //以.class结尾的类文件
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (!StringUtils.isEmpty(className)) {
                    className = packageName + "." + className;
                }
                //加载类
                doAddClass(classSet, className);
                log.info(className);
            } else {
                String subPackagePath = fileName;
                //获取子路径
                if(!StringUtils.isEmpty(subPackagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                //获取子包名
                String subPackageName = fileName;
                if(!StringUtils.isEmpty(subPackageName)) {
                    subPackageName = subPackageName + "." + subPackageName;

                }
                //递归加载子目录下的类
                addClass(classSet, subPackagePath, subPackageName);
            }

        }

    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        //log.info(className);
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }
    /**  * describe: 通过包名获取目录下的所有类的Class对象
    	 * @author CAI.F
    	 * @date:  日期:2017/5/8 时间:11:27
    	 * @param
    	 */
    public static Set<Class<?>> getClassSetOfPackage(String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();

        try{
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));

            while(urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if(null != url) {
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")) {
                        String packagePath = url.getPath().replaceAll("%20", " "); //替换所有的%20为空格
                        addClass(classSet, packagePath, packageName); //加载文件夹,以及文件夹下面的类
                    } else if(protocol.equals("jar")) {
                        //解压jar包然后获取entry
                        //entry格式如下com/cc/ccspace/bean/BnnTableDemo.class
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if(null != jarURLConnection) {
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if(null != jarFile) {
                                Enumeration<JarEntry> jarEntries = jarFile.entries(); //获取所有的entry
                                while(jarEntries.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if(jarEntryName.endsWith(".class")) { //是否是类,是类进行加载
                                        System.out.println(jarEntryName);
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf("."))
                                                           .replaceAll("/", ".");
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }catch(Exception e){
            log.error("get class set fail", e);
            throw new RuntimeException(e);
        }
        return classSet;
    }

}
