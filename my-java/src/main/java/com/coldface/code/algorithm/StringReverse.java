package com.coldface.code.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 类StringReverse.java的实现描述：字符串反转
 * 
 * @author coldface 2016年1月5日 下午3:19:30
 */
public class StringReverse {

    Map<String, String> maps = new HashMap<String, String>();

    public static void main(String[] args) {
        String str = "welcometobeijing";
        System.out.println(reverse(str));
        System.out.println(reverse01(str));
    }

    /**
     * 解法1
     */
    public static String reverse(String str) {
        char[] c = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    /**
     * 解法2
     */
    public static String reverse01(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse01(str.substring(1)) + str.charAt(0);
    }

}
