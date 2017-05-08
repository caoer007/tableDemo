package com.cc.ccspace.base.service;

import com.cc.ccspace.common.annotation.Field;
import com.cc.ccspace.common.annotation.Table;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/5/7 2:06.
 */
public class CcBaseServiceImpl {
    /**  * describe: 根据bean的字段信息以及其注解信息生成对应建表语句
     * @author CAI.F
     * @date:  日期:2017/5/7 时间:1:54
     * @param
     */
    public String generateTableSql(String tableName,Map<String, Object> m) {
        Set<Map.Entry<String,Object>> e=m.entrySet();
        if(e==null||e.size()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder("create table "+tableName+"(");
        StringBuilder sbKey=new StringBuilder("PRIMARY KEY (");
        Iterator<Map.Entry<String,Object>> it=e.iterator();
         appendFieldsOfTable(it,sb,sbKey);
         return sb.toString();
    }
/**  * describe: 拼接表的字段信息语句到sb中
	 * @author CAI.F
	 * @date:  日期:2017/5/7 时间:14:25
	 * @param
	 */
    private void appendFieldsOfTable(Iterator<Map.Entry<String,Object>> it,StringBuilder sb,StringBuilder sbKey) {
        int keyCount=0;
        while(it.hasNext()){
            Map.Entry<String,Object> entry=it.next();
            Field f=(Field)entry.getValue();
            sb.append(entry.getKey());
            sb.append(f.type());
            sb.append(f.len());
            if(!f.isNull()){
                sb.append(" NOT NULL");
            }
            if(f.isKey()){
                if(keyCount>0)
                {
                    sbKey.append(",");
                }
                sbKey.append(entry.getKey());
                keyCount++;
            }
            sb.append(" COMMENT '");
            sb.append(f.comment());
            sb.append("' ,");
        }
        sbKey.append(")");
        sb.append(sbKey);
        sb.append(" ) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    /**  * describe: 通过表名获取符合要求的Class（有Table注解 且注解的name与表名对应）
    	 * @author CAI.F
    	 * @date:  日期:2017/5/7 时间:11:59
    	 * @param
    	 */
    public Class<?> getClassByBeanName(Set set,String beanName) {
        if (set.isEmpty()) {
            return null;
        }
        Class result=null;
        Iterator<Class<?>> it = set.iterator();
        ok:
        while (it.hasNext()) {
            Class s = it.next();
            if (s.getAnnotation(Table.class) != null) {
                Table tab = (Table) s.getAnnotation(Table.class);
                if (!"".equals(tab.name()) && beanName.equals(tab.name())) {
                    result=s;
                    break ok;
                }
            }
        }
        return result;
    }
}
