package com.tech.w01;

public class ByteExam {

	public static void main(String[] args) {
		byte var1 = -128+(1);
//		var1 =10;
		byte var2 = -30;
		byte var3 = 0;
		//강제형변환
		byte var4 = (byte)100000;
//		byte var4 = 128;  byte 값보다 많기 때문에 오류
		
		
		System.out.println("var1 : "+var1);
		System.out.println("var2 : "+var2);
		System.out.println("var3 : "+var3);
		System.out.println("var4 : "+var4);
		
	}//main 종료
	
	
	//타입 변수 대입연산자(=) value값
	// 한줄
	/*여러줄*/
	
	/*
	 * 우측에 있는 데이터(value 값)을 좌측에 있는 변수에 대입
	 * ==기본형 타입==
	 * 
	 * 정수형 타입 
	 * byte : 1 byte = 8bit (11111111(2)) -128~+127까지 담을 수 있음 
	 * char : 2byte
	 * short : 2 byte
	 * int : 4 byte
	 * long : 8 byte
	 * 
	 * 
	 * 실수형 타입 
	 * float : 4 byte
	 * double : 8 byte
	 * 
	 * 논리형 타입
	 * boolean : 1 byte (true&false)
	 */
}//