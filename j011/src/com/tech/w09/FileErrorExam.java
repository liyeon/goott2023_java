package com.tech.w09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileErrorExam {
	private int[] list;
	private static final int SIZE = 10;

	public FileErrorExam() {
		list = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			list[i] = i;
		} // for
		writeList();
	}// constructor

	private void writeList() {
		// 입출력 도구
		PrintWriter out = null;// 출력도구
		BufferedReader in = null;// 입력도구

		try {
			in = new BufferedReader(new FileReader("infile.txt"));// 파일이 없을 수 있음
			for (int i = 0; i < SIZE; i++) {
				list[i] = i;
//				list[11] = 10;
			} // for
			System.out.println("정상작동");
		} catch (FileNotFoundException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		} finally {
			//무조건 최종적으로 동작함
			//소켓통신 채팅프로그램에서 자주 사용함
			System.out.println("finally block end");
		} // try~catch~finally
	}// method

	public static void main(String[] args) {
		new FileErrorExam();
	}// main
}// class