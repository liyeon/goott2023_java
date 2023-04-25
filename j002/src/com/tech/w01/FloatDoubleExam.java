package com.tech.w01;

public class FloatDoubleExam {

	public static void main(String[] args) {
		
		double var1=3.14d;
		float var2=3.14f;
		//double은 d를 생략가능 float 는 f를 생략 불가능
		double var3=0.123456789123456789;
		float var4=0.123456789123456789f;
		System.out.println(var1);
		System.out.println(var2);
		System.out.println("double : "+var3);
		System.out.println("float : "+var4);
		
		//승수 표현
		double var5=3e6;//3*10의6승
		float var6= 3e6f;
		double var7=2e-3;//2*10의3승분의1
		
		System.out.println(var5);
		System.out.println(var6);
		System.out.println(var7);
		
		
		//기본형 타입
		
		byte b = 1;
		char a ='a';
		short s = 2;
		int i = 4;
		long l = 8;
		
		float f = 4f;//부동 소수점
		double d = 8;
		boolean boole =true;//1
	}//
}//