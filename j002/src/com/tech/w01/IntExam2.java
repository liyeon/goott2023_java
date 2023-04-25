package com.tech.w01;

public class IntExam2 {
	public static void main(String[] args) {
		//증감연산자
		int a =10;
		int b=5;
		System.out.println("a : "+a);
		System.out.println("b : "+b);
//		a=a+a;
//		System.out.println("a : "+a);
		
//		a=a+(++a); 전이연산
		a=a+(a++);//후이연산 a= a+1
		System.out.println(a);
		
		b=++b;
		System.out.println("b : "+b);
		
		b=b++;//결과를 보내고 증가
		System.out.println("b : "+b);
		System.out.println("b2 : "+(b++));//출력을 하고 증가됨
		System.out.println("b : "+b);
		
		//타입의 종류 
	}//main
}//class