package com.wangle.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test2 {

	public static void main(String[] args) {
		
		MyInvocationHandler handler = new MyInvocationHandler(new Bird());
		
		Flyable proxy1 = (Flyable)Proxy.newProxyInstance(Flyable.class.getClassLoader(), new Class<?>[]{Flyable.class,Runable.class }, handler);
		Runable proxy2 = (Runable)Proxy.newProxyInstance(Flyable.class.getClassLoader(), new Class<?>[]{Flyable.class,Runable.class }, handler);
		
		String a = proxy1.fly();
		System.out.println(a);
		proxy2.run();

	}

}
