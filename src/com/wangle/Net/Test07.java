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
						InetAddress.getByName("192.168.1.2"),
						8989);
				
				datagramSocket.send(packet);
			}
		} catch (Exception e) {
		}finally{
			datagramSocket.close();
		}
	}

}
