package com.tech.w01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame2 extends JFrame implements ActionListener {

	private JButton order_button, cancel_button;
	private JPanel down_panel;
	private JTextField text;
	// 각각의 panel 클래스
	WelcomePanel2 welcomePanel = new WelcomePanel2();
	TypePanel2 typePanel = new TypePanel2();
	ToppingPanel2 toppingPanel = new ToppingPanel2();
	SizePanel2 sizePanel = new SizePanel2();

	public MyFrame2() {
		setTitle("PIZZA SHOP");
		setSize(500, 200);
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
		centerPanel.add(toppingPanel);
		centerPanel.add(sizePanel);
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
			if (typePanel.typeStr == "combo") {
				switch (sizePanel.sizeStr) {
				case "small":
					kindPrice = 10000;
					break;
				case "medium":
					kindPrice = 15000;
					break;
				case "large":
					kindPrice = 20000;
					break;
				default:
					break;
				}// switch~case
			} else if (typePanel.typeStr == "potato") {
				switch (sizePanel.sizeStr) {
				case "small":
					kindPrice = 11000;
					break;
				case "medium":
					kindPrice = 16000;
					break;
				case "large":
					kindPrice = 21000;
					break;
				default:
					break;
				}// switch~case
			} else if (typePanel.typeStr == "bulgogi") {
				switch (sizePanel.sizeStr) {
				case "small":
					kindPrice = 12000;
					break;
				case "medium":
					kindPrice = 17000;
					break;
				case "large":
					kindPrice = 22000;
					break;
				default:
					break;
				}// switch~case
			} // else~if
			switch (toppingPanel.topStr) {
			case "pepper":
				topPrice = 1000;
				break;
			case "cheese":
				topPrice = 2000;
				break;
			case "peperoni":
				topPrice = 3000;
				break;
			case "bacon":
				topPrice = 4000;
				break;
			default:
				break;
			}// switch~case
			text.setText("price : " + (kindPrice + topPrice));
		} else if (e.getSource() == cancel_button) {
			kindPrice = 0;
			topPrice = 0;
			typePanel.typeStr = "";
			toppingPanel.topStr = "";
			sizePanel.sizeStr = "";
			typePanel.bg.clearSelection();
			toppingPanel.bg.clearSelection();
			sizePanel.bg.clearSelection();
			text.setText("");
		} // else~if
	}// override
}// class MyFrame

class WelcomePanel2 extends JPanel {
	private JLabel message;

	public WelcomePanel2() {
		message = new JLabel("!!!!!WELCOME PIZZA SHOP!!!!!");
		this.add(message);// panel에 label 부착
	}// constructor
}// class WelcomePanel

class TypePanel2 extends JPanel implements ActionListener {

	protected JRadioButton combo, potato, bulgogi;
	protected ButtonGroup bg;
	protected String typeStr = "";

	public TypePanel2() {
		setLayout(new GridLayout(3, 1));
		combo = new JRadioButton("콤보");
		potato = new JRadioButton("감자");
		bulgogi = new JRadioButton("불고기");

		combo.addActionListener(this);
		potato.addActionListener(this);
		bulgogi.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(combo);
		bg.add(potato);
		bg.add(bulgogi);
		this.setBorder(BorderFactory.createTitledBorder("Type"));

		add(combo);
		add(potato);
		add(bulgogi);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo) {
			typeStr = "combo";
		} else if (e.getSource() == potato) {
			typeStr = "potato";
		} else if (e.getSource() == bulgogi) {
			typeStr = "bulgogi";
		} // if
		System.out.println("type2 신호 " + typeStr);
	}// override
}// class TypePanel

class ToppingPanel2 extends JPanel implements ActionListener {
	protected JCheckBox pepper, cheese, peperoni, bacon;
	protected ButtonGroup bg;
	protected String topStr = "";

	public ToppingPanel2() {
		setLayout(new GridLayout(4, 1));
		pepper = new JCheckBox("피망");
		cheese = new JCheckBox("치이즈");
		peperoni = new JCheckBox("페페로니");
		bacon = new JCheckBox("베이컨");

		// 수신자 부착
		pepper.addActionListener(this);
		cheese.addActionListener(this);
		peperoni.addActionListener(this);
		bacon.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(pepper);
		bg.add(cheese);
		bg.add(peperoni);
		bg.add(bacon);
		this.setBorder(BorderFactory.createTitledBorder("Topping"));

		add(pepper);
		add(cheese);
		add(peperoni);
		add(bacon);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pepper) {
			topStr = "pepper";
		} else if (e.getSource() == cheese) {
			topStr = "cheese";
		} else if (e.getSource() == peperoni) {
			topStr = "peperoni";
		} else if (e.getSource() == bacon) {
			topStr = "bacon";
		} // if
		System.out.println("topping2 신호 " + topStr);
	}// override
}// class ToppingPanel

class SizePanel2 extends JPanel implements ActionListener {
	protected JRadioButton small, medium, large;
	protected ButtonGroup bg;
	protected String sizeStr = "";

	public SizePanel2() {
		setLayout(new GridLayout(3, 1));
		small = new JRadioButton("SMALL");
		medium = new JRadioButton("MEDIUM");
		large = new JRadioButton("LARGE");

		// 수신자 부착
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(small);
		bg.add(medium);
		bg.add(large);
		this.setBorder(BorderFactory.createTitledBorder("SIZE"));

		add(small);
		add(medium);
		add(large);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small) {
			sizeStr = "small";
		} else if (e.getSource() == medium) {
			sizeStr = "medium";
		} else if (e.getSource() == large) {
			sizeStr = "large";
		} // if
		System.out.println("size 신호 " + sizeStr);
	}// override

}// class SizePanel

public class PizzaOrderExam2 {
	public static void main(String[] args) {
		new MyFrame2();
	}// main
}// class