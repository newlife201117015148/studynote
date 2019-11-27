package com.wangle.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Test016 {
	static int[][] arr = new int[100][100];
	static int[][] max = new int[100][100];
	static int n;
	/**
	 * 
	   * @Title : main ����̬�滮��Ӧ�ã�
	   * @��������: ���������⣬�������ױߵ�·����ʹ֮·���ϵ���Ϻ���ӽ����󣬲�Ҫ��·���ϵ�ÿһ����ֻ�������»� ������
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
				max[i][j] = -1;
			}
		}
		System.out.println(getMaxSum(1,1));
		System.out.println(Arrays.deepToString(max));
	}
	
	public static int getMaxSum(int i,int j){
		if(max[i][j]==-1){
			if(i==n) max[i][j] = arr[n][j];
			
			int next = Math.max(getMaxSum(i+1,j),getMaxSum(i+1,j+1));
			max[i][j] = arr[i][j]+next;
		}
		return max[i][j];
		
	} 
}