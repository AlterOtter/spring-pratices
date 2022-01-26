package com.example.exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("Some code");
		
		if(5-5==0) {
			throw new MyException();			
		}
		
		if(5-5==0) {
			throw new IOException();			
		}
		
		System.out.println("Some code");
	}
}
