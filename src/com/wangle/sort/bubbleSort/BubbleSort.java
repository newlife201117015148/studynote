package com.wangle.sort.bubbleSort;

public class BubbleSort {
	//ð������
	//˼·��1.�ӵ�һ������ʼ���������бȽϣ�ǰ��һ�����ں���һ�����ͽ���λ�ã�ֱ���Ƚϵ����һ�������������������������������һ��λ�á�
	//    2.�ӵ�һ������ʼ���������бȽϣ�ǰ��һ�����ں���һ�����ͽ���λ�ã��Ƚϵ����鵹���ڶ����ͽ���������������ڶ�����������ڵ����ڶ���λ�á�
	//    3.�Դ����ƣ�ֱ���������鶼�ź���
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		
		sort(arr);
		System.out.print("�ź���֮��");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = arr.length-1; i > 0; i--) {
			int flag = findMax(arr,i);
//			System.out.print("��"+(arr.length-i)+"��֮��");
//			print(arr);
			if(flag==0) break;
		}
	}
	public static int findMax(int[] arr,int n){//������������������
		int flag = 0;//����Ƿ���ĳһ��������Ѿ��ź�����
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
