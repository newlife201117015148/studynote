package com.wangle.designPatterns.singleton;

public class Singleton03 {
	private static  Singleton03 instance;
	private Singleton03(){}
	
	public static synchronized Singleton03 getInstance(){//���ֲ�����ֶ��̷߳���ʱ����֤�ǵ��������
		if(instance == null){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return instance = new Singleton03();
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton03 instance2 = Singleton03.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
