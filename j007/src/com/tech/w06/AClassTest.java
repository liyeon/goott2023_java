package com.tech.w06;

public class AClassTest extends AClass{
	public static void main(String[] args) {
//		AClass a = new AClass();
		AClassTest a = new AClassTest();
		
//		System.out.println(a.i); private이라 불가능함 같은 클래스에서만
		System.out.println(a.k);//default 같은 클래스, 같은 패키지
		System.out.println(a.p);//public 어디에서나
		System.out.println(a.p3);//protected 같은 클래스, 같은 패키지, 자식클래스
	}//main
}//class