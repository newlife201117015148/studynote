package com.wangle.Tread;

public class Number1 extends Thread{
	static int i =0;
	private int thread;
	public Number1(int thread){
		this.thread = thread;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":��ʼ...");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName()+":ͬ����ʼ��������");
			while(i<75){
				if(i/5%3+1 == thread){
					System.out.println(Thread.currentThread().getName()+":"+(++i));
					System.out.println(Thread.currentThread().getName()+":ִ��notify��������");
					String.class.notify();
				}else{
					try {
						System.out.println(Thread.currentThread().getName()+":��������������ʼ����waitting��������");
						String.class.wait();//�߳�һ��������������͵ȴ������ѣ����Ѻ�����ִ���ϴ�wait�����ĺ������
						System.out.println(Thread.currentThread().getName()+":�����ѡ�����");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(Thread.currentThread().getName()+":ͬ������...");
		}
		System.out.println(Thread.currentThread().getName()+":�߳̽���");
	}

}
