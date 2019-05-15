package com.zlh.example.util;

/**
 * @author: zlh
 * @date: 2019/5/1
 */
public class StringTools {

	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) || "null".equals(str);
	}

	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj);
	}

}
