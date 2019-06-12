package com.wanngle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * 
   * @�� ���� Test2
   * @������������������з����ڲ���
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��8������3:52:55
   * @�޸ı�ע��
 */
public class Test2 {
//	�����ȡ�����ڲ���ķ�����
	public static void main(String[] args) throws Exception {
//		Java�����ȡ�ڲ����ʵ��
//
//		��java�У����������������״̬�л�ȡ����һ������������Ժͷ����������ԶԸ����ĳ�������ȡ�����Ե�ֵ��ִ��ĳ����������Ȼʹ�÷���ή�ͳ�������ܣ�������Ŀ���Ӷȣ������ʵ���ʱ��ʹ�÷������ʹ����������綯̬���� 
//		�����ص��¼�����ͨ�����乹����ڲ����ʵ�����ڲ����Ϊ��Ա�ڲ��࣬�ֲ��ڲ��࣬��̬�ڲ��࣬�����ڲ��࣬���ﲻ���Ǿֲ��ڲ�������ˡ� 
//		���������࣬��Ҫͨ�����䴴�����������ڲ��࣬�����ڲ�����һ�����Ե�ֵ�����������ڲ���ķ���Ȩ�޶���private�ġ�

		 Class clazz = InnerContainer.class;
	        InnerContainer container = (InnerContainer) clazz.newInstance();
	        Class innerClazz[] = clazz.getDeclaredClasses();
	        for (Class cls : innerClazz) {
	            int mod = cls.getModifiers();
	            String modifier = Modifier.toString(mod);
	            if (modifier.contains("static")) {
	                //���쾲̬�ڲ���ʵ��
//	              Constructor con1 = cls.getDeclaredConstructor();
	                Object obj1 = cls.newInstance();
	                Field field1 = cls.getDeclaredField("f");
	                field1.setAccessible(true);
	                System.out.println(field1.get(obj1));
	            } else {
	                // �����Ա�ڲ���ʵ��
	                Constructor con2 = cls.getDeclaredConstructor(clazz);
	                con2.setAccessible(true);
	                Object obj2 = con2.newInstance(container);
	                Field field2 = cls.getDeclaredField("f");
	                field2.setAccessible(true);
	                System.out.println(field2.get(obj2));
	            }
	        }
	        // ��ȡ�����ڲ���ʵ��
	        Field field = clazz.getDeclaredField("r");
	        field.setAccessible(true);
	        Runnable r = (Runnable) field.get(container);
	        r.run();
	}
}
