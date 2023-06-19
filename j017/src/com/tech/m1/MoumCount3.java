package com.tech.m1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoumCount3 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("영어 단어를 입력해주세요!!>>");
		String str = s.nextLine();
		int cnt = 0;
		// 정규식 사용
		Pattern pattern = Pattern.compile("[aeiouAEIOU]+");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println(matcher.group());
			cnt++;
		}
		System.out.println("모음 갯수 : " + cnt);
	}// main
}// class