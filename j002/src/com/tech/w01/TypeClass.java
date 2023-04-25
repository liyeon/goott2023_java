package com.tech.w01;

public class TypeClass {

	public static void main(String[] args) {
		//사용자타입 & 참조형 타입
		String var1 = "가";//문자열
		var1="나";
		char c = 'a';
		
		int var2 = 200;
		
		//전기적 신호가 통하냐 통하지않느냐
		boolean flag = true;//1
		boolean onOff = false;//0 0이 아닌 다른 숫자를 true 로 인식한다.
		
		System.out.println(var1);
		System.out.println(c);
		System.out.println(var2);
		System.out.println(flag);
		System.out.println(onOff);
	}

}