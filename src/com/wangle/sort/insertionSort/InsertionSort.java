package com.wangle.sort.insertionSort;

public class InsertionSort {
	//插入排序
	//思路：1.从数组中取出第二个数，从这个位置开始向前扫描,前面的数大于当前的数就交换,直到前面的数小于或等于这个数就停止.
	//    2.从数组中取出第三个数，从这个位置开始向前扫描,前面的数大于当前的数就交换,直到前面的数小于或等于这个数就停止.
	//    3.以此类推.
	//再简单排序中，也就是指在冒泡排序（太慢）、选择排序（不稳定）、插入排序（较快，稳定）中，选择插入排序。
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		System.out.print("原始数据：");
		print(arr);
		sort(arr);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			sortFromIndex2(arr,i);
//			System.out.print("第"+i+"遍之后：");
//			print(arr);
		}
	}
	public static void sortFromIndex(int[] arr,int n){//将最大的数依次往后排
		for (int i = n; i > 0; i--) {
			if(arr[i]<arr[i-1]){
				swap(arr,i,i-1);
			}else{
				break;//找到位置就停止
			}
		}
	}
	//不用swap方法，采用后移的方式
	public static void sortFromIndex2(int[] arr,int n){
		int i,temp = arr[n];//注意这里i是循环的变量
		for (i = n-1; i >= 0; i--) {
			if(temp<arr[i]){
				arr[i+1] = arr[i];//发现小于temp就往后移一位
			}else{
				break;//找到位置就停止
			}
		}
		arr[i+1] = temp;
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
