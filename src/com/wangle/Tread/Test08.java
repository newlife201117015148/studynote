package com.wangle.Tread;
/**
 * 
   * @�� ���� Test08
   * @����������???  �ܹ������̣߳�һ�������������������߳�waitting������һ���߳����������notifyAll���������������һ��һ��waiting��һֱ���𣻶�������waittingͬʱ��ȡ��������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��7������4:35:34
   * @�޸ı�ע��
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
				System.out.println(Thread.currentThread().getName()+" �߳̽���");
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
				System.out.println(Thread.currentThread().getName()+" �߳̽���");
			}
		},"task2").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���߳̿�ʼ");
		synchronized (obj) {
			System.out.println("���߳�ͬ����ʼ");
			
			obj.notifyAll();
			System.out.println("���߳�ͬ������");
		}
		System.out.println("���߳̽���");
	}

}
