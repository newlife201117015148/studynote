package com.wangle.sort.quickSort;

public class QuickSort {
	//快速排序
	//思路：1.分治思想，将数组索引0位置作为base基数，left作为数组的起始指针，right作为数组的末尾指针。
	//    2.保证left<right情况下，从右边开始如果right位置的数大于等于基数，right++，直到right位置的数小于基数，就right位置上的数覆盖left位置上的数。
	//    3.保证left<right情况下，然后从左边开始，如果left位置上的数小于等于基数，left++，碰到大于基数的数，就将其覆盖到right位置上。
	//    4.直到left=right后，将基数赋值到left和right汇合的位置上。
	//    5.然后以基数的位置作为分割点，将数组分成两部分，利用递归方法重复上面的步骤。
	public static void main(String[] args) {
		int[] arr = {9,1,8,3,6,4,7,2,5};//
		System.out.print("原始数据：");
		print(arr);
		sort(arr,0,arr.length-1);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr,int leftBound,int rightBound){
		if(leftBound>=rightBound)return;
		int mid = partition(arr, leftBound, rightBound);
		sort(arr, leftBound, mid-1);
		sort(arr, mid+1, rightBound);
	}
	public static int partition(int[] arr,int left,int right){
		int temp = arr[right];
		while(left<right){//不能加等于，加了最终while结束后，left>right了,就找不到基数该放在什么位置了
			//注意1：基数定在左边就从右边指针开始比较，反之，定在右边，左边指针开始移动.
			//注意2：arr[left]<=temp中等号不能省。
			while(left<right&&arr[left]<=temp){
				left++;
			}
			arr[right] = arr[left];
			while(left<right&&arr[right]>=temp){
				right--;
			} 
			arr[left] = arr[right];
		}
		//while循环结束，代表left=right
		arr[right] = temp;
//		print(arr);
		return right;
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
