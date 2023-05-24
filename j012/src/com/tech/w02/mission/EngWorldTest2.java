package com.tech.w02.mission;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EngWorldTest2 {
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

		do {
			System.out.print("검색할 단어를 입력해주세요!>>");
			String key = s.next();

			if (key.equals("q")) {
				System.out.println("종료합니다.");
				break;
			} else if (words.get(key) == null) {
				System.out.println("Please enter again");
			} else {
				System.out.println(key + "의 뜻은 " + words.get(key) + "입니다.");
			}
		} while (true);
	}// main
}// class