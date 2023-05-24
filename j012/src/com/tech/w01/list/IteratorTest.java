package com.tech.w01.list;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		// 반복자
		// ArrayList 에서 원소에 접근하여 요소를 가져오는 역할
		ArrayList<String> list = new ArrayList<String>();
		list.add("하나1");
		list.add("하나2");
		list.add("하나3");
		list.add("하나4");
		list.add("하나5");
		list.add("하나6");

		String s;
		// 반복자
		Iterator e = list.iterator(); // 리스트에 반복자를 구성한다.

		while (e.hasNext()) {
			s = (String) e.next();// object로 들어와서 String 으로 형변환
			System.out.println(s);
		}

		System.out.println("===================");
		for (String ele : list) {
			System.out.println(ele);
		}
	}// main
}// class