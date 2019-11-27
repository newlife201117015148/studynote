package com.wangle.sort.bucketSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.wangle.sort.quickSort.QuickSort;

public class BucketSort {
	//Ͱ����
	//˼·��1.������ִ�СΪ��max-min��/k=len��k������k+1������
	//    2.Ȼ���ÿ������е��������򣬰�ÿ����ķֶ�ֵ�ô�С����ȡ���Ż�ԭ���顣
	public static void main(String[] args) {
		int[] arr = new int[]{215, 264, 289, 318, 358, 387, 624, 626, 873, 924, 930};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		if(arr.length == 1) return;
		int[] newarr = new int[arr.length];
		int max = findMax(arr);
		int k = 4;
		int segment = max/k;
		int newarrindex = 0;
		if(segment*k<=max){
			k+=1;
		}
		for (int i = 0; i < k; i++) {
			List<Integer> temp = new LinkedList<>();
			int s = i*segment;
			int e = (i+1)*segment;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]>=s&&arr[j]<e){
					temp.add(arr[j]);
				}
			}
			int[] tempArr = new int[temp.size()];
			for (int j = 0; j < temp.size(); j++) {
				tempArr[j] = temp.get(j);
			}
//			System.out.println(segment);
//			System.out.println(Arrays.toString(tempArr));
			QuickSort.sort(tempArr, 0, tempArr.length-1);
			for (int j = 0; j < tempArr.length; j++) {
				newarr[newarrindex++] = tempArr[j];
			}
		}
		System.arraycopy(newarr, 0, arr, 0, arr.length);
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
