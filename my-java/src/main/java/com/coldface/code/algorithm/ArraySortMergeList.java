package com.coldface.code.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 先依次比较两个数据，按照小得就传入新的数组，当这次比较完之后可能有一个数据长度很长，留下一些数组，然后再新数组的末尾插入即可
 * @author coldface
 *
 */
public class ArraySortMergeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,2,3,5,6,7,7};
        int b[]={1,2,4,5,8,8,9,10,11,12,12,13,14};
	    int c[]= MergeList(a,b);
        if(c!=null)
	        print(c);
        else
            System.out.println("");
        
        
        List list=new ArrayList();
        list.add("test");
        list.add("test01");
        list.add("test02");
        list.add("test");
        list.add("test3");
        
        List l=removeDuplicate(list);
       Iterator iterator=l.iterator();
       while(iterator.hasNext())
    	   System.out.println(iterator.next());
	}
	
	//两个有序数组的合并函数
	public static int[] MergeList(int a[], int b[]){
		int result[];
		//检查传入的数组是否是有序的
		if(checkSort(a) && checkSort(b)){
			result=new int[a.length+b.length];
			int i=0,j=0,k=0; //i：用于标示a数组；j:用来标示b数组；k:用来标示传入的数组
			while(i<a.length && j<b.length){
				if(a[i] <= b[j]){
					result[k++]=a[i++];
				}else{
					result[k++]=b[j++];
				}
			}
			
			//后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入
			while(i<a.length)
				result[k++]=a[i++];
			while(j<b.length)
				result[k++]=b[j++];
				
			return result;
		}else{
			System.out.println("非有序数组，不可排序");
			return null;
		}
	}
	
	//检查数组是否是顺序存储的
	public static boolean checkSort(int a[]){
		boolean change =true; //这个标志位是一种优化程序的方法
		for(int i=0; i<a.length-1 && change; i++){
			for(int j=i+1; j<a.length;j++){
				if(a[j-1] > a[j]){
					return false;
				}else{
					change =false;
				}
			}
		}
		return true;
	}
	
	//打印函数
	public static void print(int b[]){
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]+(i%10 ==9? "\n":"\t"));
		}
	}
	
	//删除ArrayList里的重复项
	public static List removeDuplicate(List arlList){
		HashSet h=new HashSet(arlList);
		arlList.clear();
		arlList.addAll(h);
		return arlList;
	}
	

}
