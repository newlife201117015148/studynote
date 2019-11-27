package com.wangle.designPatterns.proxy.proxy01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 
   * @类 名： Test3
   * @功能描述： 通过Cglib实现动态代理底层实现原理是ASM，jdk动态代理是直接生成字节码.
   * 	Cglib的代理类不需要实现接口,所以也叫子类动态代理.
   * @作者信息： wangle
   * @创建时间： 2019年7月10日下午7:29:41
   * @修改备注：
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
