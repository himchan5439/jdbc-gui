package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MainUi extends MyFrame {
	JTextField inputF;
	JButton dbCreateB;
	JButton dbDrobB;
	JButton tbCreateB;
	JButton tbDeleteB;
	JButton dataB;
	JButton frExitB;
	
	DbManagar dbM;
	
	String dataBaseName, tableName;

	private void makeComp() {
		inputF = new JTextField();
		dbCreateB = new JButton("데이터 베이스 생성");
		dbDrobB = new JButton("데이터 베이스 삭제");
		tbCreateB = new JButton("테이블 생성");
		tbDeleteB = new JButton("테이블 삭제");
		dataB = new JButton("테이블 관리");
		frExitB = new JButton("종료");
	}

	private void addComp() {
		super.setLayout(new GridLayout(7, 1, 5, 5));

		super.add(inputF);
		super.add(dbCreateB);
		super.add(dbDrobB);
		super.add(tbCreateB);
		super.add(tbDeleteB);
		super.add(dataB);
		super.add(frExitB);
	}
	
	private void addEvent() {
		dbM = new DbManagar();
		dbCreateB.addActionListener(e -> {
			dataBaseName = inputF.getText();
			dbM.query("CREATE SCHEMA IF NOT EXISTS `"+dataBaseName+"` DEFAULT CHARACTER SET utf8 ;");
		});
		
		dbDrobB.addActionListener(e -> {
			dataBaseName = inputF.getText();
			dbM.query("DROP SCHEMA IF EXISTS `"+dataBaseName+"` ;");
		});
		
		tbCreateB.addActionListener(e -> {
			tableName = inputF.getText();			
			dbM.query("CREATE TABLE IF NOT EXISTS `"+dataBaseName+"`.`"+ tableName+"` (\n"
					+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\n"
					+ "  `u_name` VARCHAR(15) NULL,\n"
					+ "  `u_address` VARCHAR(15) NULL,\n"
					+ "  `u_phone` VARCHAR(11) NULL,\n"
					+ "  PRIMARY KEY (`u_no`))");
		});
		
		tbDeleteB.addActionListener(e -> {
			tableName = inputF.getText();
			dbM.query("DROP TABLE IF EXISTS `"+dataBaseName+"`.`"+tableName+"` ;");
		});
		
		dataB.addActionListener(e -> {
			new DataManagar(dataBaseName);
		});
		
		frExitB.addActionListener(e -> {
			super.iJop("프로그램이 종료됩니다.", "종료");
			System.exit(0);
		});
	}

	public MainUi() {
		makeComp();
		addEvent();
		addComp();
		super.setFrame("DB 관리 프로그램", 200, 560);
	}
	
	public static void main(String[] args) {
		new MainUi();
	}

}
