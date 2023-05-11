package com.tech.w02;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCounter3 extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	private JLabel label;

	public MyCounter3() {
		setTitle("슬롯머신");
		setSize(500, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.setBackground(Color.decode("#ECCDB4"));
		labels = new JLabel[3];
		numbers = new int[3];

		// 반복문을 사용해 ㄹ라벨 구성
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(numbers[i] + "");
			labels[i].setForeground(Color.decode("#F9FBE7"));
			labels[i].setFont(new Font("impact", Font.BOLD, 100));
			labels[i].setSize(100, 100);
			labels[i].setLocation(110 + 100 * i, 20);
			panel.add(labels[i]);
		} // for

		// 버튼 추가
		button = new JButton("땡겨용");
		button.setBackground(Color.decode("#FEA1A1"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		button.setSize(250, 50);
		button.setLocation(115, 150);

		button.addActionListener(this);

		label = new JLabel();
		label.setText("");
		label.setSize(100, 100);
		label.setLocation(200, 80);
		panel.add(button);
		panel.add(label);

		add(panel);
		setVisible(true);
	}// constructor

	int cnt = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 10);
			labels[i].setText("" + numbers[i]);
		} // for
			// 같은 숫자일경우 추카추카 출력
		if (numbers[0]==7 && numbers[1]==7 && numbers[2]==7) {
			label.setText("777 잭팟이라궁 : "+cnt+1+"번");
		}else if(numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
			label.setText("추카추카추 : "+cnt+1+"번");
		}else {
			label.setText("");
		}
		cnt++;
	}// override

}// class

public class SlotMachine3 {

	public SlotMachine3() {

	}// constructor

	public static void main(String[] args) {
		new SlotMachine3();
		new MyCounter3();
	}// main

}// class