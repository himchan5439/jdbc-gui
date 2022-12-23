package gui;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbManagar {
	private Connection con;
	private Statement stmt;
	final String url = "jdbc:mysql://localhost/?" + "CharacterEncoding=UTF-8&" + "serverTimezone=UTC&"
			+ "allowPublicKeyRetrieval=true&" + "allowLoadLocalInfile=true&" + "allowMultiQueries=true";
	final String id = "root";
	final String pw = "qwasqaws12";
	
	public DbManagar() {
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 완료.");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getdata(String query) {
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)+" "+rs.getObject(4));
			}
			showMessageDialog(null, "요청이 성공적으로 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			showMessageDialog(null, "요청이 성공적으로 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void query(String query){
		try {
			stmt.execute(query);
			System.out.println("query문 실행 완료.");
			showMessageDialog(null, "요청이 성공적으로 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			showMessageDialog(null, "요청이 성공적으로 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}	
	}
}
