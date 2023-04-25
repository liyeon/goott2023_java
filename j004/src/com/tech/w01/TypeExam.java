package com.tech.w01;

import java.util.ArrayList;

public class TypeExam {

	public static void main(String[] args) {
		String str = "ABC";//String 타입
		Integer i =123;// Integer 타입
		ArrayList<String> list = new ArrayList<>();//ArrayList 타입
		
		
		System.out.println("TYPE : "+str.getClass().getName());
		System.out.println("TYPE : "+i.getClass().getName());
		System.out.println("TYPE : "+list.getClass().getName());
	}//main
}//class