package com.wangle.sort.quickSort;

public class Practice {
	//练习用的
	public static void main(String[] args) {
		int[] arr = {9,1,8,3,6,4,7,2,5};//
		System.out.print("原始数据：");
		print(arr);
		sort(arr,0,arr.length-1);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr,int leftBound,int rightBound){
		if(leftBound<rightBound)
		{
			int mid = partition(arr,leftBound,rightBound);
			sort(arr,leftBound,mid-1);
			sort(arr,mid+1,rightBound);
		}
	}
	public static int partition(int[] arr,int left,int right){ 
		int base = arr[right];
		while(left<right){
			while(left<right&&arr[left]<=base)
				left ++;
			arr[right] = arr[left];
			while(left<right&&arr[right]>=base)
				right--;
			arr[left] = arr[right];
		}
		arr[left] = base;
		return left;
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
