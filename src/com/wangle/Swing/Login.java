package com.wangle.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JButton btnNewButton;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);//是否能够通过外部皮肤（lookandFeel）进行装饰
//		UIManager.setLookAndFeel("");//参数指明新皮肤的类路径
		
		
//		swing和awt的区别不大，用的时候swing的组件都是以J开头的，如Jframe，JButton，Jpanel
//		另外awt可以直接在Frame中加组件，而swing只能先getContentPane()然后在网里加东西。
//		一般在开发的时候，是一个页面一个类，如登陆界面就是Login类，这个继承与Jframe，他就是一个窗口了
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u540D\u79F0\uFF1A");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(30, 54, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(115, 51, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(30, 97, 54, 15);
		contentPane.add(label);
		
		btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setBounds(159, 159, 72, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 94, 116, 21);
		contentPane.add(passwordField);
	}
}
