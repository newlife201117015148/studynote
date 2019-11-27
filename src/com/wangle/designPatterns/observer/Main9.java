package com.wangle.designPatterns.observer;

public class Main9 {
	//模拟java中button的实现
	public static void main(String[] args) {
		Main9 m = new Main9();
		Button button = m.new Button();
		button.addListener(m.new Mylistener());
		button.processActionEvent();
	}
	
	interface EventListener{
		void actionPerformed(ActionEvent e);
	}
	class Mylistener implements EventListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			PressEvent pe = (PressEvent)e;
			System.out.println(pe.getName()+"被按下");
		}
		
	}
	abstract class ActionEvent{
		abstract Object getSource();
	}
	class PressEvent extends ActionEvent{
		private String name = "鼠标左键";
		@Override
		Object getSource() {
			return null;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	class Button{
		private EventListener listener;
		public void addListener(EventListener listener){
			this.listener = listener;
		}
		public void processActionEvent(){
			listener.actionPerformed(new PressEvent());
		}
	}
}
