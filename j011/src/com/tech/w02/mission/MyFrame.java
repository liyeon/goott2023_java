package com.tech.w02.mission;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {

	private JButton order_button, cancel_button;
	private JPanel down_panel;
	private JTextField text;
	// 각각의 panel 클래스
	WelcomePanel welcomePanel = new WelcomePanel();
	TypePanel typePanel = new TypePanel();
	SidePanel sidePanel = new SidePanel();
	SizePanel sizePanel = new SizePanel();

	public MyFrame() {
		setTitle("COFFEE SHOP");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// 결과 출력
		order_button = new JButton("주문");
		cancel_button = new JButton("취소");
		order_button.addActionListener(this);
		cancel_button.addActionListener(this);
		
		text = new JTextField();
		text.setEditable(false);// 입력불가
		text.setColumns(25);// 입력길이
		
		down_panel = new JPanel();
		down_panel.add(order_button);
		down_panel.add(cancel_button);
		down_panel.add(text);

		JPanel centerPanel = new JPanel(new GridLayout(0, 3));
		centerPanel.add(typePanel);
		centerPanel.add(sizePanel);
		centerPanel.add(sidePanel);
		// welcomPanel 부착
		add(welcomePanel, "North");
		add(centerPanel, "Center");
		add(down_panel, "South");
		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("주문신호");
		int kindPrice = 0;
		int topPrice = 0;
		if (e.getSource() == order_button) {
			if (typePanel.typeStr == "hot") {
				switch (sizePanel.sizeStr) {
				case "small":
					kindPrice = 1500;
					break;
				case "medium":
					kindPrice = 2000;
					break;
				case "large":
					kindPrice = 2500;
					break;
				default:
					break;
				}// switch~case
			} else if (typePanel.typeStr == "ice") {
				switch (sizePanel.sizeStr) {
				case "small":
					kindPrice = 2000;
					break;
				case "medium":
					kindPrice = 2500;
					break;
				case "large":
					kindPrice = 3000;
					break;
				default:
					break;
				}// switch~case
			}// else~if
			switch (sidePanel.topStr) {
			case "cookie":
				topPrice = 2000;
				break;
			case "banana":
				topPrice = 3000;
				break;
			case "sandwich":
				topPrice = 5000;
				break;
			case "chocolate":
				topPrice = 4000;
				break;
			default:
				break;
			}// switch~case
			text.setText((kindPrice + topPrice)+" 원");
		} else if (e.getSource() == cancel_button) {
			kindPrice = 0;
			topPrice = 0;
			typePanel.typeStr = "";
			sidePanel.topStr = "";
			sizePanel.sizeStr = "";
			typePanel.bg.clearSelection();
			sidePanel.bg.clearSelection();
			sizePanel.bg.clearSelection();
			text.setText("");
		} // else~if
	}// override
}// class MyFrame