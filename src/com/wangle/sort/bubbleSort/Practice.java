package com.wangle.sort.bubbleSort;

public class Practice {
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		
		sort(arr);
		System.out.print("ÅÅºÃĞòÖ®ºó£º");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = arr.length; i > 0; i--) {
			int index = 0;
			for (int j = 0; j < i-1; j++) {
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
					index ++;
				}
			}
			if(index==0) break;
			print(arr);
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
