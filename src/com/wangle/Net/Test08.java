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
//			����һ���հ������ڷŽ��յ����ݣ���������װ���»����������һ�������ݡ����һ����ֻ�ܽ�һ�����ݣ����������������newһ����.
			DatagramPacket packet = new DatagramPacket(b, b.length);
			socket.receive(packet);
			byte[] b2 = "��ÿͻ���".getBytes();
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
