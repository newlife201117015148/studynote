package com.wangle.sort.bubbleSort;

public class BubbleSort {
	//冒泡排序
	//思路：1.从第一个数开始，两两进行比较，前面一个大于后面一个，就交换位置，直到比较到最后一个数，这样就数组最大的数就排在最后一个位置。
	//    2.从第一个数开始，两两进行比较，前面一个大于后面一个，就交换位置，比较到数组倒数第二个就结束，这样就数组第二大的数就排在倒数第二个位置。
	//    3.以此类推，直到整个数组都排好序。
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		
		sort(arr);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = arr.length-1; i > 0; i--) {
			int flag = findMax(arr,i);
//			System.out.print("第"+(arr.length-i)+"遍之后：");
//			print(arr);
			if(flag==0) break;
		}
	}
	public static int findMax(int[] arr,int n){//将最大的数依次往后排
		int flag = 0;//检查是否在某一轮排序后，已经排好序了
		for (int i = 0; i < n; i++) {
			if(arr[i]>arr[i+1]){
				swap(arr,i,i+1);
				flag ++;
			}
		}
		return flag;
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
