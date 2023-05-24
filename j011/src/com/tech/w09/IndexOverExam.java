package com.tech.w09;

public class IndexOverExam {
	// 예외 처리
	public static void main(String[] args) {
		// 예외 사항
		// 사용자의 입력 오류 : 사용자가 숫자를 문자로 잘못 입력한 경우
		// 장치 오류 : 네트워크 고장, 디스크 고장
		// 코드 오류 : 입력 코드 오류, 배열의 인덱스 번호
		int[] array = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i]=i+1;
		}//for
		try {
			System.out.println(array[229]);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("예외 발생");
		}
	}// main
}// class