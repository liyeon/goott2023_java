package com.tech.w05wrap;

public class wrapClass {

	public static void main(String[] args) {
		//Wrapper Class
		String str = "10";
		String str2="10.5";
		String str3="true";
		
		byte b = Byte.parseByte(str);
		System.out.println("문자열 byte 값 변환 : "+b);
		
		int i = Integer.parseInt(str);
		System.out.println("문자열 Integer 값 변환 : "+i);
		
		short s = Short.parseShort(str);
		System.out.println("문자열 short 값 변환 : "+s);
		
		long l = Long.parseLong(str);
		System.out.println("문자열 Long 값 변환 : "+l);
		
		float f = Float.parseFloat(str2);
		System.out.println("문자열 float 값 변환 : "+f);
		
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println("문자열 boolean 값 변환 : "+bool);
	}//main
}//class