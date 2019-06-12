package com.wangle.Swing.setupExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page1 extends JPanel {
	private MyFrame myFrame ;
	
	public void setFrame(MyFrame myFrame){
		this.myFrame = myFrame;
	}
	/**
	 * Create the panel.
	 */
	public Page1() {
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel(new ImageIcon("logo2.png"));
		this.add(lblNewLabel, BorderLayout.WEST);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(8);
		flowLayout.setHgap(12);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		this.add(panel, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u6B65(N) >");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(2);
			}
			
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(btnNewButton_2);

		JButton btnNewButton = new JButton("\u53D6\u6D88(C)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		this.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(8);
		panel_2.add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BFC");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 26, 406, 34);
		panel_4.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528 DBeaver Community \u5B89\u88C5\u5411");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		label.setBounds(0, 10, 406, 34);
		panel_4.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\u8FD9\u4E2A\u5411\u5BFC\u5C06\u6307\u5F15\u4F60\u5B8C\u6210 DBeaver Community \u7684\u5B89\u88C5\u8FDB");
		lblNewLabel_2.setBounds(0, 59, 406, 41);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7A0B\u3002");
		lblNewLabel_3.setBounds(0, 85, 54, 15);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5728\u5F00\u59CB\u5B89\u88C5\u4E4B\u524D\uFF0C\u5EFA\u8BAE\u5148\u5173\u95ED\u5176\u5B83\u6240\u6709\u5E94\u7528\u7A0B\u5E8F\u3002\u8FD9\u5C06");
		lblNewLabel_4.setBounds(0, 110, 293, 15);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5141\u8BB8\u201C\u5B89\u88C5\u7A0B\u5E8F\u201D\u66F4\u65B0\u6307\u5B9A\u7684\u5173\u7CFB\u6587\u4EF6\uFF0C\u800C\u4E0D\u9700\u8981\u91CD\u65B0");
		lblNewLabel_5.setBounds(0, 124, 293, 15);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u542F\u52A8\u4F60\u7684\u8BA1\u7B97\u673A\u3002");
		lblNewLabel_6.setBounds(0, 135, 293, 15);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5355\u51FB [\u4E0B\u4E00\u6B65(N)] \u7EE7\u7EED\u3002");
		lblNewLabel_7.setBounds(0, 160, 293, 15);
		panel_4.add(lblNewLabel_7);
	}

}
