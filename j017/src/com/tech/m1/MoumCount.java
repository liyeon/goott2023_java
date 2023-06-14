package com.tech.m1;

import java.util.Scanner;

public class MoumCount {
	public static void main(String[] args) {
		int count=0;
		boolean flag=true;
		Scanner s = new Scanner(System.in);

		while (flag) {
			count=0;
			System.out.print("영어 단어를 입력해주세요!!>>");
			String str = s.next();
			str.toLowerCase();
			for (int i = 0; i < str.length(); i++) {
				System.out.println(str.charAt(i));
				switch (str.charAt(i)) {
			    case 'a':count++; break;
			    case 'e':count++;break;
			    case 'i':count++;break;
			    case 'o':count++;break;
			    case 'u':count++;break;
			    case '0': System.out.println("프로그램 종료");flag=false; break;
				}
			}//for
			System.out.println("총 글자 수 : "+str.length());
			System.out.println("모음 수 : "+count);
		} // while
	}//main
}//class