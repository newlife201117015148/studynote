package com.wangle.designPatterns.singleton;

public class Singleton06 {
	//利用内部类来实现单例
	private Singleton06(){}
	static{
		System.out.println("外部类被初始化了");
	}
	private static class InstanceInnerClass{
		private static final Singleton06 instance = new Singleton06();
		static {
			System.out.println("内部类被初始化了");
		}
	}
	//调用该方法的时候内部类才会被加载、初始化。
	public static  Singleton06 getInstance(){
		return InstanceInnerClass.instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton06 instance2 = Singleton06.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
