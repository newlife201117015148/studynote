package com.wangle.Tread;

public class Thread10 extends Thread{

	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(this.getName().equals("路人甲")){
				this.yield();//让出时间片
			}
			Thread10.method();
		}
	}
	public static synchronized void method(){
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		
		Thread10 test1 = new Thread10();
		Thread10 test2 = new Thread10();
		test1.setName("路人甲");
		test2.setName("路人乙");
		//设置优先级
//		test1.setPriority(MIN_PRIORITY);
//		test2.setPriority(MAX_PRIORITY);
		
		test1.start();
		test2.start();
	}
}
