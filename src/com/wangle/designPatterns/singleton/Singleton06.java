package com.wangle.designPatterns.singleton;

public class Singleton06 {
	//�����ڲ�����ʵ�ֵ���
	private Singleton06(){}
	static{
		System.out.println("�ⲿ�౻��ʼ����");
	}
	private static class InstanceInnerClass{
		private static final Singleton06 instance = new Singleton06();
		static {
			System.out.println("�ڲ��౻��ʼ����");
		}
	}
	//���ø÷�����ʱ���ڲ���Żᱻ���ء���ʼ����
	public static  Singleton06 getInstance(){
		return InstanceInnerClass.instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton06 instance2 = Singleton06.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
