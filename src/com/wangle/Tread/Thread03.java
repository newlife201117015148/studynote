package com.wangle.Tread;

public class Thread03 extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(100);//�����쳣��Ҫ��������Ϊ��û��ʱ��ͱ�����
			System.out.println("˯����Ȼ��");
		} catch (InterruptedException e) {
			System.out.println("������");
		}
	}
	
	public static void main(String[] args) {
		Thread03 test = new Thread03();
		//test.setDaemon(true);//�������߳�Ϊ�ػ��̣߳������߳�һ���ߣ��������߳�ִ����û
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
