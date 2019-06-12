package com.wangle.Tread;
/**
 * 
   * @类 名： Test08
   * @功能描述：???  总共三个线程，一个对象锁，其中两个线程waitting，另外一个线程锁对象调用notifyAll，出现两种情况：一是一个waiting被一直挂起；二是两个waitting同时获取到对象锁
   * @作者信息： wangle
   * @创建时间： 2019年5月7日下午4:35:34
   * @修改备注：
 */
public class Test08 {

	public static void main(String[] args) {
		final  Object obj = new Object();
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("task1 is start...");
				synchronized (obj) {
					System.out.println(Thread.currentThread().getName()+" synchronized method is beginning");
					try {
						Thread.sleep(1000);
						System.out.println("task1 is waitting");
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" synchronized method is ending");
				}
				for (int i = 0; i < 40; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("task1:"+i);
				}
				System.out.println(Thread.currentThread().getName()+" 线程结束");
			}
		},"task1").start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("task2 is start...");
				synchronized (obj) {
					System.out.println(Thread.currentThread().getName()+" synchronized method is beginning");
					try {
						Thread.sleep(1000);
						System.out.println("task2 is waitting");
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" synchronized method is ending");
				}
				for (int i = 0; i < 40; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("task2:"+i);
				}
				System.out.println(Thread.currentThread().getName()+" 线程结束");
			}
		},"task2").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("主线程开始");
		synchronized (obj) {
			System.out.println("主线程同步开始");
			
			obj.notifyAll();
			System.out.println("主线程同步结束");
		}
		System.out.println("主线程结束");
	}

}
