package com.wangle.designPatterns.proxy.proxy01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 
   * @�� ���� Test3
   * @���������� ͨ��Cglibʵ�ֶ�̬����ײ�ʵ��ԭ����ASM��jdk��̬������ֱ�������ֽ���.
   * 	Cglib�Ĵ����಻��Ҫʵ�ֽӿ�,����Ҳ�����ද̬����.
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��7��10������7:29:41
   * @�޸ı�ע��
 */
public class Test3 {

	public static void main(String[] args) {
		Enhancer en = new Enhancer();
		en.setSuperclass(Bird.class);
		en.setCallback(new MethodInterceptor (){

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				
				System.out.println("before");
				try {
					return  arg3.invokeSuper(arg0, arg2);
				} finally {
					System.out.println("after");
				}
			}
			
		});
		
		Bird proxy = (Bird)en.create();
		proxy.fly();
		
	}

}
