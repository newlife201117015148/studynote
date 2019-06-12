package com.wangle.JDBC;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test06 extends JFrame{
	private JPasswordField passwordField;
	private JTextField textField;
	public Test06() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = passwordField.getText();
				String u = textField.getText();
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
					
					
//					u = "' or  ''= '";//这样可以不需要账号和密码就能登陆，是相当危险的，解决办法就是预处理
//					p = "' or  ''= '";//
//					Statement st = con.createStatement();
//					String sql = "select * from users where username = '"+u+"' and password = '"+p+"'";
//					ResultSet re = st.executeQuery(sql);
					String sql = "select * from users where username = ? and password = ?";
					PreparedStatement prst = con.prepareStatement(sql);
					//只要是用户提交的数据都交给预处理，不要用statement
					prst.setString(1, u);
					prst.setString(2, p);
					ResultSet re = prst.executeQuery();
					System.out.println(sql);
					
					if(re.next()){
						javax.swing.JOptionPane.showMessageDialog(Test06.this, "登陆成功 ");
					}else{
						javax.swing.JOptionPane.showMessageDialog(Test06.this, "登陆失败 ");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}finally{
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		btnNewButton.setBounds(163, 157, 93, 23);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(65, 61, 224, 21);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(65, 10, 224, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(10, 13, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(22, 64, 36, 15);
		getContentPane().add(label_1);
	}
	
	public static void main(String[] args) {
		Test06 t = new Test06();
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setBounds((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth()-500f)/2f), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300f)/2f), 500, 300);
		t.setVisible(true);
	}
}
