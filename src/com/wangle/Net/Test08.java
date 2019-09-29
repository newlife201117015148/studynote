package com.wangle.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test08 {

	public static void main(String[] args){

		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket(8989);
			byte[] b = new byte[1024];
			while(true){
//			这是一个空包，用于放接收的数据，这个包如果装不下会溢出，丢掉一部分数据。这个一个包只能接一次数据，如果再来数据需再new一个包.
			DatagramPacket packet = new DatagramPacket(b, b.length);
			socket.receive(packet);
			byte[] b2 = "你好客户端".getBytes();
			DatagramPacket packet2 = new DatagramPacket(
					b2,
					b2.length,
					packet.getSocketAddress());
			socket.send(packet2);
			String str = new String(packet.getData(),0,packet.getLength());
			
			System.out.println(str);
			System.out.println(packet.getAddress()+"--"+packet.getSocketAddress()+"-----"+packet.getPort());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			socket.close(); 
		}
		
		
	}

}
