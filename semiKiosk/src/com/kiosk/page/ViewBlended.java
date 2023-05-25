package com.kiosk.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewBlended extends JPanel {
	Map<Integer, String> menu; // 메뉴의 정보를 보관
	Map<Integer, String> price;
	JButton[] btn;

	public ViewBlended() {
		setLayout(new GridLayout(0, 4));
		setBackground(Color.decode("#F8E8EE"));
		btn = new JButton[7];

		menu = new HashMap<Integer, String>();
		price = new HashMap<Integer, String>();
		setMenu();
		setPrice();
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			ImageIcon c = new ImageIcon("src/img/blended/img" + (i + 1) + ".png");
			Image changeC = c.getImage().getScaledInstance(90, 160, Image.SCALE_SMOOTH);
			ImageIcon realImg = new ImageIcon(changeC);
			btn[i].setIcon(realImg);
			btn[i].setBorder(null);
			btn[i].setVerticalTextPosition(JButton.BOTTOM); // 버튼 수직 기준 텍스트 위치 지정
			btn[i].setHorizontalTextPosition(JButton.CENTER); // 버튼 수평 기준 텍스트 위치 지정
			btn[i].setBackground(Color.white);
			btn[i].setText("<html><body><center>" + menu.get(i) + "<br/>" + price.get(i) + "</center></body></html>");
			add(btn[i]);

		} // for
	}// constructor

	public void setMenu() {
		menu.put(0, "코코초코프라페");
		menu.put(1, "자바칩프라페");
		menu.put(2, "딸기쉐이크");
		menu.put(3, "딸기요거트스무디");
		menu.put(4, "플레인요거트스무디");
		menu.put(5, "쿠키앤크림프라페");
		menu.put(6, "딸기초코칩프라페");
	}// method

	public void setPrice() {
		price.put(0, "4400원");
		price.put(1, "4400원");
		price.put(2, "4400원");
		price.put(3, "4400원");
		price.put(4, "4400원");
		price.put(5, "4400원");
		price.put(6, "4700원");
	}// method
}// class