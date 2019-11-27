package com.wangle.designPatterns.observer;

public class Main2 {
	
	public static void main(String[] args) {
		final Child child = new Child();
		Dad dad = new Dad();
		
		new Thread(new Runnable(){//new一个线程，模拟小孩，在睡觉20秒后醒了

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
		
		
		while(true){//实时监测小孩儿是否哭了，一旦哭了，爸爸就喂他
			if(child.isCry()){
				dad.feed(child);
				break;
			}
		}
	}

	static class Dad{
		
		public void feed(Child c){
			c.cry = false;
			System.out.println("别哭，爸爸来了");
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
