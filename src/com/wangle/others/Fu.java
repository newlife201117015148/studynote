package com.wangle.others;

public class Fu {
	static int a = 1;
	int b = 1;
	static{
		System.out.println("fu��̬��ִ���ˣ� �����a��"+a);
	}
	{
		System.out.println("fuʵ����ִ���ˣ������b:"+b);
	}
	public Fu(int a,int b){
		this.a = a;
		this.b = b;
		System.out.println("fu����Ĺ��캯��ִ���ˣ�a��ֵ��"+a+"b��ֵ��"+b);
	}
}
