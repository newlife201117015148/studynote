package com.wangle.others;

abstract class MyAbstract {
	static{}
	static int a = 2;
	int b = 2 ;
	{};
	static void method(){}
	void method(int a){}
	abstract void method(String a);
	
	//总结：抽象类和普通类的主要区别：
	//1.抽象类不能实例化对象，而普通类可以。
	//2.抽象类可以含有抽象方法（不一定必须有），权限修饰符只有public或者protected，而且子类必须实现它的抽象方法。
	//3.类修饰符只能是public abstract
}
