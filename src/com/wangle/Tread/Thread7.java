package com.wangle.Tread;
/**
 * ͬ������
   * @�� ���� Thread7
   * @���������� TODO
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:20:41
   * @�޸ı�ע��
 */
public class Thread7 extends Thread {
	Thread6 thread = new Thread6();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				thread.add();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread7[] test = new Thread7[10];
		for (int i = 0; i < test.length; i++) {
			test[i] = new Thread7();
		}
		for (Thread7 thread7 : test) {
			thread7.start();
		}

		for (Thread7 thread7 : test) {
			thread7.join();
		}
		System.out.println(new Thread6().getNumber());
		
		
		
		//ͬ�����ͬ������
		//ͬ���������synchronized��obj��{����}����ʽ����һ�δ���
		//ͬ������������synchronized���η����ķ�ʽ
		
		//������⣬���������
		//�����������ͬ�����ݾ���һ�������ŵķ��䣻������ǿ��ŵ�Կ��
		
		//����Ҫʵ��ͬ����synchronized��һ����ʵ�֣�ֻ�ж��һ��һ��һ����ʵ��ͬ�����ñ����Ļ����ǣ������һ��Կ��һ�����䣻һ��һ����ͬһ����һ��Կ��һ������
		
		//ͬ����������Ϊ��̬ͬ����ʽ��ʵ��ͬ����������̬ͬ�������Ƕ��������м�����ʵ��ͬ�������Ƕ�ʵ��������м�����
		//ͬ������飺synchronized��obj���е�obj��Ϊ�������Ϳɱ���󣬼��൱�ڶ����������Ͷ�ʵ�����������
	}
}
