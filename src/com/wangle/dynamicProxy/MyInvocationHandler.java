package com.wangle.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Bird bird;
	public MyInvocationHandler(Bird bird) {
		this.bird = bird;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("fly is started");
		Object obj = method.invoke(bird, new Object[0]);
		System.out.println("fly is end");
		return obj;
	}

}
