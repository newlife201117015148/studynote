package com.wangle;

public abstract interface MyInterface {
	public static final int a=1;
	void method();
	
	//总结：
	//1.接口中的变量会被隐式地指定为public static final变量
	//2.方法会被隐式地指定为public abstract方法且只能是public abstract方法，也就是说，接口中的方法必须都是抽象方法。
}
