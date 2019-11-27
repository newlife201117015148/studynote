package com.wangle.sort.radixSort;

import java.util.Arrays;

public class RadixSort {
	//��������
	//��������һ�ֶ�ؼ������򷽷�
	//��Ϊ��λ���Ⱥ͸�λ���ȣ������ȡ���ǵ�λ���ȡ��ʹӸ�λ����λ����
	//Ҳ���������ַ����Ķ�ؼ�������
	//˼·��1.����ԭʼ�����е����ݵĸ�λ�����м�������
	//    2.Ȼ��ʮλ����λ����������ֱ�����λ��
	public static void main(String[] args) {
		int[] arr = new int[]{323,4,2,465,3,647,234,865};//323,432,523,465,643,647,234,865
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		int max = findMax(arr);
		
		int high = 0;
		while(max>0){
			max = max/10;
			high++;
		} 
		
		int[] newarr = new int[arr.length];
		for (int i = 0; i < high; i++) {
			int[] count = new int[10];
			for (int j = 0; j < arr.length; j++) {
				int cell = arr[j]/(int)Math.pow(10, i)%10;
				count[cell]++ ;
			}
//			System.out.println(Arrays.toString(count));
			for (int k = 1; k < count.length; k++) {
				count[k] = count[k-1]+count[k];
			}
//			System.out.println(Arrays.toString(count));
			for (int j = arr.length-1; j >= 0; j--) {
				int cell = arr[j]/(int)Math.pow(10, i)%10;
				newarr[--count[cell]]= arr[j];
			}
//			System.out.println(Arrays.toString(newarr));
			System.arraycopy(newarr, 0, arr, 0, arr.length);//���������ѭ�����棬��֤ʵʱ��������
		}
	}
	
	public static int findMax(int[] arr){
		if(arr.length==0) return 0;
		int max = 0;
		for (int i = 1; i < arr.length; i++,max++) {
			if(arr[max]>arr[i]){
				int temp = arr[max];
				arr[max] = arr[i];
				arr[i] = temp;
			}
		}
		return arr[arr.length -1];
	}
}
