package com.tech.w01.list;

import java.util.HashSet;
import java.util.Set;

public class FindSetTest2 {
	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		// 어떤 데이터가 중복되는지 출력
		String[] sample = { "Butter", "Apple", "Orange", "Butter","Apple","Apple","Apple" };
		System.out.println(s);

		// sample의 데이터를 -> s 에 데이터 추가
		for (String ele : sample) {
			// 데이터가 중복되면 코드로 변형
			//중복되어있으면 
			if (!s.add(ele)) { // 기존의 데이터가 있는지 없는지를 판별
				System.out.println("중복 데이터 : "+ele);
			} // if
		} // for
		System.out.println(s);
	}// main
}// class