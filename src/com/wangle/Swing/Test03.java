package com.wangle.Swing;


import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test03 {

	
	public static void main(String[] args) throws InterruptedException {
		//���֣���ʽ���֣�flow��  ��Ƭ����(card)   ��񲼾�(grid)   �߽粼�֣�border)��ͬ�̳���LayoutManager�ӿ�
		System.out.println("---------------------��ʽ���֣�flow��----------------------");
//		Frame frame = new Frame("����һ������");
//		FlowLayout flowLayout = new FlowLayout();
//		flowLayout.setAlignment(FlowLayout.LEFT);
//		frame.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));//FlowLayout���������������ֱ��Ƕ��뷽ʽ��Hgap��������Vgap������
//		frame.setBounds(800, 500, 400, 400);
//		
//		for (int i = 0; i < 100; i++) {
//			Button button = new Button(i+"button");
//			frame.add(button);
//			button.setPreferredSize(new Dimension(50, 50));//һ�������趨���˲��֣�����������������λ�úʹ�С,ֻ��ͨ��setPreferredSize��ʽ���ô�С
//		}
//		frame.setVisible(true);
		System.out.println("--------------------��Ƭ����(card)-----------------------");
//		���˿��ƣ��ѵ���һ��
//		Frame frame = new Frame("����һ������");
//		frame.setBounds(800, 500, 400, 400);
//		CardLayout card = new CardLayout(10, 10);
//		frame.setLayout(card);
//		frame.setVisible(true);
//		for (int i = 0; i < 100; i++) {
//			Button button = new Button(i+"button");
//			frame.add(button);
//			button.setPreferredSize(new Dimension(500, 500));//һ�������趨���˲��֣�����������������λ�úʹ�С,setPreferredSize������
//		}
////		card.previous(frame);//������һҳ
//		
//		while(true){
//			card.next(frame);//������һҳ
//			Thread.sleep(500);
//		}
		System.out.println("-------------------�߽粼�֣�border)-----------------------");
//		Frame frame = new Frame("����һ������");
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
		
		System.out.println("--------------------�߽粼�֣�border)��һ������-----------------------");
//		Frame frame = new Frame("����һ������");
//		frame.setBounds(800, 500, 400, 400);
//		frame.setVisible(true);
//		frame.setLayout(new BorderLayout(10, 20));
//		
//		Panel panel = new Panel(new CardLayout());
//		panel.setBackground(Color.red);
//		Label label = new Label("һ����װ����");
//		label.setFont(new Font("", Font.BOLD, 40));
//		panel.add(label);
//		
//		frame.add(panel,BorderLayout.NORTH);
//		
//		Panel p2  = new Panel(new FlowLayout(FlowLayout.RIGHT, 2, 1));
//		p2.setBackground(Color.green);
//		Button button1 = new Button("��һ��");
//		button1.setPreferredSize(new Dimension(100, 30));
//		Button button2 = new Button("��һ��");
//		button2.setPreferredSize(new Dimension(100, 30));
//		p2.add(button1);
//		p2.add(button2);
//		
//		frame.add(p2,BorderLayout.SOUTH);
		System.out.println("--------------------��񲼾�(grid)-----------------------");
		Frame frame = new Frame("����һ������");
		frame.setBounds(800, 500, 400, 400);
		GridLayout gridLayout = new GridLayout(10, 10, 1, 1);
		frame.setLayout(gridLayout);
		for (int i = 0; i < 100; i++) {
			Button button = new Button(i+"button");
			frame.add(button);
//			button.setPreferredSize(new Dimension(500, 500));//һ�������趨���˲��֣�����������������λ�úʹ�С,setPreferredSize������
		}
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
			});
		frame.setVisible(true);
	}
}
