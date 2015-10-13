package com.coldface.code.algorithm;

/**
 * 斐波拉契算法
 * 1,1,2,3,5,8,13,21,34,55....
 * @author coldface
 *
 */
public class Fibonacci {

	public static void main(String[] args){
		System.out.println(number(8));
		
		for(int i=1;i<=7;i++){
			System.out.println(i+":"+number(i));
		}
	}
	
	public static int number(int num){
		if(num<=1)
			return num;
		else
			return number(num-1)+number(num-2);
	}
}
