package com.tech.w05.race;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class RaceThreadx extends Thread {
	RaceFrame frame;
	int x, y, w, h;

	public RaceThreadx(RaceFrame frame, int x, int y, int w, int h) {
		this.frame = frame;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}// constructor

	@Override
	public void run() {
		System.out.println("쓰레드~~~~~~~~~~");
		//랜덤값을 얻어서 sleep 시간으로 지정, x값은 endline 까지 증가
		Random r = new Random();
		Dimension d = frame.getSize();

		 int widthLast=(int)(d.getWidth()-(2*x))+30;
//	      System.out.println("widthLast : "+widthLast);
	      for (; x < widthLast; x+=20) {
	         frame.repaint();
	         try {
	            Thread.sleep(r.nextInt(1000)+30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//try~catch
		}//for
		frame.repaint();
	}// thread override run
}// outer class

@SuppressWarnings("serial")
class RaceFrame extends JFrame implements ActionListener {

	RaceThreadx thread1;
	RaceThreadx thread2;
	RaceThreadx thread3;
	RaceThreadx thread4;
	RaceThreadx thread5;

	// 버튼 준비
	JButton startButton = new JButton("시작");
	JButton clearButton = new JButton("초기화");

	Dimension d;

	int i[] = { 0, 0, 0, 0, 0 };
	boolean re1 = true, re2 = true, re3 = true, re4 = true, re5 = true;
	private Image img, img1, img2, img3, img4;

	public RaceFrame() {
		setLayout(new BorderLayout());

		// 버튼에 수신자 부착
		startButton.addActionListener(this);
		clearButton.addActionListener(this);

		JPanel p = new JPanel();

		p.add(startButton);
		p.add(clearButton);
		add(p, BorderLayout.NORTH);

		// 쓰레드 객체 생성
		thread1 = new RaceThreadx(this, 50, 100, 38, 36);
		thread2 = new RaceThreadx(this, 50, 150, 38, 36);
		thread3 = new RaceThreadx(this, 50, 200, 38, 36);
		thread4 = new RaceThreadx(this, 50, 250, 38, 36);
		thread5 = new RaceThreadx(this, 50, 300, 38, 36);

		// 이미지 처리
		img = Toolkit.getDefaultToolkit().getImage("src/newcar4.png");
		img1 = Toolkit.getDefaultToolkit().getImage("src/newcar4.png");
		img2 = Toolkit.getDefaultToolkit().getImage("src/newcar4.png");
		img3 = Toolkit.getDefaultToolkit().getImage("src/newcar4.png");
		img4 = Toolkit.getDefaultToolkit().getImage("src/newcar4.png");
	}// constructor

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("painting");
		g.drawLine(750, 0, 750, 500);
		
		//등수판정
		for (int k = 0; k < i.length; k++) {
			if(thread1.x==750&& i[k]==0&& re1) {//피니시라인통과
				i[k]=1;
				re1=false;
				break;
			}else if(thread2.x==750&& i[k]==0&& re2) {
				i[k]=2;
				re2=false;
				break;
			}else if(thread3.x==750&& i[k]==0&& re3) {
				i[k]=3;
				re3=false;
				break;
			}else if(thread4.x==750&& i[k]==0&& re4) {
				i[k]=4;
				re4=false;
				break;
			}else if(thread5.x==750&& i[k]==0&& re5) {
				i[k]=5;
				re5=false;
				break;
			}//if
		}//for
		System.out.println(Arrays.toString(i));
		
		if(i[0]>0)g.drawString("1등 : "+i[0]+"번 자동차", 260, 350);
		if(i[1]>0)g.drawString("2등 : "+i[1]+"번 자동차", 260, 350+20);
		if(i[2]>0)g.drawString("3등 : "+i[2]+"번 자동차", 260, 350+40);
		if(i[3]>0)g.drawString("4등 : "+i[3]+"번 자동차", 260, 350+60);
		if(i[4]>0)g.drawString("5등 : "+i[4]+"번 자동차", 260, 350+80);
		
		g.drawImage(img, thread1.x, thread1.y, thread1.w, thread1.h, this);
		g.drawImage(img1, thread2.x, thread2.y, thread2.w, thread2.h, this);
		g.drawImage(img2, thread3.x, thread3.y, thread3.w, thread3.h, this);
		g.drawImage(img3, thread4.x, thread4.y, thread4.w, thread4.h, this);
		g.drawImage(img4, thread5.x, thread5.y, thread5.w, thread5.h, this);
	} // repaint override

	@Override
	public void actionPerformed(ActionEvent e) {
		// 시작버튼을 누르면
		if (e.getSource() == startButton) {
			System.out.println("시작버튼 신호");
			
			try {
				thread1.start();
				thread2.start();
				thread3.start();
				thread4.start();
				thread5.start();
			} catch (Exception e2) {
				System.out.println("오류");
			}//try~catch
		} else if (e.getSource() == clearButton) {
			thread1 = new RaceThreadx(this, 50, 100, 38, 36);
			thread2 = new RaceThreadx(this, 50, 150, 38, 36);
			thread3 = new RaceThreadx(this, 50, 200, 38, 36);
			thread4 = new RaceThreadx(this, 50, 250, 38, 36);
			thread5 = new RaceThreadx(this, 50, 300, 38, 36);
			for (int k = 0; k < i.length; k++) {
				i[k]=0;
				
			}//for
			re1=true;
			re2=true;
			re3=true;
			re4=true;
			re5=true;
			repaint();
			System.out.println("초기화 버튼 신호");
		}//if
	}// override
}// outer class

public class CarRace {
	public static void main(String[] args) {
		RaceFrame frame = new RaceFrame();

		frame.setTitle("달려보자아");
		frame.setSize(850, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new CarRace();
	}// main
}// class