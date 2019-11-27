package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main8 {
	//事件类其实还存在继承体系
	public static void main(String[] args) {
		Child child = new Child();
		
		Dad dad = new Dad();
		Mom mom = new Mom();
		Dog dog = new Dog();
		child.add(dad);
		child.add(mom);
		child.add(dog);
		child.wakeup();
		System.out.println(child.isCry());
	}

	static abstract class AbstractEvent{
		abstract Object getSource();
	}
	
	static class WakeupEvent extends AbstractEvent{
		private String time;
		private String location;
		private Object source;
		public WakeupEvent(String time,String location,Object source) {
			this.time = time;
			this.location = location;
			this.source = source;
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
		
		@Override
		public Object getSource() {
			return source;
		}

		public void setSource(Object source) {
			this.source = source;
		}

		

		
	}
	static interface Observer{//观察者接口
		void dosomething(WakeupEvent event);//不观察人了，观察事件本身
	}
	
	static class Dad implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//这里就可以拿到事件源对象了
			child.cry = false;
			if(event.getTime().equals("at night"))
				System.out.println("哎呀，这么晚了，还哭");
			System.out.println("别哭，爸爸来了");
		}
	}
	static class Mom implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//这里就可以拿到事件源对象了
			child.cry = false;
			System.out.println("别哭，妈妈来了，抱抱、、、");
		}
	}
	static class Dog implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//这里就可以拿到事件源对象了
			child.cry = false;
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
			WakeupEvent event = new WakeupEvent("at night","床上",this);//这里传入child对象
			for (Observer observer : observers) {
				observer.dosomething(event);
			}
		}
	}
}
