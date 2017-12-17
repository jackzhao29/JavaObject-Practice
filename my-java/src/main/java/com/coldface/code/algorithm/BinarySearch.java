package com.coldface.code.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 折半查找,也称二分查找、二分搜索,是一种在有序数组中查找某一特定元素的搜索算法。搜索过程从数组的中间元素开始,如果中间元素正好是要查找的元素,
 * 则搜索过程结束;如果某一特定元素大于或者小于中间元素,则在数组大于或小于中间元素的那一半查找,而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组已经为空,则表示找不到指定的元素。这种搜索算法每次比较都使搜索范围缩小一般,其时间复杂度是O(logN)
 */
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
	        System.out.println("====");
	        if(Arrays.binarySearch(nums,765)>0){
	            System.out.println("Arrays.binarySearch:true");
	        }else
	        {
	        	System.out.println("Arrays.binarySearch:false");
	        }
	        System.out.println("binarySearch耗时："+(System.currentTimeMillis()-start));

	        long enStart=System.currentTimeMillis();
	        //使用循环
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==765){
	                System.out.println("for:true");
	                break;
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


	/**
	 * 使用循环实现的二分查找
	 * @param x
	 * @param key
	 * @param comp
	 * @param <T>
     * @return
     */
	public static<T> int binarySearch(T[] x, T key, Comparator<T> comp){
		int low = 0;
		int high = x.length - 1;
		while (low <= high){
			int mid = (low + high) >> 1;
			int cmp = comp.compare(x[mid], key);
			if(cmp < 0){
				low = mid + 1;
			}else if(cmp > 0){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 使用递归实现的二分查找
	 * @param x
	 * @param low
	 * @param high
	 * @param key
	 * @param <T>
     * @return
     */
	public static<T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key){
		if(low > high){
			return -1;
		}

		int mid = low + ((low + high) >> 1);
		if(key.compareTo(x[mid]) == 0){
			return mid;
		}else if(key.compareTo(x[mid]) < 0){
			return binarySearch(x,low,mid-1,key);
		}else{
			return binarySearch(x,mid+1,high,key);
		}


	}

}
