package com.tech.w05db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect2 {
	// 자바에서 오라클 접속
	public static void main(String[] args) {
		// db 연결
		Connection con = makeConnection();
	}// main

	private static Connection makeConnection() {
		Connection con = null;
		// 커넥션 완성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "123456";
		//db와의 통신 회선이 생김ㅇㅇ
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