package com.wangle;

public class ThreadTest2 implements Runnable{
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("这是线程2: "+i);
		}
	}
	
	

}
