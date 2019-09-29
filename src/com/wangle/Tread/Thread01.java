package com.wangle.Tread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread01 extends Thread{
	
	
	public void run() {
		
		System.out.println("Thread:"+getName());
	}
	
	public static void main(String[] args) {
		//ʲô���̣߳�һ��������ж�������
		//ʲô�ǽ��̣��ڲ���ϵͳ�ϵĶ�����һ���������һ��������QQ���������Ҳ��һ������
		
		
		//����֮�䲻�ܽ������ݷ��ʣ�����ϵͳΪÿ�����̵�������һ���ڴ�ռ䣬
		//  �����������̵��ڴ�ĳ����ľ����ר�ŷ��ʱ�������ڴ�ĺ�����360ɱ������ɨ�����Ƿ�������ຯ�����ж��Ƿ�Ϊľ��  ����Ǹ������򣬵��ǲ���ľ��
		//  �����������ӽ��̣��ӽ���֮����Խ����ڴ����  �����������
		
		//���̵ķ����ڴ�׶ˣ��������̣߳��ڽ���֮�Ͻ��ж�������
		//�߳�֮����Խ������ݷ���
		
		
		
		//����ͨ���̳�Thread��ķ�ʽ�����߳�
		Thread01 thread01 = new Thread01();
		Thread01 thread02 = new Thread01();
		Thread01 thread03 = new Thread01();
		Thread01 thread04 = new Thread01();
		
		
		thread01.start();
		thread02.start();
		thread03.start();
		thread04.start();
		
		
		//ͨ��ʵ��Runnable�ӿڵķ�ʽ�����߳�,
		Thread thread1 = new Thread(new Test01());
		Thread thread2 = new Thread(new Test01());
		Thread thread3 = new Thread(new Test01());
		Thread thread4 = new Thread(new Test01());
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		//ͨ��ʵ��callable�ӿڵķ�ʽ�����߳�,
		Callable<String> call = new myThread();
		FutureTask<String> ft = new FutureTask<>(call);
		Thread mythread = new Thread(ft);
		mythread.start();
		
		
		try {
			System.out.println(ft.isCancelled());
			System.out.println(ft.isDone());
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	
	static class myThread implements Callable<String>{
		private int num = 20;
		@Override
		public String call() throws Exception {
			Thread.sleep(10000);
			for (int i = num; i < num; i--) {
				System.out.println(Thread.currentThread().getName()+"��ǰ��Ʊ��"+i);
			}
			return "sale out";
		}
	}
}
