package com.wangle.Tread;

public class Thread12 extends Thread{

	@Override
	public void run() {
		
		while(true){
			boolean b = false;
			if(b=Thread.interrupted()){//ֻ����һ�Σ��ڶ���״̬�ָ�Ϊfalse����sleepһ�������жϵ�ǰ�߳�
				//��״̬
				System.out.println("�ұ������");
				//ҵ���߼�һ��д������
				break;
			}else{
				System.out.println(b);
				System.out.println("��û�б����");
			}
			//ҵ���߼�д������Ļ�����Ҫ���¸��´��״̬Ϊ���
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {//���쳣����״̬������
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread12 t = new Thread12();
		t.start();
		Thread.sleep(1000);
		t.interrupt();//interrupt()�����ж��������е��̣߳���ֻ�ܸı��ж�״̬���ѡ�
		//t.interrupted()��ǰ�߳��Ƿ��Ѿ��жϡ��̵߳��ж�״̬ �ɸ÷������
		
		//�ܽ�һ����Ҫ�ж�һ���̣߳����ⲿ���޷��쵽�ģ�ֻ���߳��Լ�������java�е�����interrupt������
		//���еģ���ֻ�Ǹı����߳��жϵ�״̬��Ҫ���ж��߳���Ҫ��Thread.interrupted()���ʹ�á�
	}
}
