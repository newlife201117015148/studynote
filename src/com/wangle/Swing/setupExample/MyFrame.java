package com.wangle.Swing.setupExample;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws MalformedURLException
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private CardLayout layout = new CardLayout();
	private Page1 page1 = new Page1();
	private Page2 page2 = new Page2();
	private Page3 page3 = new Page3();
	private Page4 page4 = new Page4();
	private Page5 page5 = new Page5();
	private Page6 page6 = new Page6();
	private Page7 page7 = new Page7();
	public MyFrame() throws Exception {
		setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 360);
		setResizable(false);
		
		page1.setFrame(this);
		page2.setFrame(this);
		page3.setFrame(this);
		page4.setFrame(this);
		page5.setFrame(this);
		page6.setFrame(this);
		page7.setFrame(this);
		
		
		setLayout(layout);
		this.add(page1,"p1");
		this.add(page2,"p2");
		this.add(page3,"p3");
		this.add(page4,"p4");
		this.add(page5,"p5");
		this.add(page6,"p6");
		this.add(page7,"p7");
		Image image = Toolkit.getDefaultToolkit().getImage("dbeaver_perspective.png");
		this.setIconImage(image);
		this.setTitle("DBeaver Community 6.0.4 (x86_64) Setup");
	}
	
	public void set(int page){
		if(page == 1){
			layout.show(this.getContentPane(), "p1");
		}else if(page ==2){
			layout.show(this.getContentPane(), "p2");
		}else if(page ==3){
			layout.show(this.getContentPane(), "p3");
		}else if(page ==4){
			Page6.num = 0;
			layout.show(this.getContentPane(), "p4");
		}else if(page ==5){
			layout.show(this.getContentPane(), "p5");
		}else if(page ==6){
			layout.show(this.getContentPane(), "p6");
		}else if(page ==7){
			layout.show(this.getContentPane(), "p7");
		}
	}
}
