package com.tech.w04;

import java.util.ArrayList;

public class ArrayListMission {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("길동1");
		list.add("길동2");
		list.add("길동1");
		list.add("길동3");
		list.add("길동1");
		list.add("길동1");
		list.add("길동4");
		list.add("길동1");

		// remove value
//		list.remove("길동4");
		// 길동4을 인덱스로 지우기
//		list.remove(list.indexOf("길동4"));

		
//		while (list.indexOf("길동1") != -1) {
//			list.remove(list.indexOf("길동1"));
//		}
		//람다식 -> 을 말함
		list.removeIf(a -> a.equals("길동1"));
//		list.removeAll(Arrays.asList("길동1"));
		
		for (String ele : list) {
			System.out.println(ele + " ");
		} // for
	}// main
}// class