package com.wangle.Tread;

public class Thread03 extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(100);//出现异常需要捕获是因为还没到时间就被叫醒
			System.out.println("睡到自然醒");
		} catch (InterruptedException e) {
			System.out.println("被叫醒");
		}
	}
	
	public static void main(String[] args) {
		Thread03 test = new Thread03();
		//test.setDaemon(true);//设置子线程为守护线程，跟主线程一起走，不管子线程执行完没
		test.start();
		
		try {
			Thread.sleep(3000);
			test.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
