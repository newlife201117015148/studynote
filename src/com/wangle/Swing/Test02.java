package com.wangle.Swing;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test02 {

	public static void main(String[] args) {
		
		final Frame frame = new Frame("我是一个窗口");
		frame.setBounds(500, 500, 300, 300);
		frame.setLayout(null);//设置为空后，添加进去的组件必须说明位置和大小
		
		Label label = new Label("名字：");
		label.setBounds(40,85, 50, 50);
		TextField field = new TextField();
		field.setBounds(100, 100, 100, 20);
		Label label2 = new Label("密码：");
		label2.setBounds(40,145, 50, 50);
		TextField field2 = new TextField();
		field2.setBounds(100, 160, 100, 20);
		field2.setEchoChar('*');
		final Button button = new Button("登陆");
		button.setBounds(150, 200, 50, 25);
		frame.add(button);
		frame.add(label);
		frame.add(field);
		frame.add(label2);
		frame.add(field2);
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				System.out.println("dd");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.setVisible(true);
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Dialog dialog = new Dialog(frame,"asdfa");
				dialog.setBounds(100, 10, 100, 100);
				dialog.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
