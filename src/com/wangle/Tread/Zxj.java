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
	static JPanel ���� = new JPanel();
	static JPanel �ܲ� = new JPanel();
	static JPanel ���� = new JPanel();
	static JPanel ���� = new JPanel();
	static JPanel �ŷ� = new JPanel();
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
		�ŷ�.setBackground(Color.WHITE);
		
		
		�ŷ�.setBounds(237, 30, 76, 71);
		contentPane.add(�ŷ�);
		����.setBackground(Color.WHITE);
		����.setToolTipText("");
		
		
		����.setBounds(94, 146, 76, 71);
		contentPane.add(����);
		����.setBackground(Color.WHITE);
		
		
		����.setBounds(237, 277, 76, 71);
		contentPane.add(����);
		�ܲ�.setBackground(Color.WHITE);
		
		
		�ܲ�.setBounds(388, 203, 76, 71);
		contentPane.add(�ܲ�);
		����.setBackground(Color.WHITE);
		
		
		����.setBounds(423, 86, 76, 71);
		contentPane.add(����);
	}
}
