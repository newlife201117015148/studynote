package com.wangle.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CompanyB implements InvocationHandler{
	private Object obj;
	
	
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getInstance() {
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		dosomethingBefore();
		Object object = method.invoke(obj, args);
		dosomethingAfter();
		return object;
	}

	
	private void dosomethingBefore() {
		System.out.println("beforeB");

	}
	
	private void dosomethingAfter() {
		System.out.println("afterB");

	}
	
}
