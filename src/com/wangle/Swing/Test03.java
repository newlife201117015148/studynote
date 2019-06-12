package com.wangle.Swing;


import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test03 {

	
	public static void main(String[] args) throws InterruptedException {
		//布局：流式布局（flow）  卡片布局(card)   表格布局(grid)   边界布局（border)共同继承于LayoutManager接口
		System.out.println("---------------------流式布局（flow）----------------------");
//		Frame frame = new Frame("我是一个窗口");
//		FlowLayout flowLayout = new FlowLayout();
//		flowLayout.setAlignment(FlowLayout.LEFT);
//		frame.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));//FlowLayout构造器三个参数分别是对齐方式，Hgap横向间隔，Vgap纵向间隔
//		frame.setBounds(800, 500, 400, 400);
//		
//		for (int i = 0; i < 100; i++) {
//			Button button = new Button(i+"button");
//			frame.add(button);
//			button.setPreferredSize(new Dimension(50, 50));//一旦容器设定好了布局，里面的组件不能设置位置和大小,只能通过setPreferredSize方式设置大小
//		}
//		frame.setVisible(true);
		System.out.println("--------------------卡片布局(card)-----------------------");
//		像扑克牌，堆叠在一起
//		Frame frame = new Frame("我是一个窗口");
//		frame.setBounds(800, 500, 400, 400);
//		CardLayout card = new CardLayout(10, 10);
//		frame.setLayout(card);
//		frame.setVisible(true);
//		for (int i = 0; i < 100; i++) {
//			Button button = new Button(i+"button");
//			frame.add(button);
//			button.setPreferredSize(new Dimension(500, 500));//一旦容器设定好了布局，里面的组件不能设置位置和大小,setPreferredSize都不行
//		}
////		card.previous(frame);//这是上一页
//		
//		while(true){
//			card.next(frame);//这是下一页
//			Thread.sleep(500);
//		}
		System.out.println("-------------------边界布局（border)-----------------------");
//		Frame frame = new Frame("我是一个窗口");
//		frame.setBounds(800, 500, 400, 400);
//		frame.setVisible(true);
//		frame.setLayout(new BorderLayout(10, 10));
//		
//		Button button1 = new Button("EAST");
//		frame.add(button1, BorderLayout.EAST);
//		
//		Button button2 = new Button("NORTH");
//		frame.add(button2, BorderLayout.NORTH);
//		
//		Button button3 = new Button("WEST");
//		frame.add(button3, BorderLayout.WEST);
//		
//		Button button4 = new Button("SOUTH");
//		frame.add(button4, BorderLayout.SOUTH);
//		
//		Button button5 = new Button("CENTER");
//		frame.add(button5, BorderLayout.CENTER);
		
		System.out.println("--------------------边界布局（border)的一个例子-----------------------");
//		Frame frame = new Frame("我是一个窗口");
//		frame.setBounds(800, 500, 400, 400);
//		frame.setVisible(true);
//		frame.setLayout(new BorderLayout(10, 20));
//		
//		Panel panel = new Panel(new CardLayout());
//		panel.setBackground(Color.red);
//		Label label = new Label("一个安装程序");
//		label.setFont(new Font("", Font.BOLD, 40));
//		panel.add(label);
//		
//		frame.add(panel,BorderLayout.NORTH);
//		
//		Panel p2  = new Panel(new FlowLayout(FlowLayout.RIGHT, 2, 1));
//		p2.setBackground(Color.green);
//		Button button1 = new Button("上一步");
//		button1.setPreferredSize(new Dimension(100, 30));
//		Button button2 = new Button("下一步");
//		button2.setPreferredSize(new Dimension(100, 30));
//		p2.add(button1);
//		p2.add(button2);
//		
//		frame.add(p2,BorderLayout.SOUTH);
		System.out.println("--------------------表格布局(grid)-----------------------");
		Frame frame = new Frame("我是一个窗口");
		frame.setBounds(800, 500, 400, 400);
		GridLayout gridLayout = new GridLayout(10, 10, 1, 1);
		frame.setLayout(gridLayout);
		for (int i = 0; i < 100; i++) {
			Button button = new Button(i+"button");
			frame.add(button);
//			button.setPreferredSize(new Dimension(500, 500));//一旦容器设定好了布局，里面的组件不能设置位置和大小,setPreferredSize都不行
		}
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
			});
		frame.setVisible(true);
	}
}
