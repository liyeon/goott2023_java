package com.tech.w09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FinallyExceptionExam {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;

		BufferedReader br = null;
		BufferedWriter bw = null;

		Date d = null;
		// 파일 내용 카피
		try {
			// 입력 도구
			fr = new FileReader("inSchool.txt");
			br = new BufferedReader(fr);//

			// 출력 도구
			fw = new FileWriter("outSchool.txt", false);
			bw = new BufferedWriter(fw);

			String s = null;
			d = new Date();// 현재시간
			// 파일 카피
			long start = d.getTime();
			System.out.println("현재시간 : " + start);
			// 카피
			while ((s = br.readLine()) != null) {// 파일에서 라인으로 입력받기
				bw.write(s);// bw에 출력
				bw.newLine();// 줄바꿈
			} // while
			d = new Date(); // 종료 시간
			long end = d.getTime();
			// 400 = 0.4 초
			System.out.println("토탈 복사에 사용한 시간 : " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// br 이라는 객체가 존재한다면
			// 자원 회수
			if (br != null) {try {br.close();} catch (IOException e) {}}//if
			if (fr != null) {try {fr.close();} catch (IOException e) {}}//if
			if (bw != null) {try {bw.close();} catch (IOException e) {}}//if
			if (fw != null) {try {fw.close();} catch (IOException e) {}}//if
		} // try~finally
	}// main
}// class