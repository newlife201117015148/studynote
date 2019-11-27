package com.wangle.others;

public class ThreadTest1 implements Runnable{
	static int num = 0;
	public ThreadTest1(){
		num++;
	}
	public void run() {
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i);
//		}
		System.out.println(num);
	}
	
	
}
