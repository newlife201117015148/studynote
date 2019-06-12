package com.wangle.Swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test05 extends JFrame implements KeyListener{

	public static void main(String[] args) {
		
		Test05 frame = new Test05();
		frame.setVisible(true);
	}
	private JLabel label;
	public Test05() {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(500, 500, 500, 500);
			this.setLayout(null);
			label = new JLabel(new ImageIcon(new URL("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super")));
			label.setBounds(10, 10, 100, 100);
			this.add(label);
			this.addKeyListener(this);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W){
			label.setLocation(label.getX(), label.getY()-5);
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			label.setLocation(label.getX()+5, label.getY());
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			label.setLocation(label.getX(), label.getY()+5);
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			label.setLocation(label.getX()-5, label.getY());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
