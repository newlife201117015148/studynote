package com.wangle.designPatterns.templateMethod;

public class Main {
	//ģ�巽��
	//Ҳ�й��Ӻ������ص�����
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
		//������ƶ���ģ�壬ֻ�ǻ�ûʵ�֣���Ҫ�þ���д�����һ����������Զ����ã���������F������
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
