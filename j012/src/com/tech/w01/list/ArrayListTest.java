package com.tech.w01.list;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		// 사이즈를 미리 정하지 않는다.
		list.add("Milk1");
		list.add("Milk2");
		list.add("Butter");
		list.add("Apple");
		list.add("Grape");
		list.add("Bread");

		for (String val : list)
			System.out.println(val);

		System.out.println("=========================");

		// 삭제 by index
		list.remove(2);
		for (String val : list)
			System.out.println(val);

		System.out.println("=========================");

		// 삭제 by value
		list.remove("Apple");
		for (String val : list)
			System.out.println(val);

		System.out.println("=========================");
		// 추가
		list.add("Apple");

		// 위치 지정 추가
		list.add(1, "Bread2");
		for (String val : list)
			System.out.println(val);

		System.out.println("=========================");
		System.out.println("길이 출력 : size : " + list.size());
		System.out.println("인덱스 번호로 검색 : " + list.get(1) );
		System.out.println("Milk2 의 인덱스 넘버 :  "+ list.indexOf("Milk2"));
	}// main
}// class