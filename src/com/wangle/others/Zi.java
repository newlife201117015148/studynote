package com.wangle.others;

public class Zi extends Fu{
	static int c = 2;
	int d = 2;
	static{
		System.out.println("Zi��̬��ִ���ˣ� �����c��"+c);
	}
	{
		System.out.println("Ziʵ����ִ���ˣ� �����d:"+d);
	}
	public Zi(int c ,int d){
		super(c,d);
		this.c = c;
		this.d = d;
		System.out.println("Zi ����Ĺ��캯��ִ���ˣ�c��ֵ��"+c+"d��ֵ��"+d);
	}
}
