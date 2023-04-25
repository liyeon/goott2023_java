package com.tech.w02;

import java.util.Scanner;

public class SearchExam {

	public static void main(String[] args) {
		int[] s = {0,10,20,30,40,50,60,70,80,90,100};
		//데이터 위치값 찾아가기 
		Scanner scan = new Scanner(System.in);
		int value, index = -1;//없는 숫자로 초기화 
		System.out.print("탐색할 값을 입력하세요 : ");
		
		value=scan.nextInt();//값 입력받기 
		System.out.println(value);
		
		for (int i = 0; i < s.length; i++) {
			if(s[i]==value) {
				index = i;
				break;
			}//조건문
		}//반복문
		System.out.println(value +"값은 "+index+"번째에 위치합니다.");
		scan.close();
	}//main

}//clas