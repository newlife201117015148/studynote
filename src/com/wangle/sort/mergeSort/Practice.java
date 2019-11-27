package com.wangle.sort.mergeSort;

public class Practice {
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		int[] newarr = new int[arr.length];
		System.out.print("原始数据：");
		print(arr);
		sort(arr,newarr,0,arr.length-1);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr,int[] newarr,int s,int e){
		if(s<e){
			int mid = s + (e-s)/2;
			sort(arr,newarr,s,mid);
			sort(arr,newarr,mid+1,e);
			merge(arr,newarr,s,mid,e);
		}
	}
	
	public static void merge(int[] a,int[] r,int s,int m,int e){
		int left = s;
		int right = m+1;
		int k = s;
		while(left<=m&&right<=e){
			if(a[left]<=a[right])
				r[k++] = a[left++];
			else
				r[k++] = a[right++];
		}
		while(left<=m) r[k++] = a[left++];
		while(right<=e) r[k++] = a[right++];
		for (int i = 0; i < k; i++) {
			a[i] = r[i];
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
