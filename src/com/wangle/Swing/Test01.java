package com.wangle.Swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		//GUI图形化用户界面的发展，全球第一家做GUI的是APPLE苹果公司，后来被微软抄袭，后来发展成为全球垄断的PC界面。
		//万事万物皆对象，所以GUI图形化用户界面的设计也是同样的道理，聪明的设计师，将这些UI组件封装成各种各样的类
		//并且对他们进行分类，继承，实现，构成一个庞大的家族。首先认识AWT的祖先类java.awt.Component。
		
//		组件(component)是构成图形用户界面的基本成分和核心元素，组件类(Component)是一个抽象类，是AWT组件类的根类，实际使用的组件都是Component的子类。
//		Component类提供对组件操作的通用方法，包括设计组件位置，设置组件大小，设计组件字体，响应鼠标或键盘事件，组件重绘等。
		
		//组件分为两个大类，一种是容器组件，一种是普通组件
//		容器
//		   容器(container)是一种特殊组件，他能容纳其他组件。它在可视区域内显示其他组件。由于容器是组件，在容器中还可以放置其他容器，所以可以使用多层容器构成富有变化的界面。
//	         窗口和面板
//		      容器有两种：窗口(window)和面板(panel).
//		      窗口可独立存在，可被移动，也可被最大化和最小化，有标题栏，边框，可添加菜单栏。面板不能独立存在，必须包含在另一个容器中，面板没有标题。没有边框，
//			     不可以添加菜单栏，一个窗口可以包含多个面板，一个面板也可以包含另一个面板，但面板不能包含窗口。
//		窗口类(Window)主要有两个子类：框架类(Frame)和对话框类(Dialog)。
//		   框架是一种带标题栏并且可以改变的大小的窗口，在应用程序中，使用框架作为容器，在框架中放置组件。框架类在实例化时默认是最小化的，不可见的，必须通过setSize()方法设置框架大小，通过setVisible()方法使框架可见。
//		   框架类的构造方法和主要成员方法如下：
//		构造方法：
//		   Frame()  //创建一个没有标题的窗口
//		   Frame(String title)   //创建title为标题的窗口
//
//		   成员方法：
//		   int getState()   //获得Frame窗口的状态(Frame.Normal 表示一般状态，Frame.ICONIFIED表示最小化状态)
//		   void setState(int state)   //获得Frame窗口的状态(Frame.Normal 表示一般状态，Frame.ICONIFIED表示最小化状态)
//		   String getTitle()   //获得Frame窗口的标题
//		   void setTitle(String title)   //设置Frame窗口的标题
//		   boolean  isResizable()   //测试Frame窗口是否可以改变大小
//		   void setResizable()   //设置Frame是否可以改变大小
//		   Image getIconImage()   //返回窗口的最小化图标
//		   void setIconImage(Image img)   //设置窗口的最小化图标为img
//		   void setSize(int a,int b)   //设置长为a,宽为b的窗口
//		   void setLocation(int a,int b)   //设置窗口左上角距离屏幕左上角水平距离为a像素，垂直距离为b像素
//		   setBounds(int a,int b,int c,int d)   //设置窗口左上角位于屏幕左上角，长为c像素，宽为d像素
//		   void setVisible(boolean a)   //设置窗口是否可视化
//		   boolean isVisible()   //返回窗口是否可视化
//		   void setBackground(Color.red)   //设置窗口的背景颜色为红色
//		   void add(Component a)   //像窗口中添加组件a
//		   void setLayout(null)   //关闭窗口的默认布局管理,默认是流式布局
//		   void setLayout(布局管理器)   //设置使用特定的布局管理器
//
//		   对话框(dialog)也是一种可移动的窗口，它比框架简单，没有太多的控制元素，如最大化按钮，状态栏等。
//		   对话框不能作为应用程序的主窗口，它依赖于一个框架窗口而存在。对话框类的构造方法必须声明对话框所依赖的框架窗口。
		
			final Frame frame = new Frame("hello word");
			
			frame.setCursor(Cursor.WAIT_CURSOR);//设置光标样式，如小手、等待、文本
			frame.setBackground(Color.red);//设置背景颜色
			frame.setAlwaysOnTop(true);//置顶
			frame.setUndecorated(true);//设置无框架
			frame.setSize(100, 100);//设置大小
			frame.setLocation(100,100);//设置位置
			frame.setBounds(300, 300, 220,220);//设置位置和大小
			frame.setVisible(true);//设置可见
			frame.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					Random random = new Random();
					frame.setLocation(random.nextInt(1024),random.nextInt(1024));//设置位置
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			

	}
}
