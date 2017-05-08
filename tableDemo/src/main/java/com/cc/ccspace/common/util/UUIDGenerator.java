package com.cc.ccspace.common.util;

import java.util.UUID;

public class UUIDGenerator {
	public UUIDGenerator() {
	}

	/**
	 * 获得一个UUID  返回32位十六进制数
	 * 例如：ad6c7aafbc354ae89d0d2e685b9d0b16
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号 这个效率更高
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
		// return s.replaceAll("-", "");
	}
}