package com.wangle.Net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		//serversocket/socket
		
		// serversocket:��ȡsocket�������������ӷ�������socket����
		// socket���Լ�������socket�����Ǿ��ǿͻ��ˡ�
		
		
//		socket----------------------------------------->socket
		
//		�ͻ���socket��������ip�Ͷ˿ڣ�--------------------------->�����serversocket����ȡsocket����
//		����socket�ֱ����in��out��
//		ServerSocket serversocket = new ServerSocket(8989);//���ط��ʺ���������
//		ServerSocket serversocket = new ServerSocket(8989,0,InetAddress.getByName("192.168.1.2"));//��������
		ServerSocket serversocket = new ServerSocket(8989,0,InetAddress.getByName("127.0.0.1"));//���ط���
		Socket socket = serversocket.accept();
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		byte[] b = new byte[1024];
		input.read(b);
		System.out.println(new String(b));
		
		output.write("��ÿͻ���".getBytes());
		output.close();
		input.close();
		
	}

}
