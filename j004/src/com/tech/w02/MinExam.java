package com.tech.w02;

public class MinExam {

	public static void main(String[] args) {
		//배열에 최소값 구하기
		
		int[] arr = {80,40,70,20,30};
		//최소값 검사
		int min =101;//배열 안의 최고 점수가 100 이라 할 때
		for (int i = 0; i < arr.length; i++) {
			if (min>arr[i]) {
				min=arr[i];//작을 때 바꿔주기
				
			}
		}//반복문 종료
		System.out.println("최소값"+min);
	}//main 종료

}//class