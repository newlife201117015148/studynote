package com.wangle.sort.shellSort;

public class Practice {
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};//1,2,3,4,5,6,7,8,9
		System.out.print("原始数据：");
		print(arr);
		sort(arr);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int gap = arr.length/2; gap > 0; gap/=2) {
			for (int i = 0; i < arr.length-gap; i++) {
				if(arr[i]>arr[i+gap])
					swap(arr,i,i+gap);
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
