package com.wangle.sort.selectionSort;

public class Practice {

	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		
		sort(arr);
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[minPos]>arr[j])
					minPos = j;
			}
			swap(arr,i,minPos);
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
