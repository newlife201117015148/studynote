package com.wangle.algorithm;

import java.util.Arrays;

public class Test018 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 求解最长上升子序列
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
			
		int[] arr = {5,8,9,6,5};
		lis(arr);

	}
	public static int lis(int[] arr){
		int[] dist = new int[arr.length];//记录的是当前索引位置的数字最为结尾的最长上升子序列个数，通俗来讲就是加上自己索引前面的数字中有多少个数字小于自己。
		int max = 0;
		for (int i = 0; i < dist.length; i++) {
			dist[i] = 1;
		}
		//先选出数组每个元素的最长上升子序列，最后在选出最长那个
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]&&dist[j]+1>dist[i]){
					dist[i] = dist[j]+1;
				}
			}
			//选出最长子序列
			if(max<dist[i]){
				max = dist[i];
			}
		}
		System.out.println(max);
		System.out.println(Arrays.toString(dist));
		return max;
	}

}
