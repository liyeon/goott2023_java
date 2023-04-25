package com.tech.w02;

public class CastingExam {
	public static void main(String[] args) {
		//형변환 casting
		int intValue=165;
		char charValue=(char) intValue;//강제 형변환, 명시적 형변환
		System.out.println(charValue);
		System.out.println(intValue);
		//byte < char < short < int < long<float>double
		
		char charValue2='a';
		System.out.println(charValue2);
		int intValue2=charValue2;//자동 형변환 (묵시적 형변환) 작은사이즈->큰사이즈에 넣기
		
		System.out.println(charValue2);
		System.out.println(intValue2);
	}
}