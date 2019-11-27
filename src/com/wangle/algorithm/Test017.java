package com.wangle.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Test017 {
	static int[][] arr = new int[10][10];
	static int[] max;
	static int n;
	/**
	 * 
	   * @Title : main （动态规划的应用）
	   * @功能描述: 数字塔问题（改进），塔顶到底边的路径，使之路径上的组合后相加结果最大，并要求路径上的每一步都只能往左下或 右下走
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(final String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = scanner.nextInt();
				
			}
		}
		max = arr[n];
		for (int i = n-1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				max[j] = arr[i][j] + Math.max(max[j],max[j+1]);
			}
		}
		
		System.out.println(Arrays.toString(max));
	}
	
}