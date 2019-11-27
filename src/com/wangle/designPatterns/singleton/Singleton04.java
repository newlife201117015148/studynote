package com.wangle.designPatterns.singleton;

public class Singleton04 {
	private static  Singleton04 instance;
	private Singleton04(){}
	
	public static  Singleton04 getInstance(){//这种会出现多线程访问时不保证是单例的情况
		if(instance == null){
			synchronized(Singleton04.class){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return instance = new Singleton04();
			}
			
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton04 instance2 = Singleton04.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
