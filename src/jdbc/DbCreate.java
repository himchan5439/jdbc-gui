package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreate {
	private Connection con;
	private Statement stmt;
	final String url = "jdbc:mysql://localhost/?" + "CharacterEncoding=UTF-8&" + "serverTimezone=UTC&"
			+ "allowPublicKeyRetrieval=true&" + "allowLoadLocalInfile=true&" + "allowMultiQueries=true";
	final String id = "root";
	final String pw = "qwasqaws12";
//	final String pw = "1234";
	String databaseName = "data" ;

	private void DbConnect() {
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("Connect!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void DatabaseCreate() {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("drop database if exists " + databaseName);
			System.out.println("기존에 있던 데이터 베이스를 삭제했습니다.");
			stmt.execute("create database if not exists " + databaseName);
			System.out.println("데이터 베이스를 만들었습니다.");
			new TableCtrate(stmt, databaseName);
			new DbDataInsert(stmt, databaseName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public DbCreate() {
		DbConnect();
		DatabaseCreate();
	}

	public static void main(String[] args) {
		new DbCreate();
	}
}

class TableCtrate {
	public TableCtrate(Statement stmt, String databaseName) throws SQLException {
		stmt.execute("CREATE TABLE IF NOT EXISTS `" + databaseName + "`.`user` (\n" + "  `u_no` INT NOT NULL,\n"
				+ "  `u_name` VARCHAR(15) NULL,\n" + "  `u_id` VARCHAR(15) NULL,\n" + "  `u_pw` VARCHAR(11) NULL,\n"
				+ "  `u_birth` VARCHAR(15) NULL,\n" + "  `division` INT(11) NULL,\n" + "  `t_no` INT(11) NULL,\n"
				+ "  PRIMARY KEY (`u_no`)\n" + ")");
		System.out.println("테이블을 만들었습니다.");
	}
}

class DbDataInsert {
	public DbDataInsert(Statement stmt, String databaseName) throws SQLException {
		stmt.execute("insert into `" + databaseName + "`.`user` values (1, '김성재', 'a', 'abc213', '1999-09-09', 1, 0);\n"
				+ "insert into `" + databaseName + "`.`user` values (2, '김준우', 'b', 'www33', '1999-01-01', 2, 1);\n"
				+ "insert into `" + databaseName + "`.`user` values (3, '박힘찬', 'c', 'qwer11', '2000-01-03', 1, 2);\n"
				+ "insert into `" + databaseName + "`.`user` values (4, '이재훈', 'd', 'www33', '2001-03-16', 1, 3);");
		System.out.println("데이터가 입력되었습니다.");
	}
}
