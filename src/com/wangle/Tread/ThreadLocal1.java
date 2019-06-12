package com.wangle.Tread;

public class ThreadLocal1 extends Thread{
	private String name = null;
	public ThreadLocal1(String name){
		this.name =name;
	}
	public static void main(String[] args) {
		//为什么有ThreadLocal出现
		//场景：test1()调用test2()调用test3()调用test4()，在test1()中设定一个值，想传给test4()，可以将这个设置为公共值，test1()赋值后，test4()直接去取，
		//     但是多个线程跑这个流程的话，会出现值的覆盖.最大的前提这些方法都是静态的，因为是实例的话就不存在线程问题了
		ThreadLocal1 local1 = new ThreadLocal1("test1");
		ThreadLocal1 local2 = new ThreadLocal1("test2");
		ThreadLocal1 local3 = new ThreadLocal1("test3");
		ThreadLocal1 local4 = new ThreadLocal1("test4");
		
		local1.start();
		local2.start();
		local3.start();
		local4.start();
		
	}

	@Override
	public void run() {
		
		ThreadLocalTest.m1(name);
	} 
}
