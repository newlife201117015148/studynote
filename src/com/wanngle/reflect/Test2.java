package com.wanngle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * 
   * @类 名： Test2
   * @功能描述：反射机制中访问内部类
   * @作者信息： wangle
   * @创建时间： 2019年5月8日下午3:52:55
   * @修改备注：
 */
public class Test2 {
//	构造获取三个内部类的方法：
	public static void main(String[] args) throws Exception {
//		Java反射获取内部类的实例
//
//		在java中，反射机制能在运行状态中获取任意一个类的所有属性和方法，并可以对该类的某个对象获取其属性的值或执行某个方法。虽然使用反射会降低程序的性能，增加项目复杂度，但是适当的时候使用反射可以使代码更加灵活，如动态代理。 
//		这里重点记录下如何通过反射构造出内部类的实例。内部类分为成员内部类，局部内部类，静态内部类，匿名内部类，这里不考虑局部内部类情况了。 
//		考虑如下类，需要通过反射创建其中三个内部类，匿名内部类是一个属性的值。这里三个内部类的访问权限都是private的。

		 Class clazz = InnerContainer.class;
	        InnerContainer container = (InnerContainer) clazz.newInstance();
	        Class innerClazz[] = clazz.getDeclaredClasses();
	        for (Class cls : innerClazz) {
	            int mod = cls.getModifiers();
	            String modifier = Modifier.toString(mod);
	            if (modifier.contains("static")) {
	                //构造静态内部类实例
//	              Constructor con1 = cls.getDeclaredConstructor();
	                Object obj1 = cls.newInstance();
	                Field field1 = cls.getDeclaredField("f");
	                field1.setAccessible(true);
	                System.out.println(field1.get(obj1));
	            } else {
	                // 构造成员内部类实例
	                Constructor con2 = cls.getDeclaredConstructor(clazz);
	                con2.setAccessible(true);
	                Object obj2 = con2.newInstance(container);
	                Field field2 = cls.getDeclaredField("f");
	                field2.setAccessible(true);
	                System.out.println(field2.get(obj2));
	            }
	        }
	        // 获取匿名内部类实例
	        Field field = clazz.getDeclaredField("r");
	        field.setAccessible(true);
	        Runnable r = (Runnable) field.get(container);
	        r.run();
	}
}
