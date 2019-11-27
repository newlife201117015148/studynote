package com.wangle.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Test017 {
	static int[][] arr = new int[10][10];
	static int[] max;
	static int n;
	/**
	 * 
	   * @Title : main ����̬�滮��Ӧ�ã�
	   * @��������: ���������⣨�Ľ������������ױߵ�·����ʹ֮·���ϵ���Ϻ���ӽ����󣬲�Ҫ��·���ϵ�ÿһ����ֻ�������»� ������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
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