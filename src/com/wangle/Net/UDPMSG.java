package com.wangle.Net;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UDPMSG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UDPMSG frame = new UDPMSG();
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
	public UDPMSG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6CE8\u518C\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 10, 614, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setBounds(10, 34, 33, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("192.168.1.2");
		textField.setBounds(66, 31, 130, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPort = new JLabel("port");
		lblPort.setBounds(222, 34, 33, 15);
		panel.add(lblPort);
		
		textField_1 = new JTextField();
		textField_1.setText("8989");
		textField_1.setColumns(10);
		textField_1.setBounds(278, 31, 52, 21);
		panel.add(textField_1);
		
		JButton button = new JButton("\u767B\u8BB0\u7528\u6237\u5230\u670D\u52A1\u5668");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					client.reguser(textField.getText(), Integer.parseInt(textField_1.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(395, 30, 180, 23);
		panel.add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 96, 614, 195);
		contentPane.add(textArea);
		
		textField_2 = new JTextField();
		textField_2.setBounds(29, 326, 476, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u53D1\u9001");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_2.getText().length()==0){
						return;
					}
					client.send(textField.getText(), Integer.parseInt(textField_1.getText()),textField_2.getText());
					textField_2.setText("");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(515, 330, 114, 23);
		contentPane.add(btnNewButton);
		
		
		try {
			client = new UDPclient(textArea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private UDPclient client = null;
}
