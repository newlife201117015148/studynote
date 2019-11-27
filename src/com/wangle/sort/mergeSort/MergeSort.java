package com.wangle.sort.mergeSort;

public class MergeSort {
	//�鲢����
	//˼·��1.��ԭʼ���д��м��Ϊ�������������У���ʱ������Ϊ2
	//    2.�������к��������ٷֱ���м��Ϊ�������������У���ʱ������Ϊ4
	//    3.�ظ����ϲ��裬ֱ��ÿ�������ж�ֻ��һ��Ԫ�أ�����Ϊÿһ�������ж��������
	//    4.������ν��й鲢������ֱ����������Ϊ1
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		int[] newarr = new int[arr.length];
		System.out.print("ԭʼ���ݣ�");
		print(arr);
		sort(arr,newarr,0,arr.length-1);
		System.out.print("�ź���֮��");
		print(arr);
	}
	public static void sort(int[] arr,int[] newarr,int s,int e){
		if(s<e){
			int mid = s + (e-s)/2;
			sort(arr, newarr, s, mid);
			sort(arr, newarr, mid+1, e);
			merge(arr,newarr,s,mid,e);
		}
		
	}
	
	public static void merge(int[] a,int[] r,int s,int m,int e){
		int i = s;
		int j = m+1;
		int k = s;
		while(i<=m&&j<=e){
			if(a[i]<=a[j]){
				r[k++] = a[i++];
			}else{
				r[k++] = a[j++];
			}
		}
		while(i<=m)
			r[k++] = a[i++];
		while(j<=e)
			r[k++] = a[j++];
		for (int k2 = 0; k2 < k; k2++) {
			a[k2]=r[k2];
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
