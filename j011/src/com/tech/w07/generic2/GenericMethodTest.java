package com.tech.w07.generic2;

class GenericMethod{
	public static <T> T getLast(T[] a){
		return a[a.length-1]; // return type T
	}
}
public class GenericMethodTest {
	public static void main(String[] args) {
		String[] language = new String[3];
		language[0]="C#";
		language[1]="C++";
		language[2]="JAVA";
		
		String last = GenericMethod.getLast(language);
		System.out.println(last);
	}//main
}//class