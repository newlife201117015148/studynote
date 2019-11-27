package com.wangle.designPatterns.observer;

public class Main4 {
	//如果有多个观察者，都将其耦合在小孩的类里，不具有扩展性
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
	static class Mom{
		
		public void hug(Child c){
			c.cry = false;
			System.out.println("别哭，妈妈来了，抱抱、、、");
		}
	}
	static class Dog{
		
		public void bark(Child c){
			c.cry = false;
			System.out.println("汪汪汪、、、、");
		}
	}
	static class Child{
		private volatile boolean cry = false;
		private Dad dad = new Dad();
		private Mom mom = new Mom();
		private Dog dog = new Dog();
		
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
			mom.hug(this);
			dog.bark(this);
		}
	}
}
