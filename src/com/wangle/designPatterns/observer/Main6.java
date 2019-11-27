package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main6 {
	//上一个版本中，观察者关心的是小孩这个对象，耦合度还是有点高，究其根本，其实观察者只关心小孩儿哭这个事件
	//也就是常理解的监听器和事件的关系，所以我们把wakeup这件事抽象出来
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

	static class WakeupEvent{//抽象出来的wakeup事件
		private String time;
		private String location;
		public WakeupEvent(String time,String location) {
			// TODO Auto-generated constructor stub
			this.time = time;
			this.location = location;
		}
		
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		
	}
	static interface Observer{//观察者接口
		void dosomething(WakeupEvent event);//不观察人了，观察事件本身
	}
	
	static class Dad implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			if(event.getTime().equals("at night"))
				System.out.println("哎呀，这么晚了，还哭");
			System.out.println("别哭，爸爸来了");
		}
	}
	static class Mom implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			System.out.println("别哭，妈妈来了，抱抱、、、");
		}
	}
	static class Dog implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			System.out.println("汪汪汪、、、、");
		}
	}
	static class Child{
		private volatile boolean cry = false;
		List<Observer> observers = new ArrayList<>();
		public void add(Observer o){
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
			WakeupEvent event = new WakeupEvent("at night","床上");
			for (Observer observer : observers) {
				observer.dosomething(event);
			}
		}
	}
}
