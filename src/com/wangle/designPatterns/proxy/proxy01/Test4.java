package com.wangle.designPatterns.proxy.proxy01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.ServerSocketChannel;
/**
 * 
   * @�� ���� Test4
   * @���������� JDK��̬���������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��7��11������12:05:53
   * @�޸ı�ע��
 */
public class Test4 implements U {
	public static void main(String[] args) throws Exception {

		Test4 t = new Test4();
		InvocationHandler handler = new Handler(t);
		U a = (U) Proxy.newProxyInstance(Test4.class.getClassLoader(), Test4.class.getInterfaces(), handler);
		
		InvocationHandler handler2 = new Handler2(a);
		U b = (U) Proxy.newProxyInstance(Test4.class.getClassLoader(), Test4.class.getInterfaces(), handler2);
		b.m1();
	}

	public String m1() {

		System.out.println("hhh");

		return "aa";
	}

	@Override
	public String m2() {
		System.out.println("iii");

		return "iii";
	}

	static class Handler implements InvocationHandler {
		U u;

		public Handler(U u) {
			this.u = u;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("aaa");
			Object result = method.invoke(u, new Object[] {});
			System.out.println("bbb");
			return result;
		}

	}
	static class Handler2 implements InvocationHandler {
		U u;

		public Handler2(U u) {
			this.u = u;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("ccc");
			Object result = method.invoke(u, new Object[] {});
			System.out.println("ddd");
			return result;
		}

	}
}
