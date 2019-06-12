package com.wangle.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Test07 extends JFrame implements FocusListener ,WindowListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test07 frame = new Test07();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test07() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关掉所有的窗口
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关掉当前的窗口
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//关掉当前的窗口,只是隐藏
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(85, 62, 233, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 134, 233, 28);
		contentPane.add(textField_1);
		textField.addFocusListener(this);
		textField_1.addFocusListener(this);
		this.addWindowListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == textField_1) {
			if(textField_1.getText().trim().equals("请填写密码")){
				textField_1.setText("");
			}
		} else if (e.getSource() == textField) {
			if(textField.getText().trim().equals("请填写名字")){
				textField.setText("");
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == textField_1) {
			textField_1.setText("请填写密码");
		} else if (e.getSource() == textField) {
			textField.setText("请填写名字");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int i = JOptionPane.showConfirmDialog(this, "真的要关闭吗？");
		System.out.println(i);
		if(i==0){
			this.dispose();
		}else if (i ==1){
//			this.setVisible(true);
//			this.setAlwaysOnTop(true);
		}else{
			
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
