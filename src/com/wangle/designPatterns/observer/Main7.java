package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main7 {
	//��һ���汾�У��۲���ֻ�۲��¼��ˣ����۲��¼�Դ�����ˣ�����������Ҫ��Դ������в�����
	//˼������ô�������Դ��������Ķ�
	//ǧ��ǧ���ܼ��ع۲��ߵ��¼��������ϣ�������dosomething()��������Ϊ�۲��ߴ�������ʵ����ֻ��һ����󣬻��������ܶ�������������ﲻ��д��
	//�Ǽ����Ķ��أ�����event�С�
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

	static class WakeupEvent{//��������source����
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
	static interface Observer{//�۲��߽ӿ�
		void dosomething(WakeupEvent event);//���۲����ˣ��۲��¼�����
	}
	
	static class Dad implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//����Ϳ����õ��¼�Դ������
			child.cry = false;
			if(event.getTime().equals("at night"))
				System.out.println("��ѽ����ô���ˣ�����");
			System.out.println("��ޣ��ְ�����");
		}
	}
	static class Mom implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//����Ϳ����õ��¼�Դ������
			child.cry = false;
			System.out.println("��ޣ��������ˣ�����������");
		}
	}
	static class Dog implements Observer{
		
		public void dosomething(WakeupEvent event){
			Child child = (Child)event.getSource();//����Ϳ����õ��¼�Դ������
			child.cry = false;
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
			WakeupEvent event = new WakeupEvent("at night","����",this);//���ﴫ��child����
			for (Observer observer : observers) {
				observer.dosomething(event);
			}
		}
	}
}
