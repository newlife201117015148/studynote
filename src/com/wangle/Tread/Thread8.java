package com.wangle.Tread;

/**
 * ����
   * @�� ���� Thread8
   * @���������� TODO
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��6������10:19:59
   * @�޸ı�ע��
 */
public class Thread8{
	static Thread9 B = new Thread9();
	
	static boolean jieshu = false;
	public static synchronized void method8(){
		jieshu = false;
		System.out.println("method8");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Thread8.jieshu!=false){
			Thread9.method9();
			}else{
				System.out.println("����Method9�ķ���");
			}
		jieshu = true;
	}

}
