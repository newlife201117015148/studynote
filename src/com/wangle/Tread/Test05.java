package com.wangle.Tread;

/**
 * 
   * @�� ���� Test05
   * @���������� ����3���̴߳�ӡ����������, �߳�1�ȴ�ӡ1,2,3,4,5, Ȼ�����߳�2��ӡ6,7,8,9,10, Ȼ�����߳�3��ӡ11,12,13,14,15. ���������߳�1��ӡ16,17,18,19,20��.�Դ�����, ֱ����ӡ��75.
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��7������1:01:27
   * @�޸ı�ע��
 */
public class Test05 {
	
	public static void main(String[] args) {
		Number1 number1 = new Number1(1);
		Number1 number2 = new Number1(2);
		Number1 number3 = new Number1(3);
		
		number1.setName("�߳�1");
		number2.setName("�߳�2");
		number3.setName("�߳�3");
		
		number1.start();
		number3.start();
		number2.start();
	}

}
