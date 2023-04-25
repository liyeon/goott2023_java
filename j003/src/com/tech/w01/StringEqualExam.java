package com.tech.w01;

public class StringEqualExam {
	public static void main(String[] args) {
		String strVar1="홍길동";
		String strVar2="홍길동";
		
		//객체 생성
		String strVar3=new String("홍길동");
		
		System.out.println(strVar1);
		System.out.println(strVar2);
		System.out.println(strVar3);
		
		// 비교
		System.out.println(strVar1==strVar2);
		System.out.println(strVar2==strVar3);//String 객체를 생성 했기 때문에 false
		
		//equal 함수 제공 
		//문자열은 equals 를 비교문으로 사용한다.
		System.out.println(strVar1.equals(strVar3));
		System.out.println(strVar2.equals(strVar3));
	}

}