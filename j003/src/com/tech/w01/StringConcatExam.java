package com.tech.w01;

public class StringConcatExam {

	public static void main(String[] args) {
		String str1="JDK"+6.0;
		String str2=str1+"특징";
		
		System.out.println(str2);
		System.out.println();
		
		String str3="jdk"+3+3+3+3.0;
		//우선순위의 방향성
		String str4=3+3+3.0+"jdk";//숫자가 먼저 써졌기때문에 먼저 +
		System.out.println(str3);
		System.out.println(str4);
		
		String str5 = str1.concat(str4);//str1과 str4를 더한다.
		System.out.println(str5);
	}
}
