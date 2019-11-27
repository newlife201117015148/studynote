package com.wangle.designPatterns.visitor;

public class Main {
	
	
	//�ݷ���ģʽ
	//���������������������ɣ���ͬ�Ŀͻ�Ⱥ��������ͬ���Żݲ���
	//˼������ôʵ��
	//ʵ�ֽ��ͣ�����������ֶ�ȥʵ��һ��accept��visitor���ķ������÷����Ὣ�������󴫹�ȥ����������ȥ����visitor�����visit���������ķ�����Ȼ��
	//�õ��������Ĳ��������ȡ���۸��ٶԼ۸���д������ͻ�������õ����ռ۸��ˡ� 
	
	//ע������ʺϽṹ�̶����࣬�������computer��
	//Ӧ�õıȽ��٣��������ڱ��������AST�������﷨���������㣺4+6*8-9
	//ASM��̬����ĸ�������������ֱ�����ڴ��ж�ȡ�������ļ������ҿ��Ը�д�������Ǵ��������visitorģʽ��
	public static void main(String[] args) {
		PersonalVisitor personal = new PersonalVisitor();
		EnterpriseVisitor enterprise = new EnterpriseVisitor();
		new Computer().computePrice(personal); 
		System.out.println(personal.totalPrice);
		new Computer().computePrice(enterprise); 
		System.out.println(enterprise.totalPrice);
	}
	
	static class Computer{
		
		
		public void computePrice(Visitor v){
			new Board().accept(v);
			new Cpu().accept(v);
			new Memory().accept(v);
		}
	}
	
	
	static abstract class ComputerPart{
		abstract void accept(Visitor v);
		abstract int getPrice();
	}

	static class Cpu extends ComputerPart{

		@Override
		void accept(Visitor v) {
			v.visitCpu(this);
			
		}

		@Override
		int getPrice() {
			// TODO Auto-generated method stub
			return 3000;
		}
		
	}
	
	static class Memory extends ComputerPart{

		@Override
		void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visitMemory(this);
		}

		@Override
		int getPrice() {
			// TODO Auto-generated method stub
			return 1000;
		}
		
	}
	
	static class Board extends ComputerPart{

		@Override
		void accept(Visitor v) {
			// TODO Auto-generated method stub
			v.visitBoard(this);
		}

		@Override
		int getPrice() {
			// TODO Auto-generated method stub
			return 1500;
		}
		
	}
	
	static interface Visitor{
		void visitCpu(Cpu cpu);
		void visitMemory(Memory memory);
		void visitBoard(Board board);
	}
	
	static class PersonalVisitor implements Visitor{
		int totalPrice = 0;
		@Override
		public void visitCpu(Cpu cpu) {
			totalPrice += cpu.getPrice()*0.9;
			
		}

		@Override
		public void visitMemory(Memory memory) {
			// TODO Auto-generated method stub
			totalPrice += memory.getPrice()*0.9;
		}

		@Override
		public void visitBoard(Board board) {
			// TODO Auto-generated method stub
			totalPrice += board.getPrice()*0.9;
		}
		
	}
	
	static class EnterpriseVisitor implements Visitor{
		int totalPrice = 0;
		@Override
		public void visitCpu(Cpu cpu) {
			totalPrice += cpu.getPrice()*0.7;
			
		}

		@Override
		public void visitMemory(Memory memory) {
			// TODO Auto-generated method stub
			totalPrice += memory.getPrice()*0.7;
		}

		@Override
		public void visitBoard(Board board) {
			// TODO Auto-generated method stub
			totalPrice += board.getPrice()*0.7;
		}
		
	}
}
