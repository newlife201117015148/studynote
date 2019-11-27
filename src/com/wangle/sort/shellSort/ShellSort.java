package com.wangle.sort.shellSort;

public class ShellSort {
	//ϣ������
	//˼·��1.ȡһ�����Gap��������������Ϊ��׼�ӵ�һ��Ԫ�ؿ�ʼ������������ȡ��һ�����������һ���µ������飬Ȼ�������������������
	//    2.�ٴӵڶ���Ԫ�ؿ�ʼȡ��һ�������飬���������Դ����ƣ����ӵ�gap-1��Ԫ��ȡ�����飬����
	//    3.Ȼ������gap-1������С��gap�������������ȡ�����������1ȡ���������������������ˡ�
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		System.out.print("ԭʼ���ݣ�");
		print(arr);
		sort(arr);
		System.out.print("�ź���֮��");
		print(arr);
	}
	public static void sort(int[] arr){
		int index = 1;
		for (int i = arr.length/4; i > 0; i/=2) {
			sortByGap(arr,i);
			System.out.print("��"+index+"��֮��");
			print(arr);
			index ++;
		}
	}
	public static void sortByGap(int[] arr,int gap){//������������������
		int temp = 0;
		while(temp<gap){
			for ( int i= temp; i < arr.length-gap; i=i+gap) {
				if(arr[i]>arr[i+gap])
					swap(arr,i,i+gap);
			}
			temp++;
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
