package com.coldface.code.algorithm;

/**
 * 类YFTriangle.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2017年8月20日下午11:45:01
 */
public class YFTriangle {
  
  public static void main(String[] args){
    printYFTriangle(18);
  }
  
  /**
   * 1 要理解下面的实现，首先要明白int数组中元素默认值为 0
   * 2 然后每一次迭代打印新的一行的元素的时候：
   * 新的特定位置的元素 = 该位置原来的元素 + 该位置的前一个位置的值
   */
  public static void printYFTriangle(int n){
    int [] a = new int[n+1];
    int previous = 1;
    for(int i =1; i<= n;i++){
      for(int j = 1;j<=i;j++){
        int current = a[j];
        a[j] = previous + current;
        previous = current;
        System.out.print(a[j]+" ");
      }
      System.out.println();
    }
  }

}
