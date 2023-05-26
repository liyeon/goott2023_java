package com.kiosk.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.db.DBConnection;
import com.kiosk.main.Favicon;
import com.kiosk.main.MainFrame;

public class KioskPage extends JFrame implements ActionListener, ListSelectionListener {
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
	CModel c;
	Font font = new Font("나눔고딕", Font.BOLD, 17);
	Connection conn = null;
	public JList<String> list;
	DefaultListModel<String> model;
	JButton insertBtn, cancelBtn;
	JButton[] btn;

	public KioskPage() {
		setTitle("C A F E::Kiosk");
		setLayout(new BorderLayout());
		setSize(600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		viewCoffee = new ViewCoffee(this);

		viewAde = new ViewAde(this);
		viewBlended = new ViewBlended(this);
		viewSide = new ViewSide(this);

		logoState = new JPanel();
		setIconImage(Favicon.getFavi());
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
		add(imgLabel, "North");
		tabUI();
		pane = new JTabbedPane();
		pane.setUI(new UIStyle());
		pane.setFont(font);
		pane.add(generateHtml("커피", tabCss), viewCoffee);
		pane.add(generateHtml("에이드", tabCss), viewAde);
		pane.add(generateHtml("블렌디드", tabCss), viewBlended);
		pane.add(generateHtml("사이드", tabCss), viewSide);
		add(pane, BorderLayout.CENTER);

//=========================탭 끝 ===================================

		orderState = new JPanel();
		orderState.setLayout(new BorderLayout());
		order = new JLabel("     선택메뉴");
		order.setPreferredSize(new Dimension(600, 30));
		order.setOpaque(true);
		order.setBackground(Color.decode("#7b00a0"));
		order.setForeground(Color.white);
		order.setFont(font);
		// 메뉴 리스트========
		menuList = new JPanel(new GridLayout(0, 1));

		list = new JList<String>();
		list.setFont(font);
		list.addListSelectionListener(this);
		// 스크롤
		JScrollPane listScroll = new JScrollPane(list);
		// 기본 모델 객체(목록에 출력할 Data 를 가지고 있는 객체)
		model = new DefaultListModel<String>();
		c = new CModel();
//		model.addElement(c.getcName() + c.getcPrice());
		list.setModel(model);
		menuList.add(listScroll);

		// ========하단 주문 버튼 패널
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
		insertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		orderBtnPanel.add(insertBtn);
		orderBtnPanel.add(cancelBtn);

		// 메뉴 스테이트
		orderState.add(order, BorderLayout.NORTH);
		orderState.add(menuList, BorderLayout.CENTER);
		orderState.add(orderBtnPanel, BorderLayout.SOUTH);

		add(orderState, BorderLayout.SOUTH);
		setResizable(false);//사이즈 조절 불가
		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelBtn) {
			new MainFrame();
			dispose();
		} else if (e.getSource() == insertBtn) {
			int price = 0;
			int priceTot = 0;
			if (model.getSize() == 0) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요");
			} else {
				String[] a;
				ArrayList<String> mm = new ArrayList<>();
				String menu = null;
				String cmenu = null;
				String ctotal;
				conn = DBConnection.makeConnection();
				for (int i = 0; i < list.getModel().getSize(); i++) {
					System.out.println(model.get(i));
					a = model.get(i).split(":");
					menu = a[0];
					mm.add(menu);
					price = Integer.parseInt(a[1]);
					priceTot += price;
					System.out.println("=======" + menu + "====" + price);
				} // for
				int j = JOptionPane.showConfirmDialog(null,
						"총 갯수 : " + model.getSize() + " \n총 금액 : " + priceTot + "원\n주문하시겠습니까?", "주문확인",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (j == 0) {
					System.out.println(mm.toString());
					cmenu = mm.toString();
					ctotal = priceTot + "";
					String insertCafeSql = "insert into cafe_order values(cafeorder_seq.nextval,'" + cmenu + "','"
							+ ctotal + "',sysdate)";
					try {
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(insertCafeSql);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} // try~catch
					JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
					model.clear();
					System.out.println("총 가격 : " + priceTot);
				} // if j
			} // if
		} // if
	}// actionListner

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int selectedIndex = list.getSelectedIndex();
		if (selectedIndex >= 0) {// 선택된 Cell 이 있을 때
			int result = JOptionPane.showConfirmDialog(null,
					(selectedIndex + 1) + "번 : " + list.getSelectedValue() + "을 지우겠습니까?", "주문삭제",
					JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				// JList에 연결된 모델에서 해당 인덱스를 삭제
				model.remove(selectedIndex);
				System.out.println("지워진 Index값은" + (selectedIndex + 1) + " 번 입니다.");
			} else {
				System.out.println("선택된 INDEX 값은" + (selectedIndex + 1) + "번 입니다.");
			} // if
		} // if
	}// method override

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