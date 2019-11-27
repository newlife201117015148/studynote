package com.wangle.others;

public class Zi extends Fu{
	static int c = 2;
	int d = 2;
	static{
		System.out.println("Zi静态块执行了， 子类的c："+c);
	}
	{
		System.out.println("Zi实例块执行了， 子类的d:"+d);
	}
	public Zi(int c ,int d){
		super(c,d);
		this.c = c;
		this.d = d;
		System.out.println("Zi 子类的构造函数执行了，c的值："+c+"d的值："+d);
	}
}
