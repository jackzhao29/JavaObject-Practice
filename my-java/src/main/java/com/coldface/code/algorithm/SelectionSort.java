package com.coldface.code.algorithm;

/**
 * 类SelectionSort.java的实现描述：冒泡排序
 * @author coldface
 * @date 2017年5月28日下午6:52:37
 */
public class SelectionSort {
  
  public static void main(String[] args){

    //System.out.println(reverse("abcedtes"));

    String s1 = new StringBuilder("go")
            .append("od").toString();
    System.out.println(s1.intern() == s1);
    String s2 = new StringBuilder("ja")
            .append("va").toString();
    System.out.println(s2.intern() == s2);

    int[] n={6,14,11,8,23,7};
    //sort(n);
  }

  public static String reverse(String originStr) {
    if(originStr == null || originStr.length() <= 1)
      return originStr;

    System.out.println("=="+originStr.substring(1));
    System.out.println("--"+originStr.charAt(0));
    return reverse(originStr.substring(1)) +originStr.charAt(0);
  }
  
  /**
   * 冒泡排序
   * @author coldface
   * @date 2017年8月21日下午8:19:21
   * @param n
   */
  public static void sort(int[] n){
    int temp;
    int len = n.length;
    for(int i=0;i<len-1;i++){
      for(int j=i+1;j<len;j++){
        if(n[i]>n[j]){
          temp = n[j];
          n[j] = n[i];
          n[i] = temp;
        }
      }
    }
    
    //输出
    for(int i=0;i<len;i++){
      System.out.print(n[i]+" ");
    }
  }

}
