package com.wangle.designPatterns.visitor;

public class Main {
	
	
	//拜访者模式
	//场景：计算机有三部分组成，不同的客户群体会给出不同的优惠策略
	//思考：怎么实现
	//实现解释：计算机三部分都去实现一个accept（visitor）的方法，该方法会将部件对象传过去，方法里面去调用visitor对象的visit（部件）的方法，然后
	//拿到传过来的部件对象获取到价格，再对价格进行处理。最后客户对象就拿到最终价格了。 
	
	//注意事项：适合结构固定的类，如这里的computer。
	//应用的比较少，常常用在编译器里的AST（抽象语法树），如算：4+6*8-9
	//ASM动态代理的根本，不仅可以直接在内存中读取二进制文件，而且可以改写。它就是大面积运用visitor模式。
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
