package com.wangle.designPatterns.proxy.proxy01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 
   * @类 名： Test3
   * @功能描述： Cglib多层叠加失败
   * @作者信息： wangle
   * @创建时间： 2019年7月10日下午7:29:41
   * @修改备注：
 */
public class Test5 {

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
		
		//必能多层嵌套
		Enhancer en2 = new Enhancer();
		en2.setSuperclass(proxy.getClass());
		en2.setCallback(new MethodInterceptor (){

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				
				System.out.println("before2");
				try {
					return  arg3.invokeSuper(arg0, arg2);
				} finally {
					System.out.println("after2");
				}
			}
			
		});
		
		Bird proxy2 = (Bird)en2.create();
		proxy2.fly();
	}

}
