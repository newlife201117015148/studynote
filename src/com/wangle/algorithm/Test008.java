package com.wangle.algorithm;

import java.util.Arrays;
public class Test008 {
	/**
	 * 
	   * @Title : main 
	   * @��������: С���������㷨����
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		int[] arr = {4,2,3,4,1};
		System.out.println(Arrays.toString(arr));
		int result = sum(arr);
		System.out.println(result);
	}
	
	public static int sum(int[] ratings){
		
		 int len=ratings.length;
	        if(len==1) return 1;
	        int sum=0;
	        int[] v = new int[len];
	        for (int i = 0; i < v.length; i++) {
				v[i] = 1;
			}
	        //��������ɨ�裬��֤һ�������Ϸ���������ǹ�����
	        for(int i=1;i<len;i++){
	            if(ratings[i] > ratings[i-1])
	                v[i]=v[i-1]+1;
	        }
	        System.out.println(Arrays.toString(v));
	        //��������ɨ�裬��֤��һ�������Ϸ���������ǹ�����
	        for(int i=len-2;i>=0;i--){
	            if(ratings[i] > ratings[i+1] && v[i] <= v[i+1])
	                v[i]=v[i+1]+1;
	        }
	        System.out.println(Arrays.toString(v));
	        for(int i=0;i<len;i++){
	            sum+=v[i];
	        }
	        return sum;	        
	}
	
}
