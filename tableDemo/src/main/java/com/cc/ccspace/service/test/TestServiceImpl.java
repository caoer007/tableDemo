package com.cc.ccspace.service.test;

import com.cc.ccspace.base.service.CcBaseServiceImpl;
import com.cc.ccspace.common.annotation.Table;
import com.cc.ccspace.common.constant.ClassLoadConstant;
import com.cc.ccspace.common.util.ClassLoadUtil;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/5/7 0:37.
 */
public class TestServiceImpl extends CcBaseServiceImpl implements TestService {
    @Override
    public String createTableSql(String beanName) {
        Set<Class<?>> clsSet= ClassLoadUtil.getClassSetOfPackage(ClassLoadConstant.BnnTableDemoPath);
        if(StringUtils.isEmpty(beanName)){
            return "";
        }
        Class  bnnClass=getClassByBeanName(clsSet,beanName);
        if(bnnClass==null){
            return "";
        }
        Map<String,Object> m=new HashMap<>();
        Field[] fields= bnnClass.getDeclaredFields();
        for(Field f:fields){
            f.setAccessible(true);
            com.cc.ccspace.common.annotation.Field field=
                    f.getAnnotation(com.cc.ccspace.common.annotation.Field.class);
             m.put(f.getName(),field);
        }
        if(m.isEmpty()){
            return "";
        }
        String tableSql=generateTableSql(beanName,m);
        return tableSql;

    }


}
