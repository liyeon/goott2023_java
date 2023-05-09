package com.tech.w03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutExam extends JFrame {
	public static void main(String[] args) {
		new BorderLayoutExam();// 생성자 호출
	}// main

	public BorderLayoutExam() {
		System.out.println("초기화 작업 프레임 만들기");
		setTitle("보더레이아웃");
		setSize(500, 500);
		setLocationRelativeTo(null);// 가운데로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());// 배치 ( 배치한다 ) 관리자를 보더레이아웃으로 사용한다.

		// 버튼 생성
		JButton btn1 = new JButton("호출1");// 버튼컴포넌트 생성
		JButton btn2 = new JButton("호출2");// 버튼컴포넌트 생성
		JButton btn3 = new JButton("호출3");// 버튼컴포넌트 생성
		JButton btn4 = new JButton("호출4");// 버튼컴포넌트 생성
		JButton btn5 = new JButton("호출5");// 버튼컴포넌트 생성

		// 컴포넌트 프레임에 부착
		add(btn1, "North");// 약속된 문자 North
		add(btn2, "South");// 약속된 문자 South
		add(btn3, "Center");// 약속된 문자 Center
		add(btn4, "West");// 약속된 문자 West
		add(btn5, "East");// 약속된 문자 East

		setVisible(true);

	}//
}// class