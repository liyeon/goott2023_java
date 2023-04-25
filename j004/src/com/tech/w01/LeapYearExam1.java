package com.tech.w01;

import java.util.Scanner;

public class LeapYearExam1 {

	public static void main(String[] args) {
//		서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다. (1988년, 1992년, 1996년, 2004년, 2008년, 2012년, 2016년, 2020년, 2024년, 2028년, 2032년, 2036년, 2040년, 2044년 ...)
//		서력 기원 연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다. (1700년, 1800년, 1900년, 2100년, 2200년, 2300년...)
//		서력 기원 연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년...)

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("연도를 입력하세요!");
			System.out.print("입력>");
			int yearNum = s.nextInt();
			if (yearNum % 4 == 0 || yearNum % 100 == 0 || yearNum % 400 == 0) {
				System.out.println(yearNum + "년은 윤년입니다.");
			} else {
				System.out.println(yearNum + "년은 평년입니다.");
			}//if
		}//while
	}// main 종료
}// class 종료