package com.tech.w01;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxExam extends JPanel implements ItemListener, ActionListener{

	//~~~필드~~~~
	private JCheckBox[] buttons = new JCheckBox[3];
	private String[] fruits = {"apple", "grape", "orange"};
	private JLabel[] labels = new JLabel[3];
	private ImageIcon[] icon = new ImageIcon[3];
	
	
	public CheckBoxExam() {
		setLayout(new GridLayout(0,4));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i]=new JCheckBox(fruits[i]);
//			buttons[i].addActionListener(this);
			buttons[i].addItemListener(this);
			buttons[i].setBackground(Color.decode("#FFB84C"));
			labels[i]=new JLabel(fruits[i]+".gif");
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			icon[i]=new ImageIcon(fruits[i]+".gif");
		}//for
		JPanel checkPanel = new JPanel(new  GridLayout(0,1));
		for (int i = 0; i < buttons.length; i++) {
			checkPanel.add(buttons[i]);
		}//for
		add(checkPanel);
		add(labels[0]);
		add(labels[1]);
		add(labels[2]);
		
	}//constructor
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("체크박스으");
		frame.setSize(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		CheckBoxExam panel = new CheckBoxExam();
		frame.add(panel);
		frame.setVisible(true);
	}//main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호");
	}//ActionListener
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("state Change");
		Object source = e.getItemSelectable();
		for (int i = 0; i < buttons.length; i++) {
			if (source == buttons[i]) {
				if(e.getStateChange()==ItemEvent.DESELECTED) {//check none
					labels[i].setIcon(null);
				}else {
					labels[i].setIcon(icon[i]);
				}
			}//if
		}//for
	}//ItemListener

}//class