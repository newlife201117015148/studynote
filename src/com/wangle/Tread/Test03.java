package com.wangle.Tread;
/**
 * 
   * @�� ���� Test3
   * @���������� ���߳̾��䰸����ϰ:������Ʊ���ڣ�һ����Ʊ20�ţ�����Ϊֹ
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:29:39
   * @�޸ı�ע��
 */
public class Test03 {
	
	public static void main(String[] args) {
		
		TicketsOffice office1 = new TicketsOffice();
		TicketsOffice office2 = new TicketsOffice();
		TicketsOffice office3 = new TicketsOffice();
	
		office1.start();
		office2.start();
		office3.start();
	}
}
