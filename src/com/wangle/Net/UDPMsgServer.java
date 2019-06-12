package com.wangle.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UDPMsgServer extends Thread {
	private DatagramPacket packet;

	public UDPMsgServer(DatagramPacket packet) {
		this.packet = packet;
	}
	private static DatagramSocket socket = null;
	private static void openServer() throws IOException {
		socket = new DatagramSocket(8989);
		ExecutorService pool = Executors.newFixedThreadPool(100);
		while (true) {
			byte[] p = new byte[1024 * 5];

			DatagramPacket packet = new DatagramPacket(p, p.length);

			socket.receive(packet);

			pool.execute(new UDPMsgServer(packet));
		}

	}

	// ip,port
	private static  HashSet<String> address = new HashSet();

	public void run() {
		String str = new String(packet.getData(), 0, packet.getLength());
		if (str.startsWith("userreg")) {
			address.add(packet.getAddress().getHostAddress() + "," + packet.getPort());
		} else {
			for (String string : address) {
				try {
					String ip = string.split(",")[0];
					int port = Integer.parseInt(string.split(",")[1]);
					DatagramPacket packet1 = new DatagramPacket(packet.getData(), packet.getLength(),
							InetAddress.getByName(ip), port);
					
						socket.send(packet1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void main(String[] args) {
		try {
			openServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
