package com.tech.w01.list;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();

		s1.add("A");
		s1.add("B");
		s1.add("C");

		s2.add("A");
		s2.add("D");

		System.out.println(s1);
		System.out.println(s2);

		// 합집합
		Set<String> union = new HashSet<String>(s1);
		System.out.println(union);

		union.addAll(s2);

		System.out.println("합집합 : " + union);
		
		//교집합
		Set<String> intersaction= new HashSet<String>(s1);
		intersaction.retainAll(s2);
		System.out.println("교집합 : "+intersaction);
		
		//차집합
		Set<String> dif = new HashSet<String>(s1);
		dif.removeAll(s2);
		System.out.println("차집합 : "+ dif);
	}// main
}// class