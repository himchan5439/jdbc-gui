package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

public class DataManagar extends MyFrame {

	JTextField inputF;
	JButton dataAddB;
	JButton dataDeleteB;
	JButton dataUpdateB;
	JButton dataSelectB;

	DbManagar dbM;
	
	String databaseName;

	private void makeComp() {
		inputF = new JTextField();
		dataAddB = new JButton("데이터 추가");
		dataDeleteB = new JButton("데이터 삭제");
		dataUpdateB = new JButton("데이터 수정");
		dataSelectB = new JButton("데이터 보기");
	}

	private void addComp() {
		super.setLayout(new GridLayout(5, 1, 5, 5));

		super.add(inputF);
		super.add(dataAddB);
		super.add(dataDeleteB);
		super.add(dataUpdateB);
		super.add(dataSelectB);
	}

	private void addEvent() {
		dataAddB.addActionListener(e -> {
			String tableName = inputF.getText();
			if(tableName.equals("")){
				super.eJop("테이블 이름을 입력하세요", "오류");
			}else {
				new DataAdd(databaseName, tableName);				
			}
		});

		dataDeleteB.addActionListener(e -> {
			String tableName = inputF.getText();
			if(tableName.equals("")){
				super.eJop("테이블 이름을 입력하세요", "오류");
			}else {
				new DataDelete(databaseName, tableName);				
			}
		});
		
		dataUpdateB.addActionListener(e -> {			
			String tableName = inputF.getText();
			if(tableName.equals("")){
				super.eJop("테이블 이름을 입력하세요", "오류");
			}else {
				new DataUpdate(databaseName, tableName);				
			}
		});
		
		dataSelectB.addActionListener(e -> {
			dbM = new DbManagar();
			String tableName = inputF.getText();
			if(tableName.equals("")){
				super.eJop("테이블 이름을 입력하세요", "오류");
			}else {
				dbM.getdata("select * from `"+databaseName+"`.`"+tableName+"`");
			}
		});
	}

	public DataManagar(String databaseName) {
		this.databaseName = databaseName;
		makeComp();
		addEvent();
		addComp();
		super.setFrame("DB 관리 프로그램", 200, 400);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
