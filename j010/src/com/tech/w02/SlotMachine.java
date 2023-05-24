package com.tech.w02;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCounter extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;

	public MyCounter() {
		setTitle("슬롯머신");
		setSize(500, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBackground(Color.decode("#F1BAA1"));
		labels = new JLabel[3];
		numbers = new int[3];
		
		//반복문을 사용해 ㄹ라벨 구성
		for (int i = 0; i < labels.length; i++) {
			labels[i]=new JLabel(numbers[i]+"");
			labels[i].setFont(new Font("impact", Font.BOLD, 100));
			labels[i].setSize(100,100);
			labels[i].setLocation(110+100*i, 20);
			panel.add(labels[i]);
		}//for
		
		//버튼 추가
		button = new JButton("땡겨용");
		button.setBackground(Color.decode("#BD613C"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		button.setSize(250,50);
		button.setLocation(115,150);
		panel.add(button);
		add(panel);
		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
	}// override

}// class

public class SlotMachine {

	public SlotMachine() {

	}// constructor

	public static void main(String[] args) {
		new SlotMachine();
		new MyCounter();
	}// main

}// class