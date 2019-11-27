package com.wangle.designPatterns.command;

import java.util.ArrayList;
import java.util.List;

import com.wangle.designPatterns.command.Main.ChainOfUnDo;

public class Main {
	//����ģʽ
	//���ã�Undo����������
	//������Action(��������Ϊ��/Transation(����)
	//���������������ϣ�command��composite��Ͽ���ʵ��
	//���Undo��command��chainofresponsibility��Ͽ���ʵ��
	//transation�ع���command�ͱ���¼ģʽ��Ͽ���ʵ��
	public static void main(String[] args) {
		InsertCommand insert = new InsertCommand();
		insert.setMsg("�Ҿ����ң���һ�����̻�");
		CopyCommand copy = new CopyCommand();
		DeleteCommand delete = new DeleteCommand();
		ChainOfUnDo chain = new ChainOfUnDo();
		chain.add(insert);
		chain.add(copy);
		chain.add(delete);
		chain.exec();
		
		System.out.println(delete.getMsg());
	}
	static class ChainOfUnDo{
		List<Command> commands = new ArrayList<>();
		public void add(Command c){
			commands.add(c);
		}
		
		int index = 0;
		public void exec(){
			if(index == commands.size()) return ;
			Command command = commands.get(index);
			index ++;
			command.doitAndUndo(this);
		}
	}
	static abstract class Command{
		static String msg;
		abstract void doit();
		abstract void undo();
		abstract void doitAndUndo(ChainOfUnDo undos);
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			Command.msg = msg;
		}
		
	}
	
	static class InsertCommand extends Command{

		String insertString = "��ѧϰ�ҿ��֣�";
		@Override
		public void doit() {
			
			msg += insertString;
		}

		@Override
		public void undo() {
			msg = msg.substring(0,msg.length()-insertString.length());
		}


		@Override
		void doitAndUndo(ChainOfUnDo undos) {
			doit();
			System.out.println("insert before:"+this.getMsg());
			undos.exec();
			undo();
			System.out.println("insert after"+this.getMsg());
		}
		
	}

	static class CopyCommand extends Command{

		@Override
		public void doit() {
			
			msg += msg;
		}

		@Override
		public void undo() {
			msg = msg.substring(0,msg.length()/2);
		}

		@Override
		void doitAndUndo(ChainOfUnDo undos) {
			// TODO Auto-generated method stub
			doit();
			System.out.println("copy before"+this.getMsg());
			undos.exec();
			undo();
			System.out.println("copy after"+this.getMsg());
		}
		
	}
	
	static class DeleteCommand extends Command{

		String deleteString;
		@Override
		public void doit() {
			
			deleteString = msg.substring(4);
			msg = msg.substring(0,4);
		}

		@Override
		public void undo() {
			msg += deleteString;
		}

		@Override
		void doitAndUndo(ChainOfUnDo undos) {
			// TODO Auto-generated method stub
			doit();
			System.out.println("delete before"+this.getMsg());
			undos.exec();
			undo();
			System.out.println("delete after"+this.getMsg());
		}
		
	}
}
