package com.wangle.Tread;

public class Thread02 extends Thread{

	public static void getmethod(){}
	public void run() {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// main�߳������̣߳�thread01�ȵȶ���main�̵߳ķ�֧����Ϊ���߳�
		// ���߳�Ҫ�����߳�ִ�����ˣ��Ż�ͣ��������߳��г���Ҫִ�У��������߳�ִ����û�У�����Ҫִ�С�
		Thread02 thread02 = new Thread02();
		thread02.start();
		System.out.println("���߳�");
		//��ȡ��ǰ�߳�
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getId());
		System.out.println(currentThread.getName());
		System.out.println(currentThread.getPriority());//��ȡ���ȼ�
		
//		currentThread.stop();//�߳�ֹͣ���У�����ִ�к���Ĵ���
		//sleep()�Ǿ�̬������ֻ�ܿ��Ƶ�ǰ�������е��̡߳�
		
		
		//�߳�״̬
		
//		currentThread.getState().NEW   �½�״̬
//		currentThread.getState().WAITING  ��ʱ�����Ƶȴ�  ����wait��������  ͨ��notify����notifyAll����
//		currentThread.getState().TIMED_WAITING  ��ʱ�����Ƶȴ�  ����sleep��ʱ�䣩���� ͨ��interrupt��������
//		currentThread.getState().RUNNABLE  ����״̬
//		currentThread.getState().TERMINATED  ����״̬��ִ����run�������ߵ���stop��������������
//		currentThread.getState().BLOCKED  �Ŷӵȴ�cpu����ʱ��Ƭ��״̬��ͬ����ʱ��
		//start�����������ú󣬵ȴ�cpu����ʱ��Ƭ��֮��ִ��run����������ִ�������������
	}
}
