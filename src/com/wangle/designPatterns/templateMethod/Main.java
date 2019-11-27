package com.wangle.designPatterns.templateMethod;

public class Main {
	//模板方法
	//也叫钩子函数、回调方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		F f = new C1();
		f.m();
	}

	
	static abstract class F{
		public void m(){
			op1();
			op2();
		}
		//这就是制定的模板，只是还没实现，你要用就重写，并且会由其它类自动调用，这里是由F来调用
		abstract void op1();
		abstract void op2();
		
	}
	
	static class C1 extends F{

		@Override
		void op1() {
			// TODO Auto-generated method stub
			System.out.println("op1");
		}

		@Override
		void op2() {
			// TODO Auto-generated method stub
			System.out.println("op2");
		}
		
	}
}
