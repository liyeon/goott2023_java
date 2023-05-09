package com.tech.w03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutExam2 extends JFrame {
	public static void main(String[] args) {
		new BorderLayoutExam2();// 생성자 호출
	}// main

	public BorderLayoutExam2() {
		System.out.println("초기화 작업 프레임 만들기");
		setTitle("보더레이아웃");
		setSize(500, 500);
		setLocationRelativeTo(null);// 가운데로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());// 배치 ( 배치한다 ) 관리자를 보더레이아웃으로 사용한다.

		//버튼 생성과 동시에 컴포넌트에 배치
		add(new JButton("호출1"), BorderLayout.NORTH);
		add(new JButton("호출2"), BorderLayout.SOUTH);
		add(new JButton("호출3"), BorderLayout.WEST);
		add(new JButton("호출4"), BorderLayout.EAST);
		add(new JButton("호출5"), BorderLayout.CENTER);
		
		setVisible(true);

	}//
}// class