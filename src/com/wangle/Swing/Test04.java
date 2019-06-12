package com.wangle.Swing;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test04 extends JFrame{
//	委托事件模型  ===》》观察者设计模式（我把代码给你，一旦发生事件你就通知我）
//	能产生动作的就是键盘和鼠标事件
//	一是键盘事件处理流程：键盘A建---》传给系统键盘处理程序---》当前应用程序（如：前进后退）
//	鼠标事件：首先明白显示器是以每秒60多帧的速度刷屏，将每个图片连续显示出来，当你点击某一点的时候，记录x,y坐标---》鼠标管理系统---》图形系统---》搜索出应用程序 ---》应用程序完成后返回给图形系统
//	java中委托事件原理：鼠标和键盘的事件交给系统=====》系统=====》系统处理完了，交给视图对象---》视图对象再执行代码，整个过程相当于把代码委托给了试图对象
	
	public Test04() {
		
		
		this.setBounds(500, 500, 500, 500);
		
		
		Image image;
		try {
			image = Toolkit.getDefaultToolkit().getImage(new URL("https://www.baidu.com/img/baidu_jgylogo3.gif"));
			Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0), "222");
			this.setCursor(cursor);
			this.setIconImage(image);
			this.setLayout(null);
			JButton button = new JButton("按钮");
			button.setBounds(10, 10, 100, 100);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is actionevent");
					
				}
			});
			this.getContentPane().add(button);
			this.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void main(String[] args) {

		new Test04();
	}


	
	
}
