package com.tech.w01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class ListBoard {
	HashMap<String, Object> data = new HashMap<String, Object>();
	Scanner sc = new Scanner(System.in);
	ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

	public static void main(String[] args) {
		ListBoard bd = new ListBoard();
		bd.setBoard();
	}// main

	public void setBoard() {
		int number = 1;
		while (true) {
			System.out.println("=================================");
			System.out.println("NO\t제목\t작성자\t작성일");
			System.out.println("--------------------------------");
			// 내용 출력
			for (int i = list.size() - 1; i >= 0; i--) {
				System.out.print(list.get(i).get("번호"));
				System.out.print("\t" + list.get(i).get("제목"));
				System.out.print("\t" + list.get(i).get("작성자"));
				System.out.print("\t" + list.get(i).get("작성일"));
				System.out.println();
				System.out.println("---------------------------------------------------------");
			} // for
			System.out.println("1. 조회 \t 2. 등록 \t0. 종료");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("조회할 게시글 번호");
				int input1 = sc.nextInt();
				listData(input1);
				break;
			case 2:
				putData(number);
				number++;
				list.add(data);
				System.out.println("작성하신글이 등록됐습니다.");
				break;
			case 0:
				System.out.println("종료합니다. ");
				System.exit(0);
				break;
			default:
				break;
			}// switch case
		} // while
	}// method

	public void putData(int number) {
		// 글작성
		data = new HashMap<String, Object>();
		data.put("번호", number);
		System.out.print("제목 : ");
		data.put("제목", sc.next());
		System.out.print("내용 : ");
		data.put("내용", sc.next());
		System.out.print("작성자 : ");
		data.put("작성자", sc.next());

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		data.put("작성일", format.format(date));

	}// method

	public void listData(int input1) {
		for (int i = 0; i < list.size(); i++) {
			if ((int) list.get(i).get("번호") == input1) {
				System.out.println("제목 : " + list.get(i).get("제목"));
				System.out.println("작성자 : " + list.get(i).get("작성자"));
				System.out.println("작성일 : " + list.get(i).get("작성일"));
				System.out.println("내용 : " + list.get(i).get("내용"));
				System.out.println("==================");
				setDetail(input1);
				return;
			} // if
		} // for
	}// method

	public void setDetail(int input1) {
		while (true) {
			System.out.println("1. 수정 \t 2. 삭제 \t 3. 목록");
			int input = sc.nextInt();
			switch (input) {
			case 1:// 수정
				modifyData(input1);
				break;
			case 2:// 삭제
				deleteData(input1);
				return;
			case 3:// 목록
				return;
			default:
				break;
			}// switch
		} // while
	}// method

	public void deleteData(int input1) {
		System.out.println("글을 삭제합니다.");
		for (int i = 0; i < list.size(); i++) {
			if ((int) list.get(i).get("번호") == input1) {// 입력된 번호와 일치
				list.remove(i);
			} // if
		} // for
	}// method

	public void modifyData(int input1) {
		System.out.println("글을 수정 합니다.");
		for (int i = 0; i < list.size(); i++) {
			if ((int) list.get(i).get("번호") == input1) {// 입력된 번호와 일치
				System.out.print("제목 : ");
				list.get(i).put("제목", sc.next());
				System.out.print("내용 : ");
				list.get(i).put("내용", sc.next());
				System.out.print("작성자 : ");
				list.get(i).put("작성자", sc.next());
			} // if
		} // for
	}// method
}// class