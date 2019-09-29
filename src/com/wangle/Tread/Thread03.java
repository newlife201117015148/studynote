package com.wangle.Tread;


public class Thread03 extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(10000);//�����쳣��Ҫ��������Ϊ��û��ʱ��ͱ�����
			System.out.println("˯����Ȼ��");
		} catch (InterruptedException e) {
			System.out.println("������");
		}
	}
	
	public static void main(String[] args) {
		
		Thread03 test = new Thread03();
		/*
		 * ��Java���������̣߳�User Thread(�û��߳�)��Daemon Thread(�ػ��߳�) 

			�ø��Ƚ�ͨ�׵ı��磬�κ�һ���ػ��̶߳�������JVM�����з��ػ��̵߳ı�ķ��
			
			ֻҪ��ǰJVMʵ�����д����κ�һ�����ػ��߳�û�н������ػ��߳̾�ȫ��������ֻ�е����һ�����ػ��߳̽���ʱ���ػ��߳�����JVMһͬ����������
			Daemon��������Ϊ�����̵߳������ṩ���������ػ��߳�����͵�Ӧ�þ��� GC (����������)��������һ���ܳ�ְ���ػ��ߡ�
		 * �����м�����Ҫע�⣺ 

		(1) thread.setDaemon(true)������thread.start()֮ǰ���ã�������ܳ�һ��IllegalThreadStateException�쳣���㲻�ܰ��������еĳ����߳�����Ϊ�ػ��̡߳�
		(2) ��Daemon�߳��в��������߳�Ҳ��Daemon�ġ� 
		(3) ��Ҫ��Ϊ���е�Ӧ�ö����Է����Daemon�����з��񣬱����д�������߼����߼��� 


		��Ϊ�㲻����֪�������е�User���֮ǰ��Daemon�Ƿ��Ѿ������Ԥ�ڵķ�������һ��User�˳��ˣ����ܴ������ݻ�û�����ü������д������������Ҳ���ܶ�����н����һ����
		��Գ����ǻ����Եġ���������������Ѿ�˵���ˣ�һ������User Thread�뿪�ˣ������Ҳ���˳������ˡ� */
		//test.setDaemon(true);//�������߳�Ϊ�ػ��̣߳������߳�һ���ߣ��������߳�ִ����û
		test.start();
		
		try {
			Thread.sleep(3000);
			test.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
