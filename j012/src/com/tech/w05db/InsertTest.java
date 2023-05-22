package com.tech.w05db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) throws SQLException {// stmt throws
		// db 접속 메소드
		Connection con = makeConnection();
		//INSERT
		String sql = "insert into bookinfo values('0005', '난 정말 JAVA를 공부한적이 없다구요', '오렌지미디어', '김리연', 28000)";
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);
		System.out.println("실행결과 : "+ count);
	}// main

	private static Connection makeConnection() {
		// db 접속 메소드
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
}// class