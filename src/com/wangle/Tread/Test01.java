package com.wangle.Tread;
/**
 * 
   * @�� ���� Test01
   * @���������� ʹ��ʵ��Runnable�ӿڵķ�ʽ�����߳�
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:27:12
   * @�޸ı�ע��
 */
public class Test01 implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable:"+Thread.currentThread().getName());
		
		
	}

	
	
}
