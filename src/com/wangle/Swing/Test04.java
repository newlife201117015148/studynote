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
//	ί���¼�ģ��  ===�����۲������ģʽ���ҰѴ�����㣬һ�������¼����֪ͨ�ң�
//	�ܲ��������ľ��Ǽ��̺�����¼�
//	һ�Ǽ����¼��������̣�����A��---������ϵͳ���̴������---����ǰӦ�ó����磺ǰ�����ˣ�
//	����¼�������������ʾ������ÿ��60��֡���ٶ�ˢ������ÿ��ͼƬ������ʾ������������ĳһ���ʱ�򣬼�¼x,y����---��������ϵͳ---��ͼ��ϵͳ---��������Ӧ�ó��� ---��Ӧ�ó�����ɺ󷵻ظ�ͼ��ϵͳ
//	java��ί���¼�ԭ�����ͼ��̵��¼�����ϵͳ=====��ϵͳ=====��ϵͳ�������ˣ�������ͼ����---����ͼ������ִ�д��룬���������൱�ڰѴ���ί�и�����ͼ����
	
	public Test04() {
		
		
		this.setBounds(500, 500, 500, 500);
		
		
		Image image;
		try {
			image = Toolkit.getDefaultToolkit().getImage(new URL("https://www.baidu.com/img/baidu_jgylogo3.gif"));
			Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0), "222");
			this.setCursor(cursor);
			this.setIconImage(image);
			this.setLayout(null);
			JButton button = new JButton("��ť");
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
