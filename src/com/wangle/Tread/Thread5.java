package com.wangle.Tread;
/**
 * ͬ����
   * @�� ���� Thread5
   * @���������� TODO
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:21:26
   * @�޸ı�ע��
 */
public class Thread5 extends Thread{

	volatile static int number =0;
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		synchronized(Thread5.class){
			for (int i = 0; i < 1000; i++) {
				number++;
			}
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		//���̷߳���ͬһ�����������޸�����
		Thread5[] test = new Thread5[10];
		for (int i = 0; i < test.length; i++) {
			test[i]  = new Thread5();
		}
		
		for (Thread5 thread5 : test) {
			thread5.start();
			
		}
		for (Thread5 thread5 : test) {
			thread5.join();//�������߳�ִ����
		}
		System.out.println(number);
	}
}
