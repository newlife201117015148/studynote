package com.wangle.Tread;
/**
 * 
   * @�� ���� Test9
   * @���������� isAlive()������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��7������5:58:18
   * @�޸ı�ע��
 */
public class Test9 {
//	isAlive() �������������жϵ�ǰ���߳��Ƿ��ڻ״̬��ʲô�ǻ״̬�أ��״̬�����߳��Ѿ���������δ��ֹ���̴߳����������л�׼����ʼ���е�״̬������Ϊ�߳��ǡ����ġ�
//	�� 1
//
//	����ͨ��һ����������� isAlive() �����ж��߳��Ƿ��ı�׼������ MyThread08 �߳���Ĵ������£�
//	package ch14;
//	public class MyThread08 extends Thread
//	{
//	    @Override 
//	    public void run()
//	    { 
//	        System.out.println("run="+this.isAlive()); 
//	    }
//	}
//
//	������������ʾ��MyThread08 ��Ĵ���ǳ��򵥣�ֻ���� run() �����е��� isAlive() ���������ǰ�̵߳Ļ״̬��
//
//	�����д���� MyThread08 �̵߳Ĵ��룬����ʵ�����£�
//	package ch14;
//	public class Test11
//	{
//	    public static void main(String[] args)
//	    {
//	        MyThread08 mythread=new MyThread08();    //����һ��MyThread08�߳�ʵ��
//	        System.out.println("begin=="+mythread.isAlive());    //����߳�״̬
//	        mythread.start();    //�����߳�
//	        System.out.println("end=="+mythread.isAlive());    //����߳�״̬
//	    }
//	}
//
//	ִ�к�����������£�
//	begin==false
//	end==true
//	run=true
//
//	��������Ҫע������һ�д��룺
//	System.out.println("end=="+mythread.isAlive());
//
//	��Ȼ�ڱ�ʾ����������������ֵ�� true������ֵ�ǲ�ȷ���ġ���� true ֵ����Ϊ mythread �̻߳�δִ����ϣ�������� true�����������ĳ�������ʽ��
//	package ch14;
//	public class Test11
//	{
//	    public static void main(String[] args) throws InterruptedException
//	    { 
//	        MyThread08 mythread=new MyThread08();    //����һ��MyThread08�߳�ʵ��
//	        System.out.println("begin=="+mythread.isAlive());    //����߳�״̬
//	        mythread.start();    //�����߳�
//	        Thread.sleep(1000);     //��ʱ1000����
//	        System.out.println("end=="+mythread.isAlive());    //����߳�״̬
//	    }
//	}
//
//	�ٴ��������̣߳���ʱ�����������£�
//	begin==false
//	run=true
//	end==false
//
//	��ʱ end �ķ���ֵΪ false��������Ϊ mythread �����Ѿ��� 1 ��֮��ִ����ϡ�
//	�� 2
//
//	��ʹ�� isAlive() ����ʱ��������̶߳����Թ�������ķ�ʽ���ݸ� Thread ������� start() ���������еĽ����ǰ��ʾ�����в���ġ���������Ĳ����ԭ���������� Thread.currentThread() �� this �Ĳ��졣����ͨ��һ����������֤��һ�㡣
//
//	(1) ���ȴ���������ʹ�õ��߳��࣬��������Ϊ MyThread09������������£�
//	package ch14;
//	public class MyThread09 extends Thread
//	{
//	    public MyThread09()
//	    {
//	        System.out.println("���췽��---��ʼ");
//	        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
//	        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
//	        System.out.println("this.getName()="+this.getName());
//	        System.out.println("this.isAlive()="+this.isAlive());
//	        System.out.println("���췽��---����");
//	    }
//	    @Override
//	    public void run()
//	    {
//	        System.out.println("run()����---��ʼ");
//	        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
//	        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
//	        System.out.println("this.getName()="+this.getName());
//	        System.out.println("this.isAlive()="+this.isAlive());
//	        System.out.println("run()����---����");
//	    }
//	}
//
//	(2) ��������д���̴߳��룬���� MyThread09 �߳�ʵ���������̡߳��������£�
//	package ch14;
//	public class Test12
//	{
//	    public static void main(String[] args)
//	    {
//	        MyThread09 mythread=new MyThread09();    //����һ��MyThread09�߳�ʵ��
//	        Thread t1=new Thread(mythread);    //����һ���߳�
//	        System.out.println("main begin t1 isAlive="+t1.isAlive());    //����߳�״̬
//	        t1.setName("A");    //�����߳�����
//	        t1.start();    //�����߳�
//	        System.out.println("main end t1 isAlive="+t1.isAlive());
//	    }
//	}
//
//	�������н�����£�
//	���췽��---��ʼ
//	Thread.currentThread().getName()=main
//	Thread.currentThread().isAlive()=true
//	this.getName()=Thread-0
//	this.isAlive()=false
//	���췽��---����
//	main begin t1 isAlive=false
//	main end t1 isAlive=true
//	run()����---��ʼ
//	Thread.currentThread().getName()=A
//	Thread.currentThread().isAlive()=true
//	this.getName()=Thread-0
//	this.isAlive()=false
//	run()����---����
}
