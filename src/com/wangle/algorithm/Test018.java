package com.wangle.algorithm;

import java.util.Arrays;

public class Test018 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ��������������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
			
		int[] arr = {5,8,9,6,5};
		lis(arr);

	}
	public static int lis(int[] arr){
		int[] dist = new int[arr.length];//��¼���ǵ�ǰ����λ�õ�������Ϊ��β������������и�����ͨ���������Ǽ����Լ�����ǰ����������ж��ٸ�����С���Լ���
		int max = 0;
		for (int i = 0; i < dist.length; i++) {
			dist[i] = 1;
		}
		//��ѡ������ÿ��Ԫ�ص�����������У������ѡ����Ǹ�
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]&&dist[j]+1>dist[i]){
					dist[i] = dist[j]+1;
				}
			}
			//ѡ���������
			if(max<dist[i]){
				max = dist[i];
			}
		}
		System.out.println(max);
		System.out.println(Arrays.toString(dist));
		return max;
	}

}
