package com.wangle.designPatterns.singleton;

public class Singleton01 {
	//不仅保证了单例，而且还是线程安全的。
	//通常来说这是最简单相对安全的写法。
	//缺点是管你用不用对象，只要类初始化了，都会实例化对象，给对象分配堆空间。
	private final static  Singleton01 instance= new Singleton01();
	private Singleton01(){}
	
	public Singleton01 getInstance(){
		return instance;
	}
}
