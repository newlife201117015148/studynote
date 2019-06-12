package com.wanngle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * 
   * @类 名： Test1
   * @功能描述： 反射的基础
   * @作者信息： wangle
   * @创建时间： 2019年5月8日下午3:52:20
   * @修改备注：
 */
//1、当程序运行时，允许改变程序结构或变量类型，这种语言称为动态语言。我们认为java并不是动态语言，但是它却有一个非常突出的动态相关机制，俗称：反射。
//IT行业里这么说，没有反射也就没有框架，现有的框架都是以反射为基础。在实际项目开发中，用的最多的是框架，填的最多的是类，反射这一概念就是将框架和类揉在一起的调和剂。所以，反射才是接触项目开发的敲门砖。
//
//2、java中的new方法是静态加载，因为new方法是在编译阶段就会检查，而不是在运行阶段。反射是可以在运行时创建对象，调用对象的方法、变量等。
//
//3、Java反射机制主要提供了以下功能：在运行时判断任意一个对象所属的类；在运行时构造任意一个类的对象；在运行时判断任意一个类所具有的成员变量和方法；在运行时调用任意一个对象的方法；生成动态代理。
public class Test1 {
	public  static String name = "wangle";
	private String sex;
	private int age;
	private String address;

	public Test1(String sex, int age, String address) {
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	public Test1() {
	}

	public static void main(String[] args) throws Exception {
		// 反射一种灵活编码机制 称为软编码

		// Class类是反射机制的重要基础类
		// Class类是"类的类"(class of classes)。如果说类是对象的抽象和集合的话，那么Class类就是对类的抽象和集合。
		//
		// 每一个Class类的对象代表一个其他的类。

		// 获取class的方法总共三种
		Class classs = Test1.class;
		Class class1 = new Test1().getClass();
		Class class2 = Class.forName("com.wanngle.reflect.Test1");

		Test1 test1 = new Test1();
		test1.setSex("男");
		test1.setAge(12);
		test1.setAddress("中国成都");
		
		
		
		// 通过class可以获取到该类的属性，方法，构造器
		System.out.println("---------------------------------------------------");
		// 属性
		// 通过指定属性名获取单个public属性,包括父类的public属性
		Field field1 = classs.getField("name");
		// 获取属性名字
		System.out.println("属性名："+field1.getName());
		// 获取类型
		System.out.println("属性类型："+field1.getType().getSimpleName());
		// field1.getModifiers()得到的是一个int类型的数字，需要用修饰符工具类Modifier进行转换
		System.out.println("属性修饰符："+Modifier.toString(field1.getModifiers()));
		// 获取属性的全部信息
		System.out.println("属性全部信息："+field1.toString());
		// 获取属性值
		System.out.println("属性值："+field1.get(test1));

		// 通过指定属性名获取单个不仅是public属性
		Field field = classs.getDeclaredField("sex");
		// 获取属性名字
		System.out.println("属性名："+field.getName());
		// 获取类型
		System.out.println("属性类型："+field.getType().getSimpleName());
		// field1.getModifiers()得到的是一个int类型的数字，需要用修饰符工具类Modifier进行转换
		System.out.println("属性修饰符："+Modifier.toString(field.getModifiers()));
		// 获取属性的全部信息
		System.out.println("属性全部信息："+field.toString());
		// 获取属性值
		System.out.println("属性值："+field.get(test1));
		// 获取属性数组
		System.out.println("获取属性数组：");
		// classs.getFields();获取的只是public的属性
		Field[] declaredFields = classs.getDeclaredFields();// 可以获取所有的属性
		for (Field field2 : declaredFields) {
			System.out.println("属性：" + Modifier.toString(field2.getModifiers()) + " "
					+ field2.getType().getSimpleName() + " " + field2.getName() + "  属性值：" + field2.get(test1));
		}
		System.out.println("field的其他方法：");
		field1.setAccessible(true);
		field1.isAccessible();
		field1.set(test1, "张三");
		System.out.println(test1.name);
		System.out.println("---------------------------------------------------");
		
		
		
		
		
		// 获取构造器
		// 通过参数的选择获取单个构造器
		Constructor con = class1.getDeclaredConstructor(String.class, int.class, String.class);
		// Constructor con2 = class1.getDeclaredConstructor(new
		// Class[]{String.class,int.class,String.class});
		System.out.println("构造器名：" +con.getName());
		// 修饰符
		System.out.println("构造器修饰符：" +Modifier.toString(con.getModifiers()));
		// 获取参数类型
		Class[] parameters = con.getParameterTypes();
		for (Class class3 : parameters) {
			System.out.println("构造器参数类型：" +class3.getName());
		}
		// 利用构造器获得对象
		Object obj = con.newInstance("女", 25, "四川");
		Test1 t = (Test1) obj;
		System.out.println("通过构造器new出的对象：" );
		System.out.println(t.getAddress());
		System.out.println(t.getAge());
		System.out.println(t.getSex());
		
		// 获取所有的构造器
		System.out.println("获取所有的构造器：" );
		Constructor[] cons = class1.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.print(Modifier.toString(constructor.getModifiers()) + " "
					+ constructor.getName().substring(constructor.getName().lastIndexOf(".") + 1) + "(");
			Class[] conss = constructor.getParameterTypes();
			for (Class class3 : conss) {
				System.out.print(class3.getSimpleName() + "  ");
			}
			System.out.print(")");
			System.out.println();
		}
		//反射有两种方式获取对象
		classs.newInstance();//调用是默认的无参构造器
		con.newInstance("女", 25, "四川");//可以调用任意构造器
		
		con.getExceptionTypes();
		con.setAccessible(true);
		System.out.println("---------------------------------------------------");
		
		
		
		
		//获取方法
		System.out.println("获取所有的方法:");
		Method[] methods = class2.getDeclaredMethods();
		
		for (Method method : methods) {
			System.out.print(Modifier.toString(method.getModifiers()) + " "+method.getReturnType().getSimpleName()+" "
					+ method.getName().substring(method.getName().lastIndexOf(".") + 1) + "(");
			Class[] conss = method.getParameterTypes();
			for (Class class3 : conss) {
				System.out.print(class3.getSimpleName() + "  ");
			}
			System.out.print(")");
			System.out.println();
			
		}
		System.out.println("调用方法：");
		Test1 obj1 = (Test1)class2.newInstance();
		obj1.method();
		
		class2.getDeclaredMethod("method", null).invoke(obj1, null);//如果是静态方法obj1为null
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}
	
	private void method(){
		System.out.println("method方法被调用了");
	}
}
