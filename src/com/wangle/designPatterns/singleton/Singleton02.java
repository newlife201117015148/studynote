package com.wangle.designPatterns.singleton;

public class Singleton02 {
	private static  Singleton02 instance;
	private Singleton02(){}
	
	public static Singleton02 getInstance(){
		if(instance == null){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return instance = new Singleton02();
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton02 instance2 = Singleton02.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
