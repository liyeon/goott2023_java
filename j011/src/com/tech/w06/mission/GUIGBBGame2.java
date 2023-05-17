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

public class GUIGBBGame2 extends JFrame implements ActionListener {
	private JButton scissors, rock, paper;
	private JTextField text1, text2, text3;
	private JPanel topPanel, centerPanel, bottomPanel;
	private String user = "";
	private String com = "";
	private String result = "";

	// 10의 배수일때 승률 표현 아닐때는 카운트만 표시 GBB승률_홍길동
	// 이미지 처리
	Image image1, image2, image3;
	Image changeimg1, changeimg2, changeimg3;
	ImageIcon[] img;

	public GUIGBBGame2() {
		setTitle("가위바위보");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		text1 = new JTextField();
		text1.setEditable(false);
		text1.setColumns(40);

		text3 = new JTextField();
		text3.setEditable(false);
		text3.setColumns(40);

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2, 0));
		topPanel.add(text1);
		topPanel.add(text3);
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

		changeimg1 = image1.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		changeimg2 = image2.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		changeimg3 = image3.getScaledInstance(80, 100, Image.SCALE_SMOOTH);

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

	int total = 0;
	int userCnt = 0;
	int comCnt = 0;
	int tieCnt = 0;
	int percent = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		Random r = new Random();
		int cNum = r.nextInt(3) + 1;
		if (e.getSource() == scissors) {
			total++;
			user = "가위";
			if (cNum == 1) {
				com = "가위";
				result = "무승부";
				tieCnt++;
			} else if (cNum == 2) {
				com = "바위";
				result = "컴퓨터 승리";
				comCnt++;
			} else if (cNum == 3) {
				com = "보";
				result = "사람 승리";
				userCnt++;
			} // if
		} else if (e.getSource() == rock) {
			total++;
			user = "바위";
			if (cNum == 1) {
				com = "가위";
				result = "사람 승리";
				userCnt++;
			} else if (cNum == 2) {
				com = "바위";
				result = "무승부";
				tieCnt++;
			} else if (cNum == 3) {
				com = "보";
				result = "컴퓨터 승리";
				comCnt++;
			} // if
		} else if (e.getSource() == paper) {
			total++;
			user = "보";
			if (cNum == 1) {
				com = "가위";
				result = "컴퓨터 승리";
				comCnt++;
			} else if (cNum == 2) {
				com = "바위";
				result = "사람 승리";
				userCnt++;
			} else if (cNum == 3) {
				com = "보";
				result = "무승부";
				tieCnt++;
			} // if
		} // if
		text1.setHorizontalAlignment(JTextField.CENTER);
		text1.setText("사람 : " + user + " | 컴퓨터 : " + com);
		text2.setHorizontalAlignment(JTextField.CENTER);
		text2.setText("결과 : " + result);
		text3.setHorizontalAlignment(JTextField.CENTER);
		text3.setText("총 횟수 : " + total);
		double odds = 0;
		if (total % 10 == 0) {
			System.out.println("무승부 : " + tieCnt);
			System.out.println("사람 승 : " + userCnt);
			System.out.println("컴 승 : " + comCnt);
			odds = ((double)userCnt/(double)(userCnt+comCnt))*100;
			double rd = Math.round(odds*100)/100.0;
			text3.setText("총경기 : "+total+" | 사람 승 : "+userCnt+" 사람 승률" +rd+ "%");
		}

	}// method

	public static void main(String[] args) {
		new GUIGBBGame2();
	}// main
}// class