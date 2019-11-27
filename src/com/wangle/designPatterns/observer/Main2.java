package com.wangle.designPatterns.observer;

public class Main2 {
	
	public static void main(String[] args) {
		final Child child = new Child();
		Dad dad = new Dad();
		
		new Thread(new Runnable(){//newһ���̣߳�ģ��С������˯��20�������

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				child.wakeup();
			}
			
		},"t").start();
		
		
		while(true){//ʵʱ���С�����Ƿ���ˣ�һ�����ˣ��ְ־�ι��
			if(child.isCry()){
				dad.feed(child);
				break;
			}
		}
	}

	static class Dad{
		
		public void feed(Child c){
			c.cry = false;
			System.out.println("��ޣ��ְ�����");
		}
	}
	
	static class Child{
		private volatile boolean cry = false;
		
		
		public boolean isCry() {
			return cry;
		}


		public void setCry(boolean cry) {
			this.cry = cry;
		}


		public void wakeup(){
			cry = true;
			System.out.println("wuwuwuwuwuuw......");
		}
	}
}
