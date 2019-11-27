package com.wangle.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class Main5 {
	//����ж���۲��ߣ������������С���������������չ��
	//��������������:һ�ǹ۲���һ�������ı䣬�紦�����ĸı䣬�۲��߱�����Ҫ��ӵȵȡ����ǹ۲��ߵ���Ϊ��һ��ֻ������С����һ�������ϣ���С��������Ϊ���ÿ��˶����ء�
	//����������ǽ��Ҳ�Ǵ�������������
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
			System.out.println("��ޣ��ְ�����");
		}
	}
	static class Mom implements Observer<Child>{
		
		public void dosomething(Child c){
			c.cry = false;
			System.out.println("��ޣ��������ˣ�����������");
		}
	}
	static class Dog implements Observer<Child>{
		
		public void dosomething(Child c){
			c.cry = false;
			System.out.println("��������������");
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
