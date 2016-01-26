package com.coldface.code.algorithm;

/**
 * 类ClimbStairs.java的实现描述：爬楼梯算法实现
 * 
 * @author coldface 2016年1月15日 下午2:51:42
 */
public class ClimbStairs {

    public static void main(String[] args) {

       int n=5;
       int maxStep=3;
       System.out.println(getStepNum(5,3));
    }

    /**
     * @param n 总得台阶数
     * @param m 一次可以走的最大楼梯阶数
     */
    @SuppressWarnings("unused")
    private static int getStepNum(int n, int m) {
        int sumStep = 0;
        //当总台阶数数为0时，终止递归循环
        if (n == 0) {
            return 1;
        }

        if (n >= m) {
            //如果n大于每步最大台阶数，则设置第一步为m之内的一个台阶数，然后递归循环
            for (int i = 1; i <= m; i++) {
                sumStep += getStepNum(n - i, m);
            }
        } else {
            //如果n小于m，则将一步最大台阶数缩小为n，重新递归
            sumStep = getStepNum(n, n);
        }
        return sumStep;

    }

}
