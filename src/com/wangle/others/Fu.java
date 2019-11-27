package com.wangle.others;

public class Fu {
	static int a = 1;
	int b = 1;
	static{
		System.out.println("fu静态块执行了， 父类的a："+a);
	}
	{
		System.out.println("fu实例块执行了，父类的b:"+b);
	}
	public Fu(int a,int b){
		this.a = a;
		this.b = b;
		System.out.println("fu父类的构造函数执行了，a的值："+a+"b的值："+b);
	}
}
