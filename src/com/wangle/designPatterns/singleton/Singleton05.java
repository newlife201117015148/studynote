package com.wangle.designPatterns.singleton;

public class Singleton05 {
	//˫�ؼ��ȷ�����ǵ�����û�����ǣ���Ϊjava��jit���������£��õ��ĵ�����������Ǹ�û�г�ʼ����ֵ
	//���Ա����volatile�ؼ���
	private static volatile  Singleton05 instance;
	private Singleton05(){}
	
	public static  Singleton05 getInstance(){
		if(instance == null){
			synchronized(Singleton05.class){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(instance == null){
					return instance = new Singleton05();
				}
				
			}
			
		}
		return instance;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							Singleton05 instance2 = Singleton05.getInstance();
							System.out.println(instance2.hashCode());
						}
					}
				,"t"+i).start();
		}
	}
}
