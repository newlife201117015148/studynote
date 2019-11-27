package com.wangle.others;

public class Son extends Father{
	static String i;
	public Son(){
		i = "10";
		System.out.println("SON");
	}
	
	public void method(){
		System.out.println(i);
	}
	//运行过程：先加载父类，调用父类的无参构造方法-->发现构造函数调用了method()方法，并且该方法被子类重写了-->调用子类的method()方法-->发现method()方法需要打印子类的一个无论是静态或者实例成员的值
	//-->但是按照java规则先加载父类，后加载子类的说法，子类还没有创建对象，不能访问无论静态或者实例成员，所以这时虚拟机只有先给出初始值。
	//总结
	//先加载父类，后加载子类。
	//先调用子类的方法，再调用父类的方法.（重写方法）
}
