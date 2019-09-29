package com.wangle.javaIO;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{

	protected MyObjectOutputStream() throws IOException, SecurityException {
		super();
	}

	private static File f;
	
}
