package com.example.exception;

import java.io.IOException;

public class MyClassTest {
	public static void main(String[] args) {
		try {
			new MyClass().danger();
		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("exit");
	}
	
}
