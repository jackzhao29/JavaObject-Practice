package com.coldface.code.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
	
	/**
	 * 加密
	 * @author coldface
	 * @param info
	 * @return
	 */
	public static String encode(String info){
		try {
			return Base64.encodeBase64URLSafeString(info.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	/**
	 * 解密
	 * @author coldface
	 * @param info
	 * @return
	 */
	public static String decode(String info){
		
		try {
			byte[] result=Base64.decodeBase64(info);
			return new String(result,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
