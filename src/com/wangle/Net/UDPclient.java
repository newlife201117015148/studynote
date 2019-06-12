package com.wangle.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JTextArea;

public class UDPclient extends Thread{
	private  DatagramSocket socket ;
	private  JTextArea textArea;
	public UDPclient(JTextArea textArea) throws Exception {
		socket = new DatagramSocket();
		this.textArea = textArea;
	}

	public  void reguser(String ip,int port) throws Exception {
		send(ip,port,"userreg");
		javax.swing.JOptionPane.showMessageDialog(null, "注册成功");
		if(this.getState()==State.NEW){
			this.start();
			javax.swing.JOptionPane.showMessageDialog(null, "聊天开始");
		}
	}
	
	public  void send(String ip,int port,String msg) throws Exception {
		byte[] data = msg.getBytes();
		DatagramPacket packet1 = new DatagramPacket(data, data.length, InetAddress.getByName(ip), 
				port);
		socket.send(packet1);
	}
	
	@Override
	public void run() {
		while(true){
		try {
			byte[] p = new byte[1024*3];
			DatagramPacket packet1 = new DatagramPacket(p, p.length);
			socket.receive(packet1);
			String str = new String(packet1.getData(),0,packet1.getLength());
			String text = textArea.getText();
			System.out.println(text);
			textArea.setText(text+"\r\n"+packet1.getAddress().getHostAddress()+":"+str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
}
