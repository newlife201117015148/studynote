package com.wangle.Tread;

/**
 * 
   * @�� ���� Test04
   * @���������� ���������̣߳�����һ�����1-52������һ�����A-Z�������ʽҪ��12A 34B 56C 78D ...
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������11:28:09
   * @�޸ı�ע��
 */
public class Test04 {

	
	public static void main(String[] args) throws InterruptedException {
		Number number = new Number();
		Zimu zimu = new Zimu();
		
		number.start();
		zimu.start();
		
		number.join();
		zimu.join();
		
		
	}
}
