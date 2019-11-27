package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main7 {
	//上一个版本中，观察者只观察事件了，不观察事件源对象了，但是我们需要对源对象进行操作呢
	//思考：怎么解决，将源对象加在哪儿
	//千万千万不能加载观察者的事件处理方法上，这里是dosomething()方法，因为观察者处理的这个实践不只这一类对象，还有其它很多情况，所以这里不能写死
	//那加在哪儿呢，加在event中。
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

	static class WakeupEvent{//这里增加source属性
		private String time;
		private String location;
		private Object source;
		public WakeupEvent(String time,String location,Object source) {
			// TODO Auto-generated constructor stub
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
