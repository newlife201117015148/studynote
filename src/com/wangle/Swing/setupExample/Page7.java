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
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page7 extends JPanel {
	private MyFrame myFrame;

	public void setFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	/**
	 * Create the panel.
	 */
	public Page7() {
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

		JButton btnNewButton_2 = new JButton("< \u4E0A\u4E00\u6B65(P)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(6);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(btnNewButton_2);

		JButton btnf = new JButton("  \u5B8C\u6210(F)  ");
		btnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnf.setMargin(new Insets(2, 2, 2, 2));
		btnf.setFont(new Font("宋体", Font.PLAIN, 12));
		panel_1.add(btnf);

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

		JLabel lblNewLabel_2 = new JLabel("DBeaver Community \u5DF2\u5B89\u88C5\u5728\u4F60\u7684\u7CFB\u7EDF\u3002");
		lblNewLabel_2.setBounds(0, 59, 406, 41);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5355\u51FB [\u5B8C\u6210(F)] \u5173\u7CFB\u6B64\u5411\u5BFC\u3002");
		lblNewLabel_3.setBounds(0, 85, 254, 15);
		panel_4.add(lblNewLabel_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Create Desktop Shortcut");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(0, 137, 235, 23);
		panel_4.add(chckbxNewCheckBox);
	}
}
