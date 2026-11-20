package week11.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://10.240.142.230:3307/test";
		String username = "stdUser";
		String password = "wkvmtlf2"; //자프실2
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB 연결 성공");
			
			String selectSQL = "select * from student";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectSQL);
			
			System.out.println(rs); // 파싱해줘야함
			
			while (rs.next()) {
				int no = rs.getInt("no");
				String dept = rs.getString("dept");
				String stdID = rs.getString("stdID");
				String name = rs.getString("name");
				
				System.out.printf("No: %d, 학과: %s, 학번: %s, 이름: %s \n", no, dept, stdID, name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 정보를 확인하세요");
		}
		
		
	}

}
