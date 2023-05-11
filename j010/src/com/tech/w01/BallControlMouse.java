package com.tech.w01;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyMousePanel extends JPanel {
	BufferedImage img = null;
	int img_x = 100, img_y = 100;

	public MyMousePanel() {
		try {
			img = ImageIO.read(new File("src/ball.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		} // try~catch
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("release");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("press");
				System.out.println("x좌표"+e.getX());
				System.out.println("Y좌표"+e.getY());
				img_x=e.getX();
				img_y=e.getY();
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("exit");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("enter");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click");
			}
		});//mouseListener
	}// constructor
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}//method
}// class

public class BallControlMouse extends JFrame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	}// method

	public BallControlMouse() {
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		add(new MyMousePanel());
		setVisible(true);
	}// constructor

	public static void main(String[] args) {
		new BallControlMouse();
	}// main

}// class