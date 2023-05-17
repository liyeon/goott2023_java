package com.tech.w08.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalExam extends JFrame implements ActionListener {

	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;
	private String[] labels = { "Backspace", "", "", "CE", "C", "7", "8", "9", "/", "sqrt", "4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };

	public static void main(String[] args) {
		new CalExam();
	}// main

	public CalExam() {
		setTitle("계산기잉");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 250);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		tField = new JTextField(45);
		tField.setText("0");
		tField.setHorizontalAlignment(JTextField.CENTER);
		tField.setPreferredSize(new Dimension(0,50));
		tField.setFont(new Font("나눔고딕", Font.BOLD, 20));

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5, 3, 3));

		buttons = new JButton[25];

		int index = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				buttons[index] = new JButton(labels[index]);// 버튼 생성
				buttons[index].addActionListener(this);
				if (col >= 3) {
					buttons[index].setForeground(Color.RED);
				} else {
					buttons[index].setForeground(Color.BLUE);
				}
				buttons[index].setBackground(Color.decode("#FFACAC"));
				buttons[index].setBorder(null);
				panel.add(buttons[index]);
				index++;
			}
		}
////		내꺼
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i] = new JButton(labels[i]); 
//			panel.add(buttons[i]);
//		} // for

		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}// constructor

	private double result = 0;// 결과값
	private String operator = "=";
	private boolean startNumber = true; // 기존의 숫자에 숫자를 더할것인지 판단

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호!!!!!!!!!!!!!!!");
		String alpha = "abcdef";
		String command = e.getActionCommand();
		if (command.charAt(0) == 'C') {// clear
			startNumber = true;
			result = 0;
			operator = "=";
			tField.setText("0.0");
		} else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {// 숫자 구분
			// 숫자가 시작 숫자인지 두번째 숫자인지 판단
			if (startNumber == true) {
				tField.setText(command);
			} else {
				tField.setText(tField.getText() + command);// 기존 숫자에 클릭숫자 부착
			} // if
			startNumber = false;
		} else {
			if (startNumber) {// 숫자의 시작시점
				if (command.equals("-")) {//음수 입력
					tField.setText(command);
				}else {
					operator = command;// 연산의 기호
				}
			} else { // 계산 처리
				Double x = Double.parseDouble(tField.getText());
				calculate(x);// 실제 계산
				operator=command;
				startNumber=true;
			} // if
		} // if
	}// method

	private void calculate(Double x) {
		if (operator.equals("+")) {
			result=result+x;
		}else if (operator.equals("-")) {
			result=result-x;
		}else if (operator.equals("x")) {
			result=result*x;
		}else if (operator.equals("/")) {
			result=result/x;
		}else if (operator.equals("%")) {
			result=result%x;
		}else if (operator.equals("=")) {
			result=x;
		}
		tField.setText(result+"");
	}//method 
}// class