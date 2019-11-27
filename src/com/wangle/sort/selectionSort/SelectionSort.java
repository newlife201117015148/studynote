package com.wangle.sort.selectionSort;

public class SelectionSort {

	//选择排序
	//思路：1。首先从数组里面找出最小的数，然后让它和第一个数交换
	//    2.然后从剩下数组里面找出最小的数，然后让它和第二个数交换
	//    3.以此类推，直到排好序。
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			int minpos = findMinPos(arr,i);
			swap(arr,i,minpos);
			System.out.println("minpos:"+minpos);
			print(arr);
		}
	}
	public static int findMinPos(int[] arr,int n){
		int minpos = n;
		for (int i = n+1; i < arr.length; i++) {
			if(arr[i]<arr[minpos]) 
				minpos = i;
		}
		return minpos;
	}
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
}
