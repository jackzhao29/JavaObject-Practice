package com.coldface.code.algorithm;

/**
 * 类IntegerReverseString.java的实现描述：将整数反转成字符串
 * @author coldface
 * @date 2016年9月28日上午10:11:01
 */
public class IntegerReverseString {
  
  public static void main(String[] args){
    System.out.println(reverse(23654));
  }
  
  /**
   * 将输入的整型反转成字符串
   * @author zhaofei
   * @date 2016年9月28日上午10:12:39
   * @param i
   * @return
   */
  public static String reverse(int i){
    if(i<10){
      return Integer.toString(i);
    }else{
      return Integer.toString(i%10)+reverse(i/10);
    }
  }

}
