package com.wangle.sort.insertionSort;

public class Practice {
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};//
		System.out.print("原始数据：");
		print(arr);
		sort(arr);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int flag = 0;
			for(int index = i;index>0;index --){
				if(arr[index-1]>arr[index]){
					swap(arr,index-1,index);
					flag ++;
				}
				if(flag==0) break;
			}
		}
		
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
