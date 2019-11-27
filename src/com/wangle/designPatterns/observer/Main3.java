package com.wangle.designPatterns.observer;

public class Main3 {
	//˼�룺��ʼ�ǹ۲���dadʵʱ�۲���С�����Ƿ����ˣ��������ǰѹ۲��ߵĴ�����Ϊ���ڱ��۲��ߵķ����һ��С�������ˣ���ֱ��ȥ����bad��feed������
	public static void main(String[] args) {
		Child child = new Child();
		child.wakeup();
	}

	static class Dad{
		
		public void feed(Child c){
			c.cry = false;
			System.out.println("��ޣ��ְ�����");
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
