package com.wangle.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test07 {
	//UDP���ݱ��Ĵ���Э�飺ֻ�ܷ������ݣ����ܷ������Ƿ���յõ���
//	�й���������飺�����Ƕ���IP����ͨ�Ǿ�����IP����ֻͨ�����������ϵ����紫�䣬�������IP������ǲ����Եġ�
//	����������תվ���Խ��������⡣
//	�õ����ࣺdatagramSocket��datagrampacket
	
	public static void main(String[] args){
		
		
		DatagramSocket datagramSocket = null;
		try {
			datagramSocket = new DatagramSocket();
			while(true){
				
				byte[] b = "��÷�����".getBytes();
				DatagramPacket packet = new DatagramPacket(
						b,
						b.length,
						InetAddress.getLocalHost(),
						8989);
				
				datagramSocket.send(packet);
				byte[] b2 = new byte[1024];
				DatagramPacket packet2 = new DatagramPacket(b2, b2.length);
				datagramSocket.receive(packet2);
				System.out.println(new String(packet2.getData(),0,packet2.getLength()));
				System.out.println(packet2.getSocketAddress());
			}
		} catch (Exception e) {
		}finally{
			datagramSocket.close();
		}
	}

}
