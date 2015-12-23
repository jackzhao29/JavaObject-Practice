package com.coldface.code.algorithm;

/**
 * 类Prime.java的实现描述：TODO 判断一个数是否为素数
 * 
 * @author coldface 2015年12月23日 上午11:16:32
 */
public class Prime {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 用于判断一个数是否为素数，若为素数，返回true，否则返回false * @return
     */
    public static boolean isPrime(int a) {
        boolean flag = true;
        //素数不能小于2
        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                //若能被整除，说明不是素数，否则是素数
                if (a % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

}
