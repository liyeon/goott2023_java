package com.tech.w06.mission;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIGBBGame extends JFrame implements ActionListener {
	private JButton scissors, rock, paper;
	private JTextField text1, text2;
	private JPanel topPanel, centerPanel, bottomPanel;
	private String user = "";
	private String com = "";
	private String result = "";

	// 이미지 처리
	Image image1, image2, image3;
	Image changeimg1, changeimg2, changeimg3;
	ImageIcon[] img;

	public GUIGBBGame() {
		setTitle("가위바위보");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		text1 = new JTextField();
		text1.setEditable(false);
		text1.setColumns(40);

		topPanel = new JPanel();
		topPanel.add(text1);
		add(topPanel, "North");

		// 이미지 가져오기
		img = new ImageIcon[3];
		img[0] = new ImageIcon("src/gawi.PNG");
		img[1] = new ImageIcon("src/bawi.PNG");
		img[2] = new ImageIcon("src/bo.PNG");

		// 사이즈 조절
		image1 = img[0].getImage();
		image2 = img[1].getImage();
		image3 = img[2].getImage();

		changeimg1 = image1.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
		changeimg2 = image2.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
		changeimg3 = image3.getScaledInstance(100, 120, Image.SCALE_SMOOTH);

		img[0] = new ImageIcon(changeimg1);
		img[1] = new ImageIcon(changeimg2);
		img[2] = new ImageIcon(changeimg3);
		
		scissors = new JButton();
		scissors.setIcon(img[0]);
		scissors.setBackground(Color.white);
		rock = new JButton();
		rock.setIcon(img[1]);
		rock.setBackground(Color.white);
		paper = new JButton();
		paper.setIcon(img[2]);
		paper.setBackground(Color.white);

		scissors.addActionListener(this);
		rock.addActionListener(this);
		paper.addActionListener(this);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 3));
		centerPanel.add(scissors);
		centerPanel.add(rock);
		centerPanel.add(paper);

		add(centerPanel, "Center");

		text2 = new JTextField();
		text2.setEditable(false);
		text2.setColumns(40);

		bottomPanel = new JPanel();
		bottomPanel.add(text2);
		add(bottomPanel, "South");

		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		Random r = new Random();
		int cNum = r.nextInt(3) + 1;
		if (e.getSource() == scissors) {
			user = "가위";
			if (cNum == 1) {
				com = "가위";
				result = "무승부";
			} else if (cNum == 2) {
				com = "바위";
				result = "컴퓨터 승리";
			} else if (cNum == 3) {
				com = "보";
				result = "사람 승리";
			} // if
		} else if (e.getSource() == rock) {
			user = "바위";
			if (cNum == 1) {
				com = "가위";
				result = "사람 승리";
			} else if (cNum == 2) {
				com = "바위";
				result = "무승부";
			} else if (cNum == 3) {
				com = "보";
				result = "컴퓨터 승리";
			} // if
		} else if (e.getSource() == paper) {
			user = "보";
			if (cNum == 1) {
				com = "가위";
				result = "컴퓨터 승리";
			} else if (cNum == 2) {
				com = "바위";
				result = "사람 승리";
			} else if (cNum == 3) {
				com = "보";
				result = "무승부";
			} // if
		} // if
		text1.setHorizontalAlignment(JTextField.CENTER);
		text1.setText("사람 : " + user + " | 컴퓨터 : " + com);
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setText("결과 : " + result);
	}// method

	public static void main(String[] args) {
		new GUIGBBGame();
	}// main
}// class