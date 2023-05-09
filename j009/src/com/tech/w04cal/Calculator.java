package com.tech.w04cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	public static void main(String[] args) {
		new Calculator();
	}// main

	public Calculator() {
		setTitle("계산기잉");
		setSize(600, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// panel 준비
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(0,50));
		p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		p1.setLayout(new GridLayout(1,2,30,10));
		
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		// row col hgap가로 vgap세로
		p2.setLayout(new GridLayout(5, 5, 5, 5));
		
		// panel 색상 변경
		p1.setBackground(Color.decode("#cbe86b"));
		p2.setBackground(Color.decode("#ffda8e"));

		// textField 준비
		JTextField num1 = new JTextField(15);
		JTextField num2 = new JTextField(15);
		num1.setSize(100,50);
		p1.add(num1);
		p1.add(num2);

		// 
		p2.add(new JButton("backspace"));
		p2.add(new JButton(""));
		p2.add(new JButton(""));
		p2.add(new JButton("CE"));
		p2.add(new JButton("C"));
		p2.add(new JButton("7"));
		p2.add(new JButton("8"));
		p2.add(new JButton("9"));
		p2.add(new JButton("sqrt"));
		p2.add(new JButton("/"));
		p2.add(new JButton("4"));
		p2.add(new JButton("5"));
		p2.add(new JButton("6"));
		p2.add(new JButton("X"));
		p2.add(new JButton("%"));
		p2.add(new JButton("1"));
		p2.add(new JButton("2"));
		p2.add(new JButton("3"));
		p2.add(new JButton("-"));
		p2.add(new JButton("1/x"));
		p2.add(new JButton("0"));
		p2.add(new JButton("+/-"));
		p2.add(new JButton("."));
		p2.add(new JButton("+/"));
		p2.add(new JButton("="));
		
		
		// panel을 프레임에 부착
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		setVisible(true);
	}// constructor
}// class