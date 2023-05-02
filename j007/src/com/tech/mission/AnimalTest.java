package com.tech.mission;

import java.util.Scanner;

public class AnimalTest {
	public static void main(String[] args) {
		// Animal_김리연

		Scanner s = new Scanner(System.in);
		Dog d = new Dog();
		Cat c = new Cat();
		Elephant e = new Elephant();

		boolean flag = true;

		System.out.println("1(강아지) 2(고양이) 3(코끼리)");
		while (flag) {
			System.out.println("================================");
			System.out.print("검색할 자료 번호를 선택해주세요!>>");
			int num = s.nextInt();

			switch (num) {
			case 1:
				d.dogChar();
				break;
			case 2:
				c.catChar();
				break;
			case 3:
				e.elephantChar();
				break;
			case 0:
				flag = false;
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("자료가 없습니다.");
				break;
			}// switch~case
		} // while
	}// main
}// class