package com.kiosk.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.kiosk.main.Favicon;

public class KioskPage implements ActionListener {
	JFrame frame;
	JPanel logoState, orderState, menuList, orderBtnPanel;
	ViewCoffee viewCoffee;
	ViewAde viewAde;
	ViewBlended viewBlended;
	ViewSide viewSide;
	ImageIcon logo, logoReal;
	Image changeLogo;
	JLabel imgLabel, order;
	static JTabbedPane pane;
	String tabCss = "box-sizing: border-box; margin:0;padding: 15px 10px;width:95.3px;height:40px;border-radius:0px;text-align:center;";
	

	Font font = new Font("나눔고딕", Font.BOLD, 17);

	JList<String> list;
	DefaultListModel<String> model;
	JButton insertBtn, cancelBtn;
	JButton[] btn;
	
	Map<Integer, String> hm1=null;
	Map<Integer, String> hm2=null;

	public KioskPage() {
		frame = new JFrame("C A F E::Kiosk");
		frame.setLayout(new BorderLayout());
		frame.setSize(600, 900);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		viewCoffee = new ViewCoffee();
		viewAde = new ViewAde();
		viewBlended = new ViewBlended();
		viewSide = new ViewSide();

		logoState = new JPanel();
		frame.setIconImage(Favicon.getFavi());
		// 이미지 가져오기
		logo = new ImageIcon("src/img/logo.png");
		changeLogo = logo.getImage().getScaledInstance(200, 38, Image.SCALE_SMOOTH);
		logoReal = new ImageIcon(changeLogo);
		imgLabel = new JLabel();
		imgLabel.setPreferredSize(new Dimension(0, 130));
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		imgLabel.setIcon(logoReal);
		logoState.add(imgLabel);
		logoState.add(viewCoffee);
		frame.add(imgLabel, "North");
		tabUI();
		pane = new JTabbedPane();
		pane.setUI(new UIStyle());
		pane.setFont(font);
		pane.add(generateHtml("커피", tabCss), viewCoffee);
		pane.add(generateHtml("에이드", tabCss), viewAde);
		pane.add(generateHtml("블렌디드", tabCss), viewBlended);
		pane.add(generateHtml("사이드", tabCss), viewSide);
		frame.add(pane, BorderLayout.CENTER);

//=========================탭 끝 ===================================

		orderState = new JPanel();
		orderState.setLayout(new BorderLayout());
		order = new JLabel("     선택메뉴");
		order.setPreferredSize(new Dimension(600, 30));
		order.setOpaque(true);
		order.setBackground(Color.decode("#7b00a0"));
		order.setForeground(Color.white);
		order.setFont(font);

		menuList = new JPanel(new GridLayout(0, 1));
		// 목록을 출력 할 수 있는 Jlist
		list = new JList<String>();
		// 기본 모델 객체(목록에 출력할 Data 를 가지고 있는 객체)
		model = new DefaultListModel<String>();
		model.addElement("asdasd");
		model.addElement("asdasd");
		model.addElement("asdasd");
		model.addElement("asdasd");
		model.addElement("asdasd");
		model.addElement("asdasd");
		list.setModel(model);
		list.setFont(font);
		menuList.add(list);
		orderBtnPanel = new JPanel(new GridLayout(0, 2));
		insertBtn = new JButton("주문진행");
		cancelBtn = new JButton("주문취소");
		insertBtn.setPreferredSize(new Dimension(0, 40));
		insertBtn.setBorder(null);
		insertBtn.setBackground(Color.decode("#7b00a0"));
		insertBtn.setForeground(Color.white);
		cancelBtn.setForeground(Color.decode("#7b00a0"));
		cancelBtn.setBackground(Color.white);
		insertBtn.setFont(font);
		cancelBtn.setFont(font);
		cancelBtn.setBorder(null);
		orderBtnPanel.add(insertBtn);
		orderBtnPanel.add(cancelBtn);
		orderState.add(order, BorderLayout.NORTH);
		orderState.add(menuList, BorderLayout.CENTER);
		orderState.add(orderBtnPanel, BorderLayout.SOUTH);
		frame.add(orderState, BorderLayout.SOUTH);
		frame.setVisible(true);
	}// constructor

	public void setVC(ViewCoffee vc) {
		this.hm1=vc.menu;
		this.hm2=vc.price;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}// actionListner

	public static String generateHtml(String tabLabel, String style) {
		String ret = "<html><body style = '" + style + "'>" + tabLabel + "</body></html>";
		return ret;
	}// method

	public void tabUI() {
		UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(Color.decode("#7b00a0")));
		UIManager.put("TabbedPane.darkShadow", new ColorUIResource(Color.decode("#7b00a0")));
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.contentAreaColor ", Color.decode("#7b00a0"));
		UIManager.put("TabbedPane.selected", Color.decode("#F8E8EE"));
		UIManager.put("TabbedPane.foreground", new ColorUIResource(Color.decode("#FFFFFF")));
//		UIManager.put("TabbedPane.selectedForeground", new ColorUIResource(Color.decode("#47A992")));
		UIManager.put("TabbedPane.background", Color.decode("#7b00a0"));
		UIManager.put("TabbedPane.shadow", Color.decode("#7b00a0"));
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		UIManager.put("TabbedPane.light", new ColorUIResource(Color.decode("#7b00a0")));
		UIManager.put("TabbedPane.highlight", new ColorUIResource(Color.decode("#7b00a0")));
		UIManager.put("TabbedPane.focus", Color.decode("#F8E8EE"));
	}// method

	public static void main(String[] args) {
		new KioskPage();
	}// main

}// class

class UIStyle extends BasicTabbedPaneUI {
	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		g.drawRoundRect(x, y, w, h, 0, 0);
		if (isSelected) {
			g.drawLine(x, y, x + w - 4, y + 4);
		} // if
	}// method
}// class