package com.kiosk.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kiosk.admin.AdminFrame;
import com.kiosk.page.KioskPage;

public class MainFrame extends JFrame {
	Font font = new Font("나눔고딕", Font.BOLD, 20);
	ImageIcon logo, logoReal;
	Image changeLogo;
	JLabel imgLabel;
	JPanel imagePanel, btnPanel;
	JButton btn;

	public MainFrame() {
		setTitle("C A F E::Kiosk::MAIN");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 900);
		setLocationRelativeTo(null);

		// 파비콘 설정
		setIconImage(Favicon.getFavi());

		// 뒤로가기
		JButton reBtn = new JButton("뒤로가기   ");
		reBtn.setSize(new Dimension(100, 40));
		reBtn.setFocusable(false);
		reBtn.setHorizontalAlignment(JButton.RIGHT);
		reBtn.setForeground(Color.decode("#530969"));
		reBtn.setBackground(Color.decode("#FFFFFF"));
		reBtn.setPreferredSize(new Dimension(0, 40));
		reBtn.setBorder(null);
		reBtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		reBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminFrame();
				dispose();
			}
		});

		// 메인 이미지 설정
		// 이미지 가져오기
		logo = new ImageIcon("src/img/logo.png");
		changeLogo = logo.getImage().getScaledInstance(400, 75, Image.SCALE_SMOOTH);
		logoReal = new ImageIcon(changeLogo);
		imgLabel = new JLabel();
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		imgLabel.setIcon(logoReal);

		imagePanel = new JPanel();
		btn = new JButton("주문하시려면 화면을 클릭하세요.");
		btn.setFocusable(false);
		btn.setPreferredSize(new Dimension(0, 100));
		btn.setBackground(new Color(123, 0, 160));
		btn.setBorder(null);
		btn.setFont(font);
		btn.setForeground(Color.white);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new KioskPage();
				dispose();
			}// override
		});// actionListener
		imagePanel.setBackground(Color.decode("#FFFFFF"));
		imagePanel.setLayout(new BorderLayout());
		imagePanel.add(imgLabel);

		add(reBtn, BorderLayout.NORTH);
		add(imagePanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setResizable(false);// 사이즈 조절 불가
		setVisible(true);
	}// constructor
}// class