package com.kiosk.page;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewAde extends JPanel implements ActionListener {
	Map<Integer, String> menu; // 메뉴의 정보를 보관
	Map<Integer, String> price;
	JButton[] btn;
	KioskPage kioskPage;
	CModel c = new CModel();

	public ViewAde(KioskPage kioskPage) {

		this.kioskPage = kioskPage;

		setLayout(new GridLayout(0, 4));
		setBackground(Color.decode("#F8E8EE"));
		btn = new JButton[5];

		menu = new HashMap<Integer, String>();
		price = new HashMap<Integer, String>();
		setMenu();
		setPrice();
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			ImageIcon c = new ImageIcon("src/img/ade/img" + (i + 1) + ".png");
			Image changeC = c.getImage().getScaledInstance(90, 160, Image.SCALE_SMOOTH);
			ImageIcon realImg = new ImageIcon(changeC);
			btn[i].setIcon(realImg);
			btn[i].setBorder(null);
			btn[i].setVerticalTextPosition(JButton.BOTTOM); // 버튼 수직 기준 텍스트 위치 지정
			btn[i].setHorizontalTextPosition(JButton.CENTER); // 버튼 수평 기준 텍스트 위치 지정
			btn[i].setBackground(Color.white);
			btn[i].setText("<html><body><center>" + menu.get(i) + "<br/>" + price.get(i) + "</center></body></html>");
			btn[i].addActionListener(this);
			add(btn[i]);
		} // for
	}// constructor

	public void setMenu() {
		menu.put(0, "청포도에이드");
		menu.put(1, "오렌지에이드");
		menu.put(2, "블루레몬에이드");
		menu.put(3, "자몽에이드");
		menu.put(4, "체리콕");
	}// method

	public void setPrice() {
		price.put(0, "4400원");
		price.put(1, "4400원");
		price.put(2, "4400원");
		price.put(3, "4400원");
		price.put(4, "4400원");
	}// method

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < btn.length; i++) {
			if (e.getSource() == btn[i]) {
				System.out.println(menu.get(i));
				System.out.println(price.get(i));
				c.setcName(menu.get(i));
				c.setcPrice(price.get(i));
				send();
			} // if
		} // for
	}// method override

	public void send() {
		String msg = c.getcName() + c.getcPrice();
		// 모델에 입력한 문자열 추가하기
		kioskPage.model.addElement(msg);
	}// method
}// class