package com.tech.w02;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCounter4 extends JFrame implements ActionListener {
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	private JLabel label;
	
	//이미지를 담는 그릇
	private ImageIcon[] imgs;//선언
	public MyCounter4() {
		setTitle("슬롯머신");
		setSize(500, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		labels = new JLabel[3];
		numbers = new int[3];
		//이미지 배열 생성
		imgs = new ImageIcon[10];
		//이미지 보관하기
		for (int i = 0; i < imgs.length; i++) {
			imgs[i]=new ImageIcon("src/"+i+".png");
		}
		// 반복문을 사용해 ㄹ라벨 구성
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("");
			labels[i].setForeground(Color.decode("#F9FBE7"));
			labels[i].setFont(new Font("impact", Font.BOLD, 100));
			labels[i].setSize(100, 100);
			labels[i].setLocation(110 + 100 * i, 20);
			
			//라벨에 이미지 넣기
			labels[i].setIcon(imgs[0]);
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
		label.setSize(200, 100);
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
			labels[i].setIcon(imgs[numbers[i]]);
		} // for
			// 같은 숫자일경우 추카추카 출력
		if(numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
			label.setText("추카추카추 : "+cnt+"번");
		}
		cnt++;
	}// override

}// class

public class SlotMachine4 {

	public SlotMachine4() {

	}// constructor

	public static void main(String[] args) {
		new SlotMachine4();
		new MyCounter4();
	}// main

}// class