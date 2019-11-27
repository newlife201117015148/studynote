package com.wangle.algorithm;

public class Test019 {
//	ϸ������ ��һ��ϸ�� ÿһ��Сʱ����һ�Σ�һ�η���һ����ϸ����������Сʱ�����������ôn��Сʱ���ж���ϸ����
	// a ��ʼ̬ һ��Сʱ ǰһ��Сʱ�� a+b+c
	// b ����̬ ����Сʱ ǰһ��Сʱ�� a
	// c ����̬ ����Сʱ ǰһ��Сʱ�� b
	
	public static void main(String[] args) {
		System.out.println(allCell(4));
		System.out.println(allCell(5));
		System.out.println(allCell(6));
		System.out.println(allCell(7));
		System.out.println(allCell(8));
	}
	
	
	public static int allCell(int n){
	    return aCell(n)+bCell(n)+cCell(n);
	}
	 // a̬ϸ��
	public static int aCell (int n){
        if(n==1){
            return 1;
        }else{
            return aCell(n-1)+bCell(n-1)+cCell(n-1);
        }
    }
    // b̬ϸ��
	public static int bCell (int n){
        if(n==1){
            return 0;
        }else{
            return aCell(n-1);
        }
    }
    // c̬ϸ��
	public static int cCell (int n){
        if(n==1||n==2){
            return 0;
        }else{
            return bCell(n-1);
        }
    }
}
