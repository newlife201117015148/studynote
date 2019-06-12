package com.wangle.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test06 extends JFrame implements MouseMotionListener,MouseWheelListener,MouseListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Test06 frame = new Test06();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Test06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {//点击
		System.out.println("mouseMoved:"+e.getX()+" "+e.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {//按下
		// TODO Auto-generated method stub
		System.out.println("mousePressed:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {//弹起
		// TODO Auto-generated method stub
		System.out.println("mouseReleased:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {//进入
		// TODO Auto-generated method stub
		System.out.println("mouseEntered:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {//移出
		// TODO Auto-generated method stub 
		System.out.println("mouseExited:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {//滚轮
		// TODO Auto-generated method stub
		System.out.println("mouseWheelMoved:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {//拖拽
		// TODO Auto-generated method stub
		System.out.println("mouseDragged:"+e.getX()+" "+e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {//移动
		// TODO Auto-generated method stub
		System.out.println("mouseMoved:"+e.getX()+" "+e.getY());
	}

}
