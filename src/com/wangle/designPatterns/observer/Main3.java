package com.wangle.designPatterns.observer;

public class Main3 {
	//思想：开始是观察者dad实时观察着小孩儿是否醒了，现在我们把观察者的处理行为放在被观察者的方法里，一旦小孩儿醒了，就直接去调用bad的feed方法。
	public static void main(String[] args) {
		Child child = new Child();
		child.wakeup();
	}

	static class Dad{
		
		public void feed(Child c){
			c.cry = false;
			System.out.println("别哭，爸爸来了");
		}
	}
	
	static class Child{
		private volatile boolean cry = false;
		private Dad dad = new Dad();
		
		public boolean isCry() {
			return cry;
		}


		public void setCry(boolean cry) {
			this.cry = cry;
		}


		public void wakeup(){
			cry = true;
			System.out.println("wuwuwuwuwuuw......");
			
			dad.feed(this);
		}
	}
}
