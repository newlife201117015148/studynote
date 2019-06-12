package com.wangle.Tread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Zxj extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zxj frame = new Zxj();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static JPanel 关羽 = new JPanel();
	static JPanel 曹操 = new JPanel();
	static JPanel 刘备 = new JPanel();
	static JPanel 王朗 = new JPanel();
	static JPanel 张飞 = new JPanel();
	/**
	 * Create the frame.
	 */
	public Zxj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		张飞.setBackground(Color.WHITE);
		
		
		张飞.setBounds(237, 30, 76, 71);
		contentPane.add(张飞);
		王朗.setBackground(Color.WHITE);
		王朗.setToolTipText("");
		
		
		王朗.setBounds(94, 146, 76, 71);
		contentPane.add(王朗);
		刘备.setBackground(Color.WHITE);
		
		
		刘备.setBounds(237, 277, 76, 71);
		contentPane.add(刘备);
		曹操.setBackground(Color.WHITE);
		
		
		曹操.setBounds(388, 203, 76, 71);
		contentPane.add(曹操);
		关羽.setBackground(Color.WHITE);
		
		
		关羽.setBounds(423, 86, 76, 71);
		contentPane.add(关羽);
	}
}
