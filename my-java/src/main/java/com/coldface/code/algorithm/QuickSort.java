package com.coldface.code.algorithm;
/*
* 快速排序
* 原理：通过一遍扫描将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这
* 两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
*
* 举个例子
* 如无序数组[6,3,2,5,8,1]
* a)先把第一项[6]取出来，
* 用[6]依次与其余项进行比较,
* 如果比[6]小就放[6]前边，2，3，5，1都比[6]小，所以全部都放在[6]前边
* 如果比[6]大就放[6]后面，8比[6]大，放到[6]后边
* 一遍排完后变成下边这样：
* 排序前：6,3,2,5,8,1
* 排序后：3,2,5,1,6,8
*
* b)对前部分[3,2,5,1]继续进行快速排序，
* 重复步骤a)后变成下边这样:
* 排序前：3,2,5,1
* 排序后：2,3,5,1
* 继续重复步骤a)
* 前半部分排序完成后，总得排序也完成了
* 排序前：[6,3,2,5,8,1]
* 排序后：[1,2,3,5,6,8]
*/
public class QuickSort {
	
	public static void main(String[] args){
        int[] unsorted={6,3,2,5,8,1};
        quickSort(unsorted,0,unsorted.length-1);
        for (int i=0;i<unsorted.length;i++){
           System.out.print(unsorted[i]+",");
        }
    }

    public static int partition(int[] unsorted,int low,int high){
        int pivot=unsorted[low];
        while (low < high){
            while (low < high && unsorted[high] > pivot)
                high--;
            unsorted[low]=unsorted[high];
            while (low < high && unsorted[low] <= pivot)
                low++;
            unsorted[high]=unsorted[low];
        }
        unsorted[low]=pivot;
        return low;
    }

    public static void quickSort(int[] unsorted,int low,int hight){
        int loc=0;
        if(low < hight){
            loc=partition(unsorted,low,hight);
            quickSort(unsorted,low,loc-1);
            quickSort(unsorted,loc+1,hight);
        }
    }

}
