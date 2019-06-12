package com.wangle.Collection;

public class Hello {

	
	public synchronized void method1(){
		try {
			System.out.println("method1开始调用");
			Thread.sleep(10000);
			System.out.println("method1调用完毕");
		} catch (Exception e) {
		}
	}
	public  void method2(){
		try {
			System.out.println("method2开始调用");
			Thread.sleep(10000);
			System.out.println("method2调用完毕");
		} catch (Exception e) {
		}
	}

}
