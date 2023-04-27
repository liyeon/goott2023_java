package com.tech.mission;

public class ArrayScoreByNameSum {
	public static void main(String[] args) {
		/*
		 * 학생 3명의 국어, 영어 성적 2차원 배열 국어 영어 성적 사용자로 입력받기 학생별 국어, 영어 성적 합 각각 출력
		 */

		int[][] score = { { 100, 80 }, { 50, 43 }, { 63, 80 } };
		// 과목별 총점
		int korTotal = 0, engTotal = 0;

		System.out.println("이름\t국어\t영어\t합계\t평균");
		System.out.println("======================================");

		for (int i = 0; i < score.length; i++) {
			int sum = 0;// 개인별 총점
			double avg = 0.0;// 개인별 평균

			korTotal += score[i][0];
			engTotal += score[i][1];

			System.out.print("학생" + (i + 1) + " :");

			for (int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d  ", score[i][j]);
			} // for j
			avg = sum / (double) score[i].length;
			System.out.printf("%5d %5.1f%n", sum, avg);
		} // for
	}// main
}// class