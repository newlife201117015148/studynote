package com.wangle.sort.radixSort;

import java.util.Arrays;

public class RadixSort {
	//基数排序
	//本质上是一种多关键字排序方法
	//分为低位优先和高位优先，这里采取的是低位优先。就从个位往高位遍历
	//也可以用于字符串的多关键字排序。
	//思路：1.根据原始数组中的数据的个位数进行计数排序
	//    2.然后十位、百位、、、、，直到最高位。
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
			System.arraycopy(newarr, 0, arr, 0, arr.length);//必须放在外循环里面，保证实时更新数组
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
