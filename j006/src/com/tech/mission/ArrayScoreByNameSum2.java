package com.tech.mission;

import java.util.Scanner;

public class ArrayScoreByNameSum2 {
	public static void main(String[] args) {
		/*
		 * 학생 3명의 국어, 영어 성적 2차원 배열 국어 영어 성적 사용자로 입력받기 학생별 국어, 영어 성적 합 각각 출력
		 */

		Scanner s = new Scanner(System.in);

		int[][] arr = new int[3][2];
		int[] sumby=new int[arr.length];
		String[] names= {"학생 A","학생 B","학생 C" };
		// 과목별 총점

		for (int i = 0; i < arr.length; i++) {
			System.out.print("국어 점수 입력 >>");
			arr[i][0] = s.nextInt();
			System.out.print("영어 점수 입력 >>");
			arr[i][1] = s.nextInt();
			sumby[i]=arr[i][0]+arr[i][1];
		} // for
		
		//sumby
		for (int i = 0; i < sumby.length; i++) {
			System.out.println((i+1)+"번 ("+names[i]+")학생 sum : "+sumby[i]);
		}//
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			} // for
			System.out.println();
		}//
		
	}// main
}// class