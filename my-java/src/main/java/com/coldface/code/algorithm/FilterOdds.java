package com.coldface.code.algorithm;

/**
 * 过滤出一个集合中的奇数
 * @author guanxin
 *
 */
public class FilterOdds {
	
	public static void main(String[] args){
		System.out.print("1-100的偶数：");
		for(int i=1;i<100;i++){
			if(isEven(i)){
				System.out.print(i+" ");
			}
		} 
		
	}
	
	
	/**
	 * 判断一个数是否奇数
	 * @param number
	 * @return
	 */
	public static boolean isOdd(Integer number){
		return number % 2 != 0;
	}
	
	/**
	 * 判断一个数是否偶数
	 * @param number
	 * @return
	 */
	public static boolean isEven(Integer number){
		return number % 2 == 0;
	}
	
	
	

}
