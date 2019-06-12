package com.wangle.Tread;


public class ThreadLocalTest {

	static 	ThreadLocal local =new ThreadLocal();
	
	static Object obj = null;
	
	public static void m1(Object o){
		local.set(o);
//		obj = o;
		m2();
	}
	public static void m2(){
		m3();
	}
	public static void m3(){
		m4();
	}
	public static void m4(){
//		System.out.println(Thread.currentThread().getName()+":"+obj);
		System.out.println(Thread.currentThread().getName()+":"+local.get());
	}
}
