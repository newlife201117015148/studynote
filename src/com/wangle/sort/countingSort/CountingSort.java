package com.wangle.sort.countingSort;

import java.util.Arrays;

public class CountingSort {

	//计数排序
	//思路：1.基数排序是不需要比较的，另外特点是数字范围小，但数据量大。
	//     2.将原始数组的值作为count计数数组的下标，该下标的值记录该数出现的次数，然后依次将count数组的下标按次数取值到新数组中。
	//    3.为了使其具有稳定性，引入累计数组，数值记录的是对应下标，也就是原始数据的值，的最后出现在新数组的位置。前提是倒叙遍历原始数组。
	public static void main(String[] args) {
		int[] arr = new int[]{2,6,4,7,9,6,5,4,3,7,9,2,8,1,0,0,0};
		System.out.println(Arrays.toString(arr));
		sort(arr);
	}
	//这个方法遗留两个问题需要优化：
	//1.当原始数组不是0~9，而是4~6。那么显然count会出现空间浪费
	//2.现在的排序是不稳定的，在从count中取数到newarr中时，是没有顺序概念的。
	public static void sort1(int[] arr){
		int[] newarr = new int[arr.length];

		int[] count = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++ ;
		}
		System.out.println(Arrays.toString(count));
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while(count[i]>0){
				
				newarr[index++] = i;
				count[i]--;
			}
		}
		System.out.println(Arrays.toString(newarr));
	}
	//改进版
	public static void sort(int[] arr){
		int[] newarr = new int[arr.length];
		
		int min = findMin(arr);
		int max = findMax(arr);
		int[] count = new int[max-min+1];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]-min]++ ;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i-1]+count[i];
		}
		System.out.println(Arrays.toString(count));
		for (int i = arr.length-1; i >= 0; i--) {
			//找到arr[i]在排好序的新数组中的位置，再赋值。
			newarr[--count[arr[i]]]= arr[i];
		}
		System.out.println(Arrays.toString(newarr));
		
	}
	
	public static int findMin(int[] arr){
		int min = 0;
		for (int i = 1; i < arr.length; i++,min++) {
			if(arr[min]<arr[i]){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr[arr.length -1];
	}
	public static int findMax(int[] arr){
		int max = 0;
		for (int i = 1; i < arr.length; i++,max++) {
			if(arr[max]>arr[i]){
				int temp = arr[max];
				arr[max] = arr[i];
				arr[i] = temp;
			}
		}
		return arr[arr.length -1];
	}
}
