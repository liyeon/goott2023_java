package com.tech.w06.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ActionEvent1 extends JFrame {
	// ~~~~필드~~~~
	private JButton button;
	private JLabel label;

	public ActionEvent1() {
		setTitle("event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		button = new JButton("버튼을 눌러주세요!");
		label = new JLabel("버튼을 아직 안 눌러주셨네요ㅠㅜ");

		// 수신자 부착! 이벤트의 신호를 받음
		button.addActionListener(new MyListener2());
		// panel 에 버튼 부착!
		panel.add(button);
		// panel 에 label 부착
		panel.add(label);

		// panel을 frame에 부착
		add(panel);
		setVisible(true);
	}// constructor

	// 내부 클래스
	private class MyListener2 implements ActionListener {
		boolean flag = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("신호 감??" + e);
			if (flag) {
				button.setText("버튼 눌러잉");
				label.setText("버튼 눌러벌임ㄷㄷ");
				flag = false;
			} else {
				flag = true;
				button.setText("버튼을 눌러주세요!");
				label.setText("버튼을 아직 안 눌러주셨네요ㅠㅜ");
			} // if
			System.out.println("flag : "+ flag);
		}// method
	}// inner class

	public static void main(String[] args) {
		new ActionEvent1();
	}// main
}// class