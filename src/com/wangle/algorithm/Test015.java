package com.wangle.algorithm;

import java.util.Scanner;

public class Test015 {

	/**
	 * 
	   * @Title : main 
	   * @��������: ��̬�滮�㷨��ϰ��1,5,11����Ǯ������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		initDist();
		System.out.println(f2(80));
	}
	//������¶��ϣ�tabulated Version
	@SuppressWarnings("resource")
	public static void method(){
		int[] f = new int[100];
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(),cost;
		
		f[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			cost = Integer.MAX_VALUE;
			if(i>=1) cost = Math.min(cost, f[i-1]+1);
			if(i>=5) cost = Math.min(cost, f[i-5]+1);
			if(i>=11) cost = Math.min(cost, f[i-11]+1);
			
			f[i] = cost;
			System.out.println("f["+i+"]="+f[i]);
		}
		System.out.println(f[n]);
	}
	
	static int[] dist = new int[1000];
	
	public static void  initDist(){
		for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
	}
	
	//���仯���棨���϶��£�memoized version //���n=15������ջ��������15
	public static int f(int n){
		
		if(n==0){
			dist[n] =  0;
		}
		int cost;
		if(dist[n]==-1){
			System.out.println(count++);
			cost = Integer.MAX_VALUE;
			if(n>=1) cost = Math.min(cost, f(n-1)+1);
			if(n>=5) cost = Math.min(cost, f(n-5)+1);
			if(n>=11) cost = Math.min(cost, f(n-11)+1);
			
			dist[n] = cost;
		}else{
			cost = dist[n];
		}
		return cost;
	}
	static int count = 1;
	//recursive version //���n=15������ջ��������115
	public static int f2(int n){
		if(n==0){
			return 0;
		}
		int cost;
		cost = Integer.MAX_VALUE;
		if(n>=1) cost = Math.min(cost, f2(n-1)+1);
		if(n>=5) cost = Math.min(cost, f2(n-5)+1);
		if(n>=11) cost = Math.min(cost, f2(n-11)+1);
		
		return cost;
	}
}
