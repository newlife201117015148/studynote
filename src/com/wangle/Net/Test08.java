package com.wangle.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

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
