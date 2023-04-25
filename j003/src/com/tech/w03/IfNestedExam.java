package com.tech.w03;

public class IfNestedExam {

	// 중첩 IF 문
	public static void main(String[] args) {
		int score = (int) (Math.random() * 50) + 50;
		System.out.println(score);

		String grade = "";
		/*
		 * 평점 매기기 A+ 95 A 90 B+ 85 B 80 C+75 C70
		 */

		if (score > 90) {
			if(score>95) {
				grade = "점 [ A+ ]";
			}else {
				grade = "점 [ A ]";
			}
		} else if (score > 80) {
			if (score > 85) {
				grade = "점 [ B+ ]";
			}else {
				grade = "점 [ B ]";
			}
		} else if (score > 70) {
			if (score > 75) {
				grade = "점 [ C+ ]";
			}else {
				grade = "점 [ C ]";
			}
		} else if (score > 60) {
			if (score > 65) {
				grade = "점 [ D+ ]";
			}else {
				grade = "점 [ D ]";
			}
		} else {
			grade = "점 [ F ]";
		}
		System.out.println(score+grade);
	}// main 종료

}// class 종료