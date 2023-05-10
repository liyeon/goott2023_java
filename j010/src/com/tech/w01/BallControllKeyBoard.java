package com.tech.w01;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanel extends JPanel {
	BufferedImage img = null;// 임시 저장 공간
	int img_x = 100, img_y = 100; // 좌표값

	public MyPanel() {
		// 화면 구성!
//		//j010/src/ball.png
		try {
			img = ImageIO.read(new File("src/ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("이미지가 없습니다.");
		} // try~catch

		// 키보드 리스너
		//
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}// method

			@Override
			public void keyReleased(KeyEvent e) {}// method

			@Override
			public void keyPressed(KeyEvent e) {// 키보드
				System.out.println("keyPress");
				int keyCode = e.getKeyCode();
				System.out.println(keyCode);
				switch (keyCode) {
				case KeyEvent.VK_UP:
					img_y -= 10;
					break;
				case KeyEvent.VK_DOWN:
					img_y += 10;
					break;
				case KeyEvent.VK_LEFT:
					img_x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					img_x += 10;
					break;
				default:
					break;
				}// switch~case
				repaint();// 화면에 다시 그리기
			}// method
		});// keyListener
		this.requestFocus();
		setFocusable(true);
	}// constructor

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}//method
}// class

public class BallControllKeyBoard extends JFrame implements ActionListener {

	public BallControllKeyBoard() {
		setTitle("키보드로 뭐하냐..");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// panle을 프레임에 추가
		add(new MyPanel());

		setVisible(true);

	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {}// method

	public static void main(String[] args) {
		new BallControllKeyBoard();
	}// main
}// class