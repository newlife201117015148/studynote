package com.wangle.Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		
		
		System.out.println(InetAddress.getByName("192.168.0.01"));
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
	}

}
