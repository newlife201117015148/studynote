package com.wanngle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * 
   * @�� ���� Test1
   * @���������� ����Ļ���
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��8������3:52:20
   * @�޸ı�ע��
 */
//1������������ʱ������ı����ṹ��������ͣ��������Գ�Ϊ��̬���ԡ�������Ϊjava�����Ƕ�̬���ԣ�������ȴ��һ���ǳ�ͻ���Ķ�̬��ػ��ƣ��׳ƣ����䡣
//IT��ҵ����ô˵��û�з���Ҳ��û�п�ܣ����еĿ�ܶ����Է���Ϊ��������ʵ����Ŀ�����У��õ������ǿ�ܣ�����������࣬������һ������ǽ���ܺ�������һ��ĵ��ͼ������ԣ�������ǽӴ���Ŀ����������ש��
//
//2��java�е�new�����Ǿ�̬���أ���Ϊnew�������ڱ���׶ξͻ��飬�����������н׶Ρ������ǿ���������ʱ�������󣬵��ö���ķ����������ȡ�
//
//3��Java���������Ҫ�ṩ�����¹��ܣ�������ʱ�ж�����һ�������������ࣻ������ʱ��������һ����Ķ���������ʱ�ж�����һ���������еĳ�Ա�����ͷ�����������ʱ��������һ������ķ��������ɶ�̬����
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
		// ����һ����������� ��Ϊ�����

		// Class���Ƿ�����Ƶ���Ҫ������
		// Class����"�����"(class of classes)�����˵���Ƕ���ĳ���ͼ��ϵĻ�����ôClass����Ƕ���ĳ���ͼ��ϡ�
		//
		// ÿһ��Class��Ķ������һ���������ࡣ

		// ��ȡclass�ķ����ܹ�����
		Class classs = Test1.class;
		Class class1 = new Test1().getClass();
		Class class2 = Class.forName("com.wanngle.reflect.Test1");

		Test1 test1 = new Test1();
		test1.setSex("��");
		test1.setAge(12);
		test1.setAddress("�й��ɶ�");
		
		
		
		// ͨ��class���Ի�ȡ����������ԣ�������������
		System.out.println("---------------------------------------------------");
		// ����
		// ͨ��ָ����������ȡ����public����,���������public����
		Field field1 = classs.getField("name");
		// ��ȡ��������
		System.out.println("��������"+field1.getName());
		// ��ȡ����
		System.out.println("�������ͣ�"+field1.getType().getSimpleName());
		// field1.getModifiers()�õ�����һ��int���͵����֣���Ҫ�����η�������Modifier����ת��
		System.out.println("�������η���"+Modifier.toString(field1.getModifiers()));
		// ��ȡ���Ե�ȫ����Ϣ
		System.out.println("����ȫ����Ϣ��"+field1.toString());
		// ��ȡ����ֵ
		System.out.println("����ֵ��"+field1.get(test1));

		// ͨ��ָ����������ȡ����������public����
		Field field = classs.getDeclaredField("sex");
		// ��ȡ��������
		System.out.println("��������"+field.getName());
		// ��ȡ����
		System.out.println("�������ͣ�"+field.getType().getSimpleName());
		// field1.getModifiers()�õ�����һ��int���͵����֣���Ҫ�����η�������Modifier����ת��
		System.out.println("�������η���"+Modifier.toString(field.getModifiers()));
		// ��ȡ���Ե�ȫ����Ϣ
		System.out.println("����ȫ����Ϣ��"+field.toString());
		// ��ȡ����ֵ
		System.out.println("����ֵ��"+field.get(test1));
		// ��ȡ��������
		System.out.println("��ȡ�������飺");
		// classs.getFields();��ȡ��ֻ��public������
		Field[] declaredFields = classs.getDeclaredFields();// ���Ի�ȡ���е�����
		for (Field field2 : declaredFields) {
			System.out.println("���ԣ�" + Modifier.toString(field2.getModifiers()) + " "
					+ field2.getType().getSimpleName() + " " + field2.getName() + "  ����ֵ��" + field2.get(test1));
		}
		System.out.println("field������������");
		field1.setAccessible(true);
		field1.isAccessible();
		field1.set(test1, "����");
		System.out.println(test1.name);
		System.out.println("---------------------------------------------------");
		
		
		
		
		
		// ��ȡ������
		// ͨ��������ѡ���ȡ����������
		Constructor con = class1.getDeclaredConstructor(String.class, int.class, String.class);
		// Constructor con2 = class1.getDeclaredConstructor(new
		// Class[]{String.class,int.class,String.class});
		System.out.println("����������" +con.getName());
		// ���η�
		System.out.println("���������η���" +Modifier.toString(con.getModifiers()));
		// ��ȡ��������
		Class[] parameters = con.getParameterTypes();
		for (Class class3 : parameters) {
			System.out.println("�������������ͣ�" +class3.getName());
		}
		// ���ù�������ö���
		Object obj = con.newInstance("Ů", 25, "�Ĵ�");
		Test1 t = (Test1) obj;
		System.out.println("ͨ��������new���Ķ���" );
		System.out.println(t.getAddress());
		System.out.println(t.getAge());
		System.out.println(t.getSex());
		
		// ��ȡ���еĹ�����
		System.out.println("��ȡ���еĹ�������" );
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
		//���������ַ�ʽ��ȡ����
		classs.newInstance();//������Ĭ�ϵ��޲ι�����
		con.newInstance("Ů", 25, "�Ĵ�");//���Ե������⹹����
		
		con.getExceptionTypes();
		con.setAccessible(true);
		System.out.println("---------------------------------------------------");
		
		
		
		
		//��ȡ����
		System.out.println("��ȡ���еķ���:");
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
		System.out.println("���÷�����");
		Test1 obj1 = (Test1)class2.newInstance();
		obj1.method();
		
		class2.getDeclaredMethod("method", null).invoke(obj1, null);//����Ǿ�̬����obj1Ϊnull
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
		System.out.println("method������������");
	}
}
