package com.tech.w03;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownExam extends JFrame{
	private JLabel label;
	
	class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("쓰레드 호출 받음 ");
			for (int i = 0; i <10; i++) {
				//잠시멈춤
				//1초
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
				label.setText((i+1)+"");
			}//for
		}//overrid method 
	}//innerClass
	
	public CountDownExam() {
		setTitle("CountDown");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		label = new JLabel("START");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("impact", Font.BOLD, 100));
		add(label);
		
		new MyThread().start();;
		
		
		setVisible(true);
	}//CONSTRUCTOR
	public static void main(String[] args) {
		new CountDownExam();
	}//main
}//class