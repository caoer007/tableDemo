/**
 * @ClassName:StringUtil.java
 * @Title: �����ִ�����Ĺ�����̬����
 * @Description: �����ִ�����Ĺ�����̬����
 * @Copyright:Copyright(c) 2014
 * @Company:www.si-tech.com.cn
 * 
 * @auther:chenghg
 * @date:2014-12-8
 * @version 1.0
 */
package com.cc.ccspace.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	/**
	 *
	 * 
	 * @param
	 * @return String
	 */
	public static String format(String str) {
		return str == null ? "" : str.trim();
	}
	
	
	public static String nowDateFormat(){
		return DateUtils.df.get().format(Calendar.getInstance().getTime());
	}
	/**
	 * 得到配置参数,数据库未配置则记录进入warn日志中，properties配置文件中也没有则为空 代码中进行异常处理
	 *@author CAI.F
	 * @date: 日期：2016年12月5日 时间:上午10:03:03
	 * @param
	 * @return
	 *
	 */
	/* public static String getConfigParam(String param) {
		// TODO Auto-generated method stub
		 param=ConfigCache.getConf(param);
		 if(StringUtils.isEmpty(param)){
		     	param=(String) PropertyHolder.getContextProperty(param);
		     	if(StringUtils.isEmpty(param)){
		     		param="";
		     		logger.error("Warnning！Config参数"+param+"未配置代号002");
		     	}
		         logger.warn("Warnning！Config参数"+param+"未配置代号001！");
		     }
		 return param;
	 }*/

	public static void notNull(Object object,String status,String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}


	//根据中文unicode范围判断u4e00 ~ u9fa5不全
	public static boolean isChinese(String str) {
		String regEx1 = "[\\u4e00-\\u9fa5]+";
		String regEx2 = "[\\uFF00-\\uFFEF]+";
		String regEx3 = "[\\u2E80-\\u2EFF]+";
		String regEx4 = "[\\u3000-\\u303F]+";
		String regEx5 = "[\\u31C0-\\u31EF]+";
		Pattern p1 = Pattern.compile(regEx1);
		Pattern p2 = Pattern.compile(regEx2);
		Pattern p3 = Pattern.compile(regEx3);
		Pattern p4 = Pattern.compile(regEx4);
		Pattern p5 = Pattern.compile(regEx5);
		Matcher m1 = p1.matcher(str);
		Matcher m2 = p2.matcher(str);
		Matcher m3 = p3.matcher(str);
		Matcher m4 = p4.matcher(str);
		Matcher m5 = p5.matcher(str);
		System.out.println(m1.matches());
		if (m1.matches() || m2.find() || m3.find() || m4.find() || m5.find())
			return true;
		else
			return false;
	}
}
