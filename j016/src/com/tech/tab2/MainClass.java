package com.tech.tab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainClass implements ActionListener,ChangeListener {
	JFrame f;
	ViewA a;
	ViewB b;
	ViewC c;
	ViewD d;
	ViewHome home;

	static JTabbedPane pane;

	public MainClass() {
		f = new JFrame("홍길동 프로젝트");
		f.setLayout(new BorderLayout());
		f.setSize(500, 400);
		f.setLocationRelativeTo(null);
		a = new ViewA();
		b = new ViewB();
		c = new ViewC();
		d = new ViewD();
		home = new ViewHome();

		a.btn1.addActionListener(this);
		a.cbox.addActionListener(this);
		d.cbox.addActionListener(this);
		home.btnHome.addActionListener(this);
		f.add(a, "North");
		f.add(home, "South");

		pane = new JTabbedPane();
		pane.addChangeListener(this);
		pane.add("재고관리", a);
		pane.add("매장관리", b);
		pane.add("매출관리", c);
		pane.add("직원관리", d);
		f.add(pane, BorderLayout.CENTER);
		f.setVisible(true);
	}// constructor

	int price = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호 : " + e.getActionCommand());

		if (e.getSource() == a.cbox) {
			System.out.println(a.cbox.getSelectedItem());
			if (a.cbox.getSelectedItem().equals("apple1")) {
				price += 10;
			} else if (a.cbox.getSelectedItem().equals("apple2")) {
				price += 20;
			} else if (a.cbox.getSelectedItem().equals("apple3")) {
				price += 30;
			} // else getselected
		} else if (e.getSource() == a.btn1) {
			b.field.setText("[ 사 과 가 격 ] " + price);
			pane.setSelectedIndex(1);
		} else if (e.getSource() == home.btnHome) {
			pane.setSelectedIndex(0);
		} else if (e.getSource() == d.cbox) {
			System.out.println(d.cbox.getSelectedItem());
			if (d.cbox.getSelectedItem().equals("banana1")) {
				price += 1000000;
			} else if (d.cbox.getSelectedItem().equals("banana2")) {
				price += 2000000;
			} else if (d.cbox.getSelectedItem().equals("banana3")) {
				price += 3000000;
			} // else getselected
			pane.setSelectedIndex(2);
			c.fieldc.setText("받아온 : " + price);
		} // if getsource
	}// method override

	@Override
	public void stateChanged(ChangeEvent e) {

		if (pane.getSelectedIndex() == 1) {
			pane.setForegroundAt(1, Color.green);
		}
//	      
	}

	public static void main(String[] args) {
		new MainClass();
	}// main

}// class