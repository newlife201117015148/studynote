package com.wangle.Tread;

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
	}

}
