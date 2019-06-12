package com.wangle.annotation;
import java.lang.annotation.*;

//注解就相当于接口，只定义方法，具体实现是在用的时候实现的。


//@Target(ElementType.ANNOTATION_TYPE) 注解可以写在接口、类、枚举、注解上
//@Target(ElementType.CONSTRUCTOR)  构造器上
//@Target(ElementType.FIELD)  字段、枚举的常量
//@Target(ElementType.LOCAL_VARIABLE) 变量上
//@Target(ElementType.METHOD) 方法上
//@Target(ElementType.PACKAGE) 包上
//@Target(ElementType.PARAMETER) 参数上
//@Target(ElementType.TYPE) 类上
@Target(value={ElementType.PARAMETER,ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PACKAGE})
//@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD}) 也可以不写value
//@Retention(RetentionPolicy.SOURCE)   //注解仅存在于源码中，在class字节码文件中不包含
//@Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
//@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(value=RetentionPolicy.RUNTIME) //默认是RetentionPolicy.CLASS
//@Inherited：说明子类可以继承父类中的该注解
//@Document：说明该注解将被包含在javadoc中
public @interface Day {
	// 必须要有返回类型，包括：字符串   	枚举类型 	class类型   注解类型    基本数据类型   或者他们中的任意一个的一维数组
	String value()  default "";
	String key() default "";
	String d() default "";
	int[] c() default 1;
	double[] e() default 0;
	long[] a() default 0;
	char[] b() default 0;
	byte[] f() default 0;
	float[] h() default 0;
	boolean[] g() default true;
	short[] i() default 0;
	Const[] j() default Const.FRUIT_APPLE;
	Class[] k() default Integer.class;
	Day2[] l() default @Day2;
}
