package com.wangle.designPatterns.singleton;

public class Singleton01 {
	//������֤�˵��������һ����̰߳�ȫ�ġ�
	//ͨ����˵���������԰�ȫ��д����
	//ȱ���ǹ����ò��ö���ֻҪ���ʼ���ˣ�����ʵ�������󣬸��������ѿռ䡣
	private final static  Singleton01 instance= new Singleton01();
	private Singleton01(){}
	
	public Singleton01 getInstance(){
		return instance;
	}
}
