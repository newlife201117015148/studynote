package com.wangle.sort.insertionSort;

public class InsertionSort {
	//��������
	//˼·��1.��������ȡ���ڶ������������λ�ÿ�ʼ��ǰɨ��,ǰ��������ڵ�ǰ�����ͽ���,ֱ��ǰ�����С�ڻ�����������ֹͣ.
	//    2.��������ȡ�����������������λ�ÿ�ʼ��ǰɨ��,ǰ��������ڵ�ǰ�����ͽ���,ֱ��ǰ�����С�ڻ�����������ֹͣ.
	//    3.�Դ�����.
	//�ټ������У�Ҳ����ָ��ð������̫������ѡ�����򣨲��ȶ������������򣨽Ͽ죬�ȶ����У�ѡ���������
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		System.out.print("ԭʼ���ݣ�");
		print(arr);
		sort(arr);
		System.out.print("�ź���֮��");
		print(arr);
	}
	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			sortFromIndex2(arr,i);
//			System.out.print("��"+i+"��֮��");
//			print(arr);
		}
	}
	public static void sortFromIndex(int[] arr,int n){//������������������
		for (int i = n; i > 0; i--) {
			if(arr[i]<arr[i-1]){
				swap(arr,i,i-1);
			}else{
				break;//�ҵ�λ�þ�ֹͣ
			}
		}
	}
	//����swap���������ú��Ƶķ�ʽ
	public static void sortFromIndex2(int[] arr,int n){
		int i,temp = arr[n];//ע������i��ѭ���ı���
		for (i = n-1; i >= 0; i--) {
			if(temp<arr[i]){
				arr[i+1] = arr[i];//����С��temp��������һλ
			}else{
				break;//�ҵ�λ�þ�ֹͣ
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
