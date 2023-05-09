package com.tech.w04cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// ========= 강사님 코드 =============
public class CalExam3 extends JFrame {

	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;
	private String[] labels = { 
			"Backspace", "", "", "CE", "C", 
			"7", "8", "9", "/", "sqrt", 
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x", 
			"0", "+/-", ".", "+", "=" 
			};

	public static void main(String[] args) {
		new CalExam3();
	}// main

	public CalExam3() {
		setTitle("계산기잉");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 250);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		
		tField = new JTextField(45);
		tField.setText("0.");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,5,3,3));
		
		buttons = new JButton[25];
		
//		강사님 코드
		int index = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				buttons[index]=new JButton(labels[index]);//버튼 생성
				if(col>=3) {
					buttons[index].setForeground(Color.RED);
				}else {
					buttons[index].setForeground(Color.BLUE);
				}
				buttons[index].setBackground(Color.decode("#FFACAC"));
				buttons[index].setBorder(null);
				
				panel.add(buttons[index]);
				index++;
			}
		}
//		내꺼
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i] = new JButton(labels[i]); 
//			panel.add(buttons[i]);
//		} // for
		
		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}// constructor
}// class