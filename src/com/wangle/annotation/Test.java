package com.wangle.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

import com.wangle.packages.*;
@Day(value = "dadf",key="asdfa")
public class Test {
	@Day(value = "dadf",key="asdfa")
	public Test() {
		// TODO Auto-generated constructor stub
	}
	@Day(value = "dadf",key="asdfa")
	private String name;
	@Day(value = "dadf",key="asdfa")
	public void method(@Day(value = "dadf11",key="asdfa22") @Day2(value = "dadf11",key="asdfa22") String type,@Day(key="asdfa22") String type2){
		@Day(value = "dadf",key="asdfa")
		String str = "";
		System.out.println("type:"+type+"----type2:"+type2);
	}
	
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.wangle.annotation.Test");
		boolean hasannotation = clazz.isAnnotationPresent(Day.class);//判断Test类上是否有注解类型Day的注解
		//获取类上的注解
		if(hasannotation){
			Annotation[] annotations = clazz.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation.toString());
				Day day = (Day)annotation;
				System.out.println("value:"+day.value()+"--key:"+day.key());
			}
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			hasannotation = method.isAnnotationPresent(Day.class);
			//这是方法上的注解
			if(hasannotation){
				Annotation[] annotations = method.getDeclaredAnnotations();
				for (Annotation annotation : annotations) {
					Day d = (Day)annotation;
					System.out.println(method.getName()+":");
					System.out.println("key:"+d.key()+"-----value:"+d.value());
				}
				
				//这是方法中参数的注解
				Annotation[][] annotations2 = method.getParameterAnnotations();
				Object[] obj = new Object[annotations2.length];
				int i =0;
				for (Annotation[] annotations3 : annotations2) {
					for (Annotation annotation2 : annotations3) {
						if (annotation2 instanceof Day) {
							obj[i++] = ((Day)annotation2).value();
						}
					}
				}
				method.invoke(clazz.newInstance(),obj );
			}
		}
	}
}
