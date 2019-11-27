package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.*;

public class AtomicIntegerFieldUpdaterTest {
	/*
	 * AtomicXXXFieldUpdater һ�㶼����java��Դ�뿪���ߣ���ͨ�����ߺ����õ���
	 * 
	 * ����Ӧ�ó�����
	 * 1.����������Ծ߱�ԭ����
	 * 
	 * 2.����ʹ����������ʾ������synchronized��
	 * 
	 * 3.������Ҫԭ���������εĶ�����������ڴ档��concurrentskiplistMap�е�node��next��value
	 */
	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<Test> aifu = AtomicIntegerFieldUpdater.newUpdater(Test.class, "age");
		Test obj = new Test();
		aifu.compareAndSet(obj, 0, 1);
		System.out.println(aifu.get(obj));
	}

	static class Test{
		protected volatile int age;
	}
	
	
	/**
	 * �״��ܽ᣺
	 * 
	 * 1.age���η�������Ĭ�ϻ���public.���������ࡣ
	 * 2.age����������volatile���Ρ�
	 * 3.����������ڡ�
	 * 4.��������Ҫ��ȷ��
	 * 5.obj������null��
	 * 6.���class��obj����ƥ�䡣
	 * 
	 */
}
