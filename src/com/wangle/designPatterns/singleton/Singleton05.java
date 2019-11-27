package com.wangle.designPatterns.singleton;

public class Singleton05 {
	//双重检查确保了是单例，没错，但是！因为java的jit的重排序导致，得到的单例对象可能是个没有初始化的值
	//所以必须加volatile关键字
	private static volatile  Singleton05 instance;
	private Singleton05(){}
	
	public static  Singleton05 getInstance(){
		if(instance == null){
			synchronized(Singleton05.class){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(instance == null){
					return instance = new Singleton05();
				}
				
			}
			
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton05 instance2 = Singleton05.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
