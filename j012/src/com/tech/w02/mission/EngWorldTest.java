package com.tech.w02.mission;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EngWorldTest {
	public static void main(String[] args) {
		Map<String, String> words = new HashMap<>();

		words.put("apple", "사과");
		words.put("pill", "알약");
		words.put("life", "삶");
		words.put("price", "값, 가격");
		words.put("row", "줄, 열");
		words.put("math", "수학");
		words.put("source", "출처, 근원");
		words.put("machine", "기계");
		words.put("bowl", "사발, 그릇");

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print("검색할 단어를 입력해주세요!>>");
			String str = s.next();

			if (words.containsKey(str)) {
				System.out.println(str + "의 뜻은 " + words.get(str) + "입니다.");
			}else if(str.equals("z")){
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("Please enter again");
				continue;
			} // if
		} // while
	}// main
}// class