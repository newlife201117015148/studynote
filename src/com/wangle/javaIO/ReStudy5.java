package com.wangle.javaIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReStudy5 {
	
	public static void main(String[] args) throws Exception {
		
		DataOutputStream dataOutoutStream = new DataOutputStream(new FileOutputStream("a.txt"));
		
		dataOutoutStream.writeByte(97);
		dataOutoutStream.writeBoolean(true);
		//	dataOutoutStream.writeBytes("dasdfasdfa");
		dataOutoutStream.writeChar('中');
		dataOutoutStream.writeDouble(23.3);
		dataOutoutStream.writeFloat(3.3f);
		dataOutoutStream.writeInt(23);
		dataOutoutStream.writeLong(23238823l);
		dataOutoutStream.writeShort(23);
		dataOutoutStream.writeUTF("奥斯卡大法师打发");
		
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("a.txt"));
		//按顺序解读，不然会乱码
		System.out.println(dataInputStream.readByte());
		System.out.println(dataInputStream.readBoolean());
		System.out.println(dataInputStream.readChar());
		System.out.println(dataInputStream.readDouble());
		System.out.println(dataInputStream.readFloat());
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readLong());
		System.out.println(dataInputStream.readShort());
		System.out.println(dataInputStream.readUTF());
		
	}
}
