package com.kiosk.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.db.DBConnection;
import com.kiosk.main.Favicon;

public class AdminList extends JFrame {
	Font font = new Font("나눔바른고딕", Font.BOLD, 15);
	DefaultTableModel model; // 데이터 저장부분
	Object ob[][] = new Object[0][4]; // 데이터 표시(행X) 열만 나오게 설정
	String str[] = { "주문번호", "주문메뉴", "총 가격", "주문날짜" }; // 컬럼명

	public AdminList() {
		setTitle("C A F E::Kiosk::Admin");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 900);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#7b00a0"));
		// 파비콘 설정
		setIconImage(Favicon.getFavi());

		// 패널
		JPanel l = new JPanel();
		l.setBackground(Color.decode("#7b00a0"));
		l.setPreferredSize(new Dimension(0, 50));
		JPanel panel = new JPanel();
		JLabel label = new JLabel("주문목록");
		label.setPreferredSize(new Dimension(500, 50));
		label.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
		label.setForeground(Color.white);
		panel.add(label);
		panel.setBackground(Color.decode("#7b00a0"));

		model = new DefaultTableModel(ob, str); // 1)데이저 저장[][], 2)컬럼명
		JTable table = new JTable(model);// table=new JTable(ob,str);

		table.setEnabled(false);
		table.setFont(font);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(500, 700));
		// ================================================

		Connection conn = DBConnection.makeConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 1) 실행할 SQL 문장 작성
			String sql = "select * from cafe_order ORDER BY tnum desc"; // 지역변수 선언
			pstmt = conn.prepareStatement(sql);
			System.out.println("pstmt : " + pstmt);
			rs = pstmt.executeQuery(); // select문장
			System.out.println("rs : " + rs);

			// cafe_order테이블에서 불러오기
			while (rs.next()) {
				String num = rs.getString("tnum");
				String menu = rs.getString("totalmenu");
				String price = rs.getString("totalprice");
				String date = rs.getString("tdate");
				// Object[]을 만들어 저장하여 model에 추가하면 JTable에서 결과를 확인 가능
				Object data[] = { num, menu, price, date };
				model.addRow(data);
				System.out.println(num + ", " + menu + ", " + price); // 콘솔 출력
			}
		} catch (Exception e) {
			System.out.println("select() 실행 오류 : " + e);
		} finally {
			try { // 프로그램 종료전에 메모리에 DB연동 부분 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.exit(0);
			}
		}
		// ================================================
		panel.add(scroll);

		add(l, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setResizable(false);// 사이즈 조정 못하게
		setVisible(true);
	}// constructor
}//