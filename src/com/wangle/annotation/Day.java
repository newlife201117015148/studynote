package com.wangle.annotation;
import java.lang.annotation.*;

//ע����൱�ڽӿڣ�ֻ���巽��������ʵ�������õ�ʱ��ʵ�ֵġ�


//@Target(ElementType.ANNOTATION_TYPE) ע�����д�ڽӿڡ��ࡢö�١�ע����
//@Target(ElementType.CONSTRUCTOR)  ��������
//@Target(ElementType.FIELD)  �ֶΡ�ö�ٵĳ���
//@Target(ElementType.LOCAL_VARIABLE) ������
//@Target(ElementType.METHOD) ������
//@Target(ElementType.PACKAGE) ����
//@Target(ElementType.PARAMETER) ������
//@Target(ElementType.TYPE) ����
@Target(value={ElementType.PARAMETER,ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.METHOD,ElementType.PACKAGE})
//@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD}) Ҳ���Բ�дvalue
//@Retention(RetentionPolicy.SOURCE)   //ע���������Դ���У���class�ֽ����ļ��в�����
//@Retention(RetentionPolicy.CLASS)     // Ĭ�ϵı������ԣ�ע�����class�ֽ����ļ��д��ڣ�������ʱ�޷���ã�
//@Retention(RetentionPolicy.RUNTIME)  // ע�����class�ֽ����ļ��д��ڣ�������ʱ����ͨ�������ȡ��
@Retention(value=RetentionPolicy.RUNTIME) //Ĭ����RetentionPolicy.CLASS
//@Inherited��˵��������Լ̳и����еĸ�ע��
//@Document��˵����ע�⽫��������javadoc��
public @interface Day {
	// ����Ҫ�з������ͣ��������ַ���   	ö������ 	class����   ע������    ������������   ���������е�����һ����һά����
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
