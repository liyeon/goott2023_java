package com.tech.w01.list;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// Arraylist는 연결고리로 이루어져있지 않지만
		// LinkedList 는 요소요소가 연결고리로 이루어져있다.
		// 추가 삭제를 많이하는 상황에서는 LinkedList가 Arraylist보다 유리하다.
		// 추가삭제가 이루어져있지않는 데이터를 사용한다면 arraylist가 유리하다.
		// 링크드는 뒤쪽 인덱스가 변화가 없다.
		// 중복 데이터를 허용한다.
		LinkedList<String> list = new LinkedList<String>();
		list.add("리1");
		list.add("리2");
		list.add("리3");
		list.add("리4");
		list.add("리5");

		// 데이터 추가 위치 지정
		list.add(2, "추가홍홍ㅎ");
		list.add(2, "추가홍홍ㅎ");
		list.add(2, "추가홍홍ㅎ");
		list.add(2, "추가홍홍ㅎ");
		list.add(2, "추가홍홍ㅎ");
		list.add(3, "추가홍홍ㅎ");

		// 데이터 삭제 인덱스로
//		list.remove(3);

		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("=======================");
		// 모든 요소 삭제
		list.clear();

		for (String str : list) {
			System.out.println(str);
		}
	}// main
}// class