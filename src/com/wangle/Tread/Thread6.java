package com.wangle.Tread;
/**
 * ͬ������
   * @�� ���� Thread6
   * @���������� TODO
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:21:10
   * @�޸ı�ע��
 */
public class Thread6{

	private static int number = 0;

	public static int getNumber() {
		return number;
	}

	public static   synchronized void add() {
		number++;
	}
	
}
