package com.tech.w06.mission;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GBBFrame extends JFrame implements ActionListener {
	private ImageIcon img1, img2, img3;
	private JButton gawi, bawi, bo;
	private JLabel label, result;
	private Font font;
	private int gawiNum, bawiNum, boNum;

	public GBBFrame() {
		setTitle("가위바위보");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#AACD6E"));

		font = new Font("나눔고딕", Font.BOLD, 20);

		JPanel gbb = new JPanel(new GridLayout(0, 3));
		label = new JLabel("사람 : [    ]" + "  |  컴퓨터 : [    ]");
		label.setPreferredSize(new Dimension(0, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(font);
		label.setForeground(Color.white);
		/// j011/src/gawi.png
		JLabel text = new JLabel("가위 : 1, 바위 : 2, 보 : 3");
		img1 = new ImageIcon("src/gawi.png");
		Image img1_c = img1.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon changeImg1 = new ImageIcon(img1_c);

		img2 = new ImageIcon("src/bawi.png");
		Image img2_c = img2.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon changeImg2 = new ImageIcon(img2_c);

		img3 = new ImageIcon("src/bo.png");
		Image img3_c = img3.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
		ImageIcon changeImg3 = new ImageIcon(img3_c);

		gawi = new JButton(changeImg1);
		gawi.setBackground(Color.WHITE);
		gawi.setBorder(null);
		bawi = new JButton(changeImg2);
		bawi.setBackground(Color.WHITE);
		bawi.setBorder(null);
		bo = new JButton(changeImg3);
		bo.setBackground(Color.WHITE);
		bo.setBorder(null);

		// 버튼 신호
		gawi.addActionListener(this);
		bawi.addActionListener(this);
		bo.addActionListener(this);

		gbb.add(gawi);
		gbb.add(bawi);
		gbb.add(bo);

		result = new JLabel("결과 : ");
		result.setFont(font);
		result.setForeground(Color.white);
		result.setHorizontalAlignment(JLabel.CENTER);
		result.setPreferredSize(new Dimension(0, 50));

		add(text, "North");
		add(label, "North");
		add(gbb, "Center");
		add(result, "South");
		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println();
		Random r = new Random();
		int cNum = 0;
		String cStr = "";
		cNum = r.nextInt(3) + 1;
		if (cNum == 1) {
			cStr = "가위";
		} else if (cNum == 2) {
			cStr = "바위";
		} else if (cNum == 3) {
			cStr = "보";
		} // if
		if (e.getSource() == gawi) {
			this.gawiNum = 1;
			label.setText("사람 : [ 가위 ]" + "  |  컴퓨터 : [" + cStr + " ]");
			judge(cNum, gawiNum);
		} else if (e.getSource() == bawi) {
			this.bawiNum = 2;
			label.setText("사람 : [ 바위 ]" + "  |  컴퓨터 : [" + cStr + " ]");
			judge(cNum, bawiNum);
		} else if (e.getSource() == bo) {
			this.boNum = 3;
			label.setText("사람 : [ 보 ]" + "  |  컴퓨터 : [" + cStr + " ]");
			judge(cNum, boNum);
		} // if
	}// method

	public void judge(int cNum, int yNum) {
		// 가위 : 1, 바위 : 2, 보 : 3
		if ((cNum == 1 && yNum == 3) || (cNum == 2 && yNum == 1) || (cNum == 3 && yNum == 2)) {
			result.setText("컴퓨터가 승리했습니다.");
		} else if ((yNum == 1 && cNum == 3) || (yNum == 2 && cNum == 1) || (yNum == 3 && cNum == 2)) {
			result.setText("사람이 승리했습니다.");
		} else {
			result.setText("무승부");
		}
	}// judge

	public static void main(String[] args) {
		new GBBFrame();
	}// main
}// class
