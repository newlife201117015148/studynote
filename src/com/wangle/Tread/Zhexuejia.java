package com.wangle.Tread;

import java.awt.Color;

import javax.swing.JPanel;

public class Zhexuejia extends Thread{
	
	private String name;
	private Kuaizi k1;
	private Kuaizi k2;
	private JPanel panel;
	
	public Zhexuejia(String name,Kuaizi k1,Kuaizi k2,JPanel panel){
		this.name = name;
		this.k1 = k1;
		this.k2 = k2;
		this.panel = panel;
	}

	public void naqi(){
		k1.naqi();
		k2.naqi();
		panel.setBackground(Color.red);
		System.out.println(this.name+"��ѧ�ҿ�ʼ�Է���");
	}
	
	public void fangxia(){
		k1.fangxia();
		k2.fangxia();
		panel.setBackground(Color.WHITE);
		System.out.println(this.name+"��ѧ�ҷ��¿�����");
	}
	@Override
	public void run() {
		try {
			while(true){
				naqi();
				Thread.sleep(1000);
				fangxia();
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
