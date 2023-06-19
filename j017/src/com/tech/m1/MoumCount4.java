package com.tech.m1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoumCount4 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("영어 단어를 입력해주세요!!>>");
		String str = s.nextLine();
		int cnt = 0;
		int i = 0;
		while (i < str.length()) {
			boolean b = String.valueOf(str.charAt(i)).matches("[aeiouAEIOU]+");
			if(b) {
				cnt++;
			}
			System.out.println(b);
			i++;
		}
		System.out.println("모음 갯수 : " + cnt);
	}// main
}// class