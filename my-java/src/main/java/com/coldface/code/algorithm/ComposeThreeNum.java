package com.coldface.code.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 类ComposeThreeNum.java的实现描述：TODO 类实现描述
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
 * @author coldface
 * @date 2017年1月8日上午9:59:15
 */
public class ComposeThreeNum {

  public static void main(String[] args){
    List<Integer> list=new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    int sum=0;
    for(Integer a:list){
      for(Integer b:list){
        for(Integer c:list){
          if(a!=b && b!=c && c!=a){
            sum+=1;
            System.out.println(""+a+""+b+""+c);
          }
        }
      }
    }
    System.out.println(sum);
  }
}
