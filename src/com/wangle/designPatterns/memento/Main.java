package com.wangle.designPatterns.memento;

public class Main {
	//����¼ģʽ
	//���ã���¼���գ�˲ʱ״̬��������
	//����Ӧ�����Ӿ�����Ϸ���
	//�������java���л�����google��Դ��protobuf
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
