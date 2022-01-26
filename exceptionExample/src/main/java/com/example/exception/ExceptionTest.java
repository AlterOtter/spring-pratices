package com.example.exception;

public class ExceptionTest {

	
	public static void main(String[] args) {
		int a=10;
		int b=10-a;
		
		System.out.println("Some Code...");
		try {
			int result=(1+2+3)/b;
		} catch (ArithmeticException e) {
			/* 예외 처리 */
			// 1. 사과
			System.out.println("죄송합니다");
			// 2. 로깅
			System.out.println("error : "+e);
			// 3. 정상종료
			return;
		}finally {
			/* 자원정리 */
			System.out.println("자원정리");
		}
		
		
	}
}
