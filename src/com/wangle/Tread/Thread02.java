package com.wangle.Tread;

public class Thread02 extends Thread{

	public static void getmethod(){}
	public void run() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// main线程是主线程，thread01等等都是main线程的分支，称为子线程
		// 主线程要等子线程执行完了，才会停，如果主线程有程序要执行，不管子线程执行完没有，他都要执行。
		Thread02 thread02 = new Thread02();
		thread02.start();
		System.out.println("主线程");
		//获取当前线程
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getId());
		System.out.println(currentThread.getName());
		System.out.println(currentThread.getPriority());//获取优先级
		
//		currentThread.stop();//线程停止运行，不再执行后面的代码
		//sleep()是静态方法，只能控制当前正在运行的线程。
		
		
		//线程状态
		
//		currentThread.getState().NEW   新建状态
//		currentThread.getState().WAITING  无时间限制等待  调用wait（）方法  通过notify或者notifyAll叫醒
//		currentThread.getState().TIMED_WAITING  有时间限制等待  调用sleep（时间）方法 通过interrupt方法叫醒
//		currentThread.getState().RUNNABLE  运行状态
//		currentThread.getState().TERMINATED  死亡状态，执行完run方法或者调用stop（）非正常死亡
//		currentThread.getState().BLOCKED  排队等待cpu分配时间片的状态，同步的时候
		//start（）方法调用后，等待cpu分配时间片，之后执行run（）方法，执行完后正常死亡
	}
}
