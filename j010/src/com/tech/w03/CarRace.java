package com.tech.w03;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarRace extends JFrame {
	class myCarThread extends Thread {

		private JLabel label;
		private int x, y;// 자동차 좌표값

		public myCarThread() {}// constructor

		public myCarThread(String fname, int x, int y) {
			// 스타트 라인에 이미지 올리기, 좌표값 필드로 전달
			this.x = x;
			this.y = y;
			label=new JLabel();
			label.setIcon(new ImageIcon("src/"+fname));
			label.setBounds(x,y,50,50);
			
			add(label);
		}// constructor

		@Override
		public void run() {
			System.out.println("쓰레드으으으ㅡㅇ 러어어어언");
			//좌표값을 바꿔주는 쓰레드 동작
			for (int i = 0; i < 200; i++) {
//				System.out.println(Math.random()*10);
				if (x<=500) {
					x+=Math.random()*10;
				}
				
				label.setBounds(x,y,50,50);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//try~catch
			}//for 
		}// override
	}// inner Class

	public CarRace() {
		setTitle("카레이스으");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		new myCarThread("newcar1.png", 100, 0).start();
		new myCarThread("newcar2.png", 100, 50).start();
		new myCarThread("newcar3.png", 100, 100).start();


		setVisible(true);
	}// constructor

	public static void main(String[] args) {
		new CarRace();
	}// main
}// class