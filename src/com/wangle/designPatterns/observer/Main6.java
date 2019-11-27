package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main6 {
	//��һ���汾�У��۲��߹��ĵ���С�����������϶Ȼ����е�ߣ������������ʵ�۲���ֻ����С����������¼�
	//Ҳ���ǳ����ļ��������¼��Ĺ�ϵ���������ǰ�wakeup����³������
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

	static class WakeupEvent{//���������wakeup�¼�
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
	static interface Observer{//�۲��߽ӿ�
		void dosomething(WakeupEvent event);//���۲����ˣ��۲��¼�����
	}
	
	static class Dad implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			if(event.getTime().equals("at night"))
				System.out.println("��ѽ����ô���ˣ�����");
			System.out.println("��ޣ��ְ�����");
		}
	}
	static class Mom implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			System.out.println("��ޣ��������ˣ�����������");
		}
	}
	static class Dog implements Observer{
		
		public void dosomething(WakeupEvent event){
//			c.cry = false;
			System.out.println("��������������");
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
			WakeupEvent event = new WakeupEvent("at night","����");
			for (Observer observer : observers) {
				observer.dosomething(event);
			}
		}
	}
}
