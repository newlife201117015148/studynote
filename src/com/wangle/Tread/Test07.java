package com.wangle.Tread;

/**
 * 
   * @�� ���� Test07
   * @���������� �߳��е�wait() �� ���Ĺ�ϵ
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��7������3:37:53
   * @�޸ı�ע��
 */
public class Test07 {
	 public static void main(String[] args) throws InterruptedException{
	        ThreadD b = new ThreadD();
	        //���������߳�
	        b.start(); 
	        //�߳�Aӵ��b�����ϵ������߳�Ϊ�˵���wait()��notify()���������̱߳������Ǹ���������ӵ����
	        synchronized (b) {
	            System.out.println("�ȴ�����b��ɼ��㡣����");
	            //��ǰ�߳�A�ȴ�
	            b.wait();
	            System.out.println("b���������ܺ��ǣ�" + b.total);
	        } 
	    } 

	 
//	 ִ�н����
//
//	 �ȴ�����b��ɼ��㡣����
//	 �������
//	 b���������ܺ��ǣ�5050
//
//	 ������ǽ�b.wait()ȥ���أ�������£�
//	 �ȴ�����b��ɼ��㡣����
//	 b���������ܺ��ǣ�0
//	 �������
//
//	 �����Ľ����������ȥ��b.wait()ʱ�����������߳�ThreadB�����߳�ThreadA�Ǹ���ִ�еģ�û���̵߳ȴ�������
//	 ������Ҫ��Ч���ǣ����߳�ThreadB��ɼ���֮����ȥȡ�����Ľ��������ʹ����b.wait()�������̵߳ȴ���
//	 ��Ϊʲô��ʹ��b.wait()��������Thread.currentThread.wait()�������������أ�
//
//	 ������ǽ�b.wait()�滻��Thread.currentThread.wait()������õ����µĽ����
//	 Exception in thread "main" java.lang.IllegalMonitorStateException
//	 at java.lang.Object.wait(Native Method)
//	 at java.lang.Object.wait(Object.java:485)
//	 at pa.com.thread.ThreadA.main(ThreadA.java:18)
//	 �ȴ�����b��ɼ��㡣����
//	 �������
//
//	 �滻�Ĵ���Thread.currentThread.wait()����������ȻӦ��������Ԥ�ڵ���ȷ�����õ�ǰ�̴߳��ڵȴ�״̬���������߳���ִ�С�
//	 ���Ǻ�����һ������Ҫ�����⣺�߳������Ƿֲ����ģ��̵߳�ͬ�����ȴ������Ѷ�����������ܲ��ɷֵġ�
//	 �߳�ThreadA���ж���b����������Ҫʹ�������ȥ���߳��ͷ������Ӷ����������߳��������������
//	 �����ǵĳ������������ǣ��߳�ThreadA���ȳ���������b��Ȼ�����b.wait()���������ͷţ��߳�ThreadB������������b���Ӷ�ִ��run()�����еļ��㣬
//	 ��������֮��ʹ��notify()�������߳�ThreadA��ThreadA���Լ���ִ�У��Ӷ��õ�������Ԥ�ڵ�Ч����
//	 ��֮����ThreadB�Ķ�����Ҳ��b������Ϊsynchronized(this)�е�thisָ��ľ���ThreadB��ʵ��b��
//	 Thread.currentThread.wait()���õ��ǵ�ǰ�̶߳��󣨼����߳�ThreadA����wait()��������ǰ�̶߳���ThreadA��û�б������ģ�
//	 ��ֻ�ǻ�ȡ�˶�����b���һ���û�п����������ĵ��ã�һ��ʹ�õ����������wait()��������Ϊb.wait()
}
