package com.wangle.Swing.setupExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Page4 extends JPanel {
	private MyFrame myFrame;

	public void setFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public Page4() throws Exception {
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_18.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setHgap(10);
		panel.add(panel_18, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_18.add(panel_1);

		JButton btnNewButton_2 = new JButton("< \u4E0B\u4E00\u6B65(P)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(3);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(btnNewButton_2);

		JButton btni = new JButton("\u4E0B\u4E00\u6B65(N) >");
		btni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(5);
			}
		});
		btni.setMargin(new Insets(2, 2, 2, 2));
		btni.setFont(new Font("宋体", Font.PLAIN, 12));
		panel_1.add(btni);

		JButton btnNewButton = new JButton("\u53D6\u6D88(C)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_18.add(btnNewButton);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));

		JPanel panel_21 = new JPanel();
		panel_21.setPreferredSize(new Dimension(100, 15));
		panel.add(panel_21, BorderLayout.NORTH);
		panel_21.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel_21.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 5));

		JSeparator separator = new JSeparator();
		panel_16.add(separator);

		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_19.getLayout();
		flowLayout_5.setVgap(3);
		panel_16.add(panel_19, BorderLayout.NORTH);

		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_20.getLayout();
		panel_16.add(panel_20, BorderLayout.EAST);

		JPanel panel_17 = new JPanel();
		panel_21.add(panel_17, BorderLayout.WEST);
		panel_17.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel(" Universal Database Manager ");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 12));
		panel_17.add(lblNewLabel_6);

		JPanel panel_22 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_22.getLayout();
		flowLayout_8.setVgap(0);
		panel_17.add(panel_22, BorderLayout.NORTH);

		JPanel panel_15 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_15.getLayout();
		flowLayout_7.setVgap(3);
		panel.add(panel_15, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		this.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7, BorderLayout.WEST);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_2 = new JLabel("  \u9009\u62E9\u7EC4\u4EF6");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 13));
		panel_7.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				"    \u9009\u62E9\u4F60\u60F3\u8981\u5B89\u88C5 DBeaver Community \u7684\u90A3\u4E9B\u529F\u80FD\u3002");
		panel_7.add(lblNewLabel_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_8, BorderLayout.EAST);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("logo1.png"));
		panel_8.add(lblNewLabel_1);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_2.add(panel_13, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		this.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setHgap(10);
		panel_3.add(panel_4, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_23 = new JPanel();
		panel_6.add(panel_23);

		JLabel lblNewLabel = new JLabel(
				"\u52FE\u9009\u4F60\u60F3\u8981\u5B89\u88C5\u7684\u7EC4\u4EF6\uFF0C\u5E76\u89E3\u9664\u4F60\u52FE\u9009\u4F60\u4E0D\u5E0C\u671B\u5B89\u88C5\u7684\u7EC4\u4EF6\u3002\u5355\u51FB [\u4E0B\u4E00\u6B65(N)] \u7EE7");
		panel_6.add(lblNewLabel);

		JLabel lblNewLabel_5 = new JLabel("\u7EED\u3002");
		panel_6.add(lblNewLabel_5);

		JPanel panel_32 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_32.getLayout();
		flowLayout_2.setVgap(10);
		panel_6.add(panel_32);

		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_29 = new JPanel();
		panel_9.add(panel_29, BorderLayout.WEST);

		JLabel lblNewLabel_9 = new JLabel("\u9009\u5B9A\u5B89\u88C5\u7684\u7EC4\u4EF6\uFF1A");
		panel_29.add(lblNewLabel_9);

		JPanel panel_30 = new JPanel();
		panel_9.add(panel_30, BorderLayout.CENTER);

		JPanel panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(300, 100));
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_31.setBackground(Color.WHITE);
		panel_9.add(panel_31, BorderLayout.EAST);
		panel_31.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("DBeaver Community");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(1, 1, 191, 16);
		chckbxNewCheckBox.setBackground(Color.WHITE);
		panel_31.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("JRE");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setBounds(1, 17, 191, 16);
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		panel_31.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Reset Settings");
		chckbxNewCheckBox_2.setBounds(1, 33, 191, 16);
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		panel_31.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Associate .SQL file");
		chckbxNewCheckBox_3.setBounds(1, 49, 191, 16);
		chckbxNewCheckBox_3.setBackground(Color.WHITE);
		panel_31.add(chckbxNewCheckBox_3);

		ButtonGroup buttonGroup = new ButtonGroup();

		File file = new File("xieyi.txt");
		FileInputStream inputStream = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		inputStream.read(b);

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new BorderLayout(5, 5));

		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.WEST);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));

		JPanel panel_25 = new JPanel();
		panel_12.add(panel_25);

		JLabel lblNewLabel_4 = new JLabel("\u6240\u9700\u7A7A\u95F4\uFF1A93.6MB");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		panel_12.add(lblNewLabel_4);

		JPanel panel_24 = new JPanel();
		panel_12.add(panel_24);

		JPanel panel_26 = new JPanel();
		panel_12.add(panel_26);

		JPanel panel_14 = new JPanel();
		panel_14.setPreferredSize(new Dimension(300, 70));
		panel_10.add(panel_14, BorderLayout.EAST);
		panel_14.setLayout(new BorderLayout(5, 5));

		JPanel panel_28 = new JPanel();
		panel_28.setPreferredSize(new Dimension(300, 70));
		panel_28.setBorder(new TitledBorder(null, "\u63CF\u8FF0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.add(panel_28, BorderLayout.NORTH);
		panel_28.setLayout(new BoxLayout(panel_28, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_7 = new JLabel(
				"\u60AC\u505C\u4F60\u7684\u9F20\u6807\u6307\u9488\u5230\u7EC4\u4EF6\u4E4B\u4E0A\uFF0C\u4FBF\u53EF\u89C1\u5230\u4ED6\u7684\u63CF");
		panel_28.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u8FF0\u3002");
		panel_28.add(lblNewLabel_8);

		JPanel panel_27 = new JPanel();
		panel_10.add(panel_27, BorderLayout.CENTER);

		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_11.getLayout();
		flowLayout_3.setHgap(12);
		panel_3.add(panel_11, BorderLayout.EAST);
	}
}
