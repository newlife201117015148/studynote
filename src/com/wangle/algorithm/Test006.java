package com.wangle.algorithm;

import java.util.Arrays;
/**
 * 
   * @�� ���� Test006
   * @���������� �ݹ�ʵ�ֶ��ֲ��ҷ�
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��10��19������5:32:20
   * @�޸ı�ע��
 */
public class Test006 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int result = sum(a);
		System.out.println(result);
		System.out.println(erfen(a,10));
	}
	
	public static int sum(int[] a){
		if(a.length==1) return a[0];
		if(a.length==0) return 0;
		if(a[0]>a[1]){
			a[0] ^= a[1];
			a[1] ^= a[0];
			a[0] ^= a[1];
		}
		int[] b= new int[a.length-1];
		System.arraycopy(a, 1, b, 0, b.length);
		return sum(b);
	}
	
	public static int erfen(int[] a,int b){
		if(a.length==1) return a[0]==b?1:0;
		if(a.length==0) return 0;
		Arrays.sort(a);
		int mid = a.length/2;
		int[] c= new int[a.length-mid];
		if(a[mid-1]<b){
			System.arraycopy(a, mid, c, 0, a.length-mid);
		}else if(a[mid-1]>b){
			System.arraycopy(a, 0, c, 0, mid);
		}else{
			return 1;
		}
		return erfen(c,b);
	}
}
