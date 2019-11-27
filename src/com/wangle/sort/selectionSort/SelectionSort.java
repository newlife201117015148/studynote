package com.wangle.sort.selectionSort;

public class SelectionSort {

	//ѡ������
	//˼·��1�����ȴ����������ҳ���С������Ȼ�������͵�һ��������
	//    2.Ȼ���ʣ�����������ҳ���С������Ȼ�������͵ڶ���������
	//    3.�Դ����ƣ�ֱ���ź���
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
