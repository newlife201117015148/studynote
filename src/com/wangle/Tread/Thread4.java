package com.wangle.Tread;

public class Thread4 extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(10000);//�����쳣��Ҫ��������Ϊ��û��ʱ��ͱ�����
		} catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread4 test = new Thread4();
		//test.setDaemon(true);//�������߳�Ϊ�ػ��̣߳������߳�һ���ߣ��������߳�ִ����û
		test.start();
		System.out.println("���ڼ��ء�����");
		//test.join();//���̵߳ȴ����߳�ִ�����ˣ����߳�������ִ��
		test.join(4000);//���̼߳������̣߳����̵߳ȴ����߳�4�룬�����������̻߳�û�����꣬�ͼ��س�ʱ
		
		System.out.println("���߳�");
		//test.wait();//��notify��notifyAll()��ֻ����ͬ��������ʹ��
		if(test.getState()==State.TERMINATED){
			System.out.println("���سɹ�");
		}else{
			System.out.println("���س�ʱ");
			//test.start();//�������̲߳����ٴθ�����
		}
		
	}
}
