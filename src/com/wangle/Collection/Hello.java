package com.wangle.Collection;

public class Hello {

	
	public synchronized void method1(){
		try {
			System.out.println("method1��ʼ����");
			Thread.sleep(10000);
			System.out.println("method1�������");
		} catch (Exception e) {
		}
	}
	public  void method2(){
		try {
			System.out.println("method2��ʼ����");
			Thread.sleep(10000);
			System.out.println("method2�������");
		} catch (Exception e) {
		}
	}

}
