package com.tech.w03;

import javax.swing.JFrame;

public class JoinForm extends JFrame{
	public static void main(String[] args) {
		new JoinForm();
	}
	public JoinForm() {
		setTitle("회원가입");
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}