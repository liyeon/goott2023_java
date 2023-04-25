package com.tech.w02;

public class UnicodeExam {

	public static void main(String[] args) {
		//유니코드의 이해
		char char1='가';
		char uni1='\uac00';//가의 uni 코드 값
		System.out.println(char1);
		System.out.println(uni1);
		
	char uni2='\uae40';
	char uni3='\uB9AC';
	char uni4='\uC5F0';
	System.out.println(uni2+""+uni3+""+uni4);
	}//

}//