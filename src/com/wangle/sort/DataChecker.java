package com.wangle.sort;

import java.util.Arrays;
import java.util.Random;

import com.wangle.sort.bubbleSort.BubbleSort;
import com.wangle.sort.bucketSort.BucketSort;
import com.wangle.sort.mergeSort.MergeSort;
import com.wangle.sort.quickSort.QuickSort;
import com.wangle.sort.radixSort.RadixSort;
import com.wangle.sort.selectionSort.Practice;


public class DataChecker {
	
	public static void main(String[] args) {
		int isRight = 0;
		for (int i = 0; i < 10000; i++) {
			Random random = new Random();
			int len = random.nextInt(100);
			int[] arr = new int[len];
			isRight += check(arr);
		}
		if(isRight==0) System.out.println(true);
		else System.out.println(false);
	}
	public static int check(int[] arr){
		int isRight = 0;
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(1000);
		}
		
		
		int[] temp = new int[arr.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}
//		InsertionSort.sort(arr);
//		BubbleSort.sort(arr);
//		QuickSort.sort(arr, 0, arr.length-1);
//		MergeSort.sort(arr, new int[arr.length], 0, arr.length-1);
//		RadixSort.sort(arr);
		BucketSort.sort(arr);
		Arrays.sort(temp);
		for (int i = 0; i < temp.length; i++) {
			if(arr[i] != temp[i]){
				isRight ++;
			}
		}
		
		return isRight;
	}

}
