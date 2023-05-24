package com.tech.w05db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	// 자바에서 오라클 접속
	public static void main(String[] args) throws SQLException {// stmt throws
		// db 연결
		Connection con = makeConnection();
		// db의 bookinfo를 자바로 가져오기
		Statement stmt = con.createStatement(); // 커넥션객체를통해문장을만들어가겠다.
		String sql = "select * from bookinfo";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {//다음 열로 포인트를 옮겨라
			// 하나씩 받아서 출력
			String code = rs.getString("bb_code");
			String name = rs.getString("bb_name");
			String shop = rs.getString("bb_shop");
			String writer = rs.getString("bb_writer");
			int price = rs.getInt("bb_price");// int 타입
			//출력
			System.out.println(code+"::"+name+"::"+shop+"::"+writer+"::"+price+"원");
		} // while
	}// main

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
}// class