package com.wangle.Tread;

public class ThreadLocal1 extends Thread{
	private String name = null;
	public ThreadLocal1(String name){
		this.name =name;
	}
	public static void main(String[] args) {
		//Ϊʲô��ThreadLocal����
		//������test1()����test2()����test3()����test4()����test1()���趨һ��ֵ���봫��test4()�����Խ��������Ϊ����ֵ��test1()��ֵ��test4()ֱ��ȥȡ��
		//     ���Ƕ���߳���������̵Ļ��������ֵ�ĸ���.����ǰ����Щ�������Ǿ�̬�ģ���Ϊ��ʵ���Ļ��Ͳ������߳�������
		ThreadLocal1 local1 = new ThreadLocal1("test1");
		ThreadLocal1 local2 = new ThreadLocal1("test2");
		ThreadLocal1 local3 = new ThreadLocal1("test3");
		ThreadLocal1 local4 = new ThreadLocal1("test4");
		
		local1.start();
		local2.start();
		local3.start();
		local4.start();
		
	}

	@Override
	public void run() {
		
		ThreadLocalTest.m1(name);
	} 
}
