package com.wangle.algorithm;

import java.util.Arrays;

public class Test020 {

	//	细胞分裂(改进):递归实现
	public static void main(String[] args) {
		System.out.println(allCell(9));
		System.out.println(Arrays.toString(dist));
		System.out.println(count);
	}
	
	static int[] dist = new int[100];
	static int count= 0;
	public static int allCell1(int n){
		
	    if(n>0&&n<4) return 1<<(n-1);
	    if(n==0) return 1;
	    count++;
	    return allCell1(n-1)*2-allCell1(n-4);
	}
	//备忘录法，减少计算次数
	public static int allCell(int n){
		if(n>0&&n<4) dist[n] = 1<<(n-1);
		if(n==0) dist[n] = 1;
		if(dist[n]==0){
			count++;
			dist[n] = allCell(n-1)*2-allCell(n-4);
		}
		return dist[n];
	}
}
