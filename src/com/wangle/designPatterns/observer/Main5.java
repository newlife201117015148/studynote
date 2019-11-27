package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main5 {
	//如果有多个观察者，都将其耦合在小孩的类里，不具有扩展性
	//体现在两个方面:一是观察者一旦发生改变，如处理动作的改变，观察者本身需要添加等等。二是观察者的行为不一定只作用在小孩儿一个人身上，如小狗可能因为妹妹哭了而叫呢。
	//所以下面就是解耦，也是从这两方面着手
	public static void main(String[] args) {
		Child child = new Child();
		
		Dad dad = new Dad();
		Mom mom = new Mom();
		Dog dog = new Dog();
		child.add(dad);
		child.add(mom);
		child.add(dog);
		child.wakeup();
	}

	
	static interface Observer<T>{
		void dosomething(T t);
	}
	
	static class Dad implements Observer<Child>{
		
		public void dosomething(Child c){
			c.cry = false;
			System.out.println("别哭，爸爸来了");
		}
	}
	static class Mom implements Observer<Child>{
		
		public void dosomething(Child c){
			c.cry = false;
			System.out.println("别哭，妈妈来了，抱抱、、、");
		}
	}
	static class Dog implements Observer<Child>{
		
		public void dosomething(Child c){
			c.cry = false;
			System.out.println("汪汪汪、、、、");
		}
	}
	static class Child{
		private volatile boolean cry = false;
		List<Observer<Child>> observers = new ArrayList<>();
		public void add(Observer<Child> o){
			observers.add(o);
		}
		public boolean isCry() {
			return cry;
		}


		public void setCry(boolean cry) {
			this.cry = cry;
		}


		public void wakeup(){
			cry = true;
			System.out.println("wuwuwuwuwuuw......");
			
			for (Observer<Child> observer : observers) {
				observer.dosomething(this);
			}
		}
	}
}
