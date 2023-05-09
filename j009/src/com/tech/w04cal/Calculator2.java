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

public class Calculator2 extends JFrame {
	private JButton[] buttons;
	private String[] labels = { 
			"Backspace", "", "", "CE", "C", 
			"7", "8", "9", "/", "sqrt", 
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x", 
			"0", "+/-", ".", "+", "=" 
			};
	public static void main(String[] args) {
		new Calculator2();
	}// main

	public Calculator2() {
		setTitle("계산기잉");
		setSize(600, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// panel 준비
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(0,50));
		p1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		p1.setLayout(new GridLayout(1,2,10,10));
		
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		p2.setLayout(new GridLayout(5, 5, 5, 5));
		
		// panel 색상 변경
		p1.setBackground(Color.decode("#655DBB"));
		p2.setBackground(Color.decode("#ECF2FF"));

		// textField 준비
		JTextField num1 = new JTextField(15);
		JTextField num2 = new JTextField(15);
		num1.setBackground(Color.decode("#ECF2FF"));
		num1.setBorder(null);
		num1.setHorizontalAlignment(JTextField.CENTER);
		num2.setHorizontalAlignment(JTextField.CENTER);
		num2.setBackground(Color.decode("#ECF2FF"));
		num2.setBorder(null);
		p1.add(num1);
		p1.add(num2);
		
		buttons = new JButton[25];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(labels[i]); 
			buttons[i].setBackground(Color.decode("#BFACE2"));
			buttons[i].setBorder(null);
			
			p2.add(buttons[i]);
		} // for
		
		// panel을 프레임에 부착
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		setVisible(true);
	}// constructor
}// class