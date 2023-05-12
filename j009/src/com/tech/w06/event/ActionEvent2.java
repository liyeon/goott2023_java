package com.tech.w06.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ActionEvent2 extends JFrame implements ActionListener {
	// ~~~~필드~~~~
	private JButton button1, button2;
	private JLabel label;
	boolean flag1 = true;
	boolean flag2 = false;
	
	public ActionEvent2() {
		setTitle("event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
		label = new JLabel("버튼을 아직 안 눌러주셨네요ㅠㅜ");

		// 수신자 부착! 이벤트의 신호를 받음
		button1.addActionListener(this);
		button2.addActionListener(this);
		// panel 에 버튼 부착!
		panel.add(button1);
		panel.add(button2);
		// panel 에 label 부착
		panel.add(label);

		// panel을 frame에 부착
		add(panel);
		setVisible(true);
	}// constructor

	public static void main(String[] args) {
		new ActionEvent2();
	}// main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText() == "버튼1") {
			System.out.println("버튼 1");
			if (flag1) {
				label.setText("버튼1 ONNNN");
				flag1 = false;
			} else {
				flag1 = true;
				label.setText("버튼1 OFFFF");
			} // if
		} else if (button.getText() == "버튼2") {
			System.out.println("버튼 2");
			if (flag2) {
				label.setText("버튼2 ONNNN");
				flag2 = false;
			} else {
				flag2 = true;
				label.setText("버튼2 OFFFF");
			} // if
		}//if
	}
}// class