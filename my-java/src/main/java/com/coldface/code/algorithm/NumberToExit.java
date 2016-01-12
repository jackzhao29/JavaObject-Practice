package com.coldface.code.algorithm;

/**
 * 类NumberToExit.java的实现描述：n 个人围成一圈（编号1-n），数到3的出列，然后又从头开始数，一直循环到最后一个人，请问最后剩下的人的编号
 * 
 * @author coldface 2016年1月12日 上午8:08:41
 */
public class NumberToExit {

    /** * @param args */
    public static void main(String[] args) {

        // TODO Auto-generated method stub 
        
        System.out.println(numberToExit(7));

    }

    public static int numberToExit(int total) {
        boolean[] arr = new boolean[total];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int left = arr.length;
        int count = 0;
        int index = 0;
        while (left > 1) {
            if (arr[index] == true) {
                count++;
                if (count == 3) {
                    count = 0;
                    arr[index] = false;
                    left--;
                }
            }
            // we need to change the index if out of range.
            index++;
            if (index == arr.length) {
                index = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                return i + 1;
            }
        }
        return -1;
    }

}
