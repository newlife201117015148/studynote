package com.wangle.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test07 {
	//UDP数据报文传输协议：只管发送数据，不管服务器是否接收得到。
//	中国的网络国情：电信是独立IP，联通是局域网IP，联通只承认两两承认的网络传输，如果外来IP想访问是不可以的。
//	所以利用中转站可以解决这个问题。
//	用到的类：datagramSocket和datagrampacket
	
	public static void main(String[] args){
		
		
		DatagramSocket datagramSocket = null;
		try {
			datagramSocket = new DatagramSocket();
			while(true){
				
				byte[] b = "你好服务器".getBytes();
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
