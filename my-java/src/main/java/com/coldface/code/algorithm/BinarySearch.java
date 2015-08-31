package com.coldface.code.algorithm;

import java.util.Arrays;

public class BinarySearch {
	
	 public static void main(String[] args){
	        int[] nums={3,4,6,23,43,56,8,9,100,234,45,123,213,567,765,87,67,89,98,34,65,765,843};
	        long start=System.currentTimeMillis();
	        //使用二分法查询
	        Arrays.sort(nums);
	        System.out.println("升序排序：");
	        for(int i=0;i<nums.length;i++){
	            System.out.print( nums[i] + " ");
	        }
	        System.out.println("降序排序：");
	        for(int i=nums.length-1;i>=0;i--){
	            System.out.print(nums[i]+" ");
	        }
	        System.out.print("====");
	        if(Arrays.binarySearch(nums,765)>0){
	            System.out.println("true");
	        }
	        System.out.println("binarySearch耗时："+(System.currentTimeMillis()-start));

	        long enStart=System.currentTimeMillis();
	        //使用循环
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==765){
	                System.out.println("for:true");
	            }
	        }
	        System.out.println("for耗时："+(System.currentTimeMillis()-enStart));

	        int[] numsSort=sort(nums);
	        for(int i=0;i<nums.length;i++){
	            System.out.print(numsSort[i]+";");
	        }

	    }

	    public static int[] sort(int[] nums){
	        Arrays.sort(nums);
	        return nums;
	    }

}
