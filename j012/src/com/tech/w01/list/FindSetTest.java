package com.tech.w01.list;

import java.util.HashSet;
import java.util.Set;

public class FindSetTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		//중복이 허용되지 않음
		String[] sample = { "Butter", "Apple", "Orange", "Butter" };
		System.out.println(s);

		// sample의 데이터를 -> s 에 데이터 추가
		for (String ele : sample) {
			s.add(ele);
			System.out.println(ele);
		}
		System.out.println(s);
	}// main
}// class