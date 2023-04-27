package com.tech.w03;

public class NullPointExamTest {
	public static void main(String[] args) {
		NullPointExam nExample = new NullPointExam();
		
		nExample.getData(1000);
		//메모리에서 제거된다. 
		nExample=null;
		System.out.println("\n 해시코드 : "+nExample);
		//생성된 데이터를 끊었기 때문에 java.lang.NullPointerException
		nExample.getData(1000);
		System.out.println("\n 해시코드 : "+nExample);
	}//main
}//class