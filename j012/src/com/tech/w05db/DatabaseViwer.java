package com.tech.w05db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DatabaseViwer extends JFrame {
	// swing 으로 db 컨트롤
	JTextField id, title, code, name, shop, writer, price;
	JButton privButton, nextButton, insertButton, deleteButton, clearButton;

	ResultSet rs;
	Statement stmt;

	public DatabaseViwer() throws SQLException {
		Connection con = makeConnection();
		String sql = "select * from bookinfo";
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);

		setTitle("디비컨트롤로로로로롤");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0, 2));
		add(new JLabel("Code"));
		add(code = new JTextField());
		add(new JLabel("Name"));
		add(name = new JTextField());
		add(new JLabel("Shop"));
		add(shop = new JTextField());
		add(new JLabel("Writer"));
		add(writer = new JTextField());
		add(new JLabel("Price"));
		add(price = new JTextField());

		privButton = new JButton("priv");
		privButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("priv");
				try {
					rs.previous();
					code.setText(rs.getString("bb_code"));
					name.setText(rs.getString("bb_name"));
					shop.setText(rs.getString("bb_shop"));
					writer.setText(rs.getString("bb_writer"));
					price.setText(rs.getString("bb_price"));
				} catch (SQLException e1) {
					System.out.println("자료없음");
//					e1.printStackTrace();
				} // try~catch
			}// method
		});// privButton
		nextButton = new JButton("next");
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("next");
				try {
					rs.next();
					code.setText(rs.getString("bb_code"));
					name.setText(rs.getString("bb_name"));
					shop.setText(rs.getString("bb_shop"));
					writer.setText(rs.getString("bb_writer"));
					price.setText(rs.getString("bb_price"));
				} catch (SQLException e1) {
					System.out.println("자료없음");
//					e1.printStackTrace();
				} // try~catch
			}// method
		});//
		insertButton = new JButton("insert");
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("insert");
				String ecode = code.getText();
				String ename = name.getText();
				String eshop = shop.getText();
				String ewriter = writer.getText();
				int eprice = Integer.parseInt(price.getText());

				String sql = "insert into bookinfo values(" + "'" + ecode + "'," + "'" + ename + "'," + "'" + eshop
						+ "'," + "'" + ewriter + "'," + "'" + eprice + "')";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					stmt.executeUpdate(sql);
					rs = stmt.executeQuery("select*from bookinfo");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // try~catch
			}// actionPerformed
		});// insertButton
		deleteButton = new JButton("delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete");
				String ecode = code.getText();
				String sql = "delete from bookinfo WHERE bb_code='" + ecode + "'";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					int cnt = stmt.executeUpdate(sql);
					System.out.println("삭제 갯수 : " + cnt);
					rs = stmt.executeQuery("select*from bookinfo");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // try~catch
			}// method
		});// deleteButton
		clearButton = new JButton("clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clear");
				code.setText("");
				name.setText("");
				shop.setText("");
				writer.setText("");
				price.setText("");
			}// method
		});// clearButton

		add(privButton);
		add(nextButton);
		add(insertButton);
		add(deleteButton);
		add(clearButton);
		setVisible(true);
		// dbms 종류
//		oracle, mysql mariadb, mssql, postgresql, mongodb, sqllite
	}// constructor

	private static Connection makeConnection() {
		Connection con = null;
		// 커넥션 완성

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "123456";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 실패 ");
			e.printStackTrace();
		} // try~catch
		return con;
	}// method

	public static void main(String[] args) throws SQLException {
		new DatabaseViwer();
	}// main
}// class