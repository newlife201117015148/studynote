package com.wangle.designPatterns.memento;

public class Main {
	//备忘录模式
	//适用：记录快照（瞬时状态）、存盘
	//具体应用例子就是游戏存点
	//另外除了java序列化还有google开源的protobuf
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s = new Son();
	}
	
	
	
	static class Father{
		int i ;
		
		public Father(){
			method();
		}
		
		public void method(){
			i++;
			System.out.println("father's"+i);
		}
	}
	
	static class Son extends Father{
		@Override
		public void method() {
			i = i+2;
			System.out.println("son's"+i);
		}
	}

}
