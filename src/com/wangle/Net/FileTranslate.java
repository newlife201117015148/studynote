package com.wangle.Net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JProgressBar;

public class FileTranslate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileTranslate frame = new FileTranslate();
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
	public FileTranslate() {
		setTitle("\u6587\u4EF6\u4F20\u8F93\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6587\u4EF6\u7CFB\u7EDF\u670D\u52A1\u5668", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(27, 10, 491, 134);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u7AEF\u53E3\uFF1A");
		label.setBounds(21, 35, 49, 31);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setText("8989");
		textField.setBounds(62, 40, 66, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		final JToggleButton toggleButton = new JToggleButton("\u542F\u52A8\u670D\u52A1\u5668");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggleButton.isSelected()){
					try {
						toggleButton.setText("关闭服务器");
						textField.setEditable(false);
						FileServer.openServer(Integer.parseInt(textField.getText()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else{
					toggleButton.setText("启动服务器");
					textField.setEditable(true);
					FileServer.closeServer();
				}
			}
		});
		toggleButton.setBounds(147, 39, 133, 23);
		panel_2.add(toggleButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5BA2\u6237\u7AEF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 165, 491, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u6587\u4EF6\uFF1A");
		label_1.setBounds(10, 10, 73, 15);
		panel_3.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 7, 269, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(FileTranslate.this);
				textField_1.setText(chooser.getSelectedFile().getPath());
			}
		});
		button.setBounds(351, 6, 51, 23);
		panel_3.add(button);
		
		JLabel lblip = new JLabel("\u670D\u52A1\u5668IP\uFF1A");
		lblip.setBounds(10, 47, 73, 15);
		panel_3.add(lblip);
		
		textField_2 = new JTextField();
		textField_2.setText("192.168.1.2");
		textField_2.setBounds(72, 44, 99, 21);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7AEF\u53E3\uFF1A");
		label_2.setBounds(190, 47, 54, 15);
		panel_3.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setText("8989");
		textField_3.setBounds(226, 44, 66, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		final JProgressBar progressBar = new JProgressBar();
		JButton button_1 = new JButton("\u53D1\u9001");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileClient client = new FileClient(textField_2.getText(),Integer.parseInt(textField_3.getText()),textField_1.getText(),progressBar);
				new Thread(client).start();
			}
		});
		button_1.setBounds(312, 126, 93, 23);
		panel_3.add(button_1);
		
		progressBar.setBounds(10, 88, 392, 28);
		panel_3.add(progressBar);
	}
}
