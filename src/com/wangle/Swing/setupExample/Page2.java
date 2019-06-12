package com.wangle.Swing.setupExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page2 extends JPanel {
	private MyFrame myFrame;

	public void setFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public Page2() throws Exception {
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_18.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_18, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		panel_18.add(panel_1);

		JButton btnNewButton_2 = new JButton("< \u4E0A\u4E00\u6B65(P)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(1);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(btnNewButton_2);

		JButton btni = new JButton("\u6211\u63A5\u53D7(I)");
		btni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.set(3);
			}
		});
		btni.setMargin(new Insets(2, 8, 2, 8));
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
		panel.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel_21.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));

		JSeparator separator = new JSeparator();
		panel_16.add(separator);

		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_19.getLayout();
		flowLayout_5.setVgap(8);
		panel_16.add(panel_19, BorderLayout.NORTH);

		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_20.getLayout();
		panel_16.add(panel_20, BorderLayout.EAST);

		JPanel panel_17 = new JPanel();
		panel_21.add(panel_17, BorderLayout.WEST);
		panel_17.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

		JLabel lblNewLabel_6 = new JLabel(" Universal Database Manager ");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 12));
		panel_17.add(lblNewLabel_6);

		JPanel panel_15 = new JPanel();
		panel.add(panel_15, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		this.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7, BorderLayout.WEST);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_2 = new JLabel("  \u8BB8\u53EF\u8BC1\u534F\u8BAE");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 13));
		panel_7.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				"    \u5728\u5B89\u88C5 DBeaver Community \u4E4B\u524D\uFF0C\u8BF7\u9605\u8BFB\u6388\u6743\u6761\u6B3E\u3002");
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
		panel_2.add(panel_13, BorderLayout.NORTH);

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
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(13);
		panel_5.add(panel_6, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(
				"\u68C0\u9605\u534F\u8BAE\u7684\u5176\u4F59\u90E8\u5206\uFF0C\u6309 [PaDn] \u5F80\u4E0B\u5377\u52A8\u9875\u9762\u3002");
		panel_6.add(lblNewLabel);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(null);
		JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
		scrollBar.setValue(scrollBar.getMinimum());
		panel_9.add(scrollPane, BorderLayout.CENTER);

		File file = new File("xieyi.txt");
		FileInputStream inputStream = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		inputStream.read(b);
		JTextArea txtrAsdfasdfa = new JTextArea();
		txtrAsdfasdfa.setForeground(Color.BLACK);
		txtrAsdfasdfa.setFont(new Font("宋体", Font.PLAIN, 12));
		txtrAsdfasdfa.setText(new String(b));
		txtrAsdfasdfa.setEditable(false);
		scrollPane.setViewportView(txtrAsdfasdfa);

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new BorderLayout(5, 5));

		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_4 = new JLabel(
				"\u5982\u679C\u4F60\u63A5\u53D7\u534F\u8BAE\u4E2D\u7684\u6761\u6B3E\uFF0C\u5355\u51FB [\u6211\u540C\u610F(I)] \u7EE7\u7EED\u5B89\u88C5\u3002\u5FC5\u987B\u8981\u63A5\u53D7\u534F\u8BAE\u624D\u80FD\u5B89\u88C5");
		panel_12.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("DBeaver Comminity \u3002");
		panel_12.add(lblNewLabel_5);

		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new BorderLayout(0, 10));

		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_11.getLayout();
		flowLayout_3.setHgap(12);
		panel_3.add(panel_11, BorderLayout.EAST);
	}

}
