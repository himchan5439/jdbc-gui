package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataDelete extends MyFrame {

	JLabel deleteL;
	JTextField deleteTF;
	JButton deleteB;

	DbManagar dbM;
	String databaseName;
	String tableName;

	private void makeComp() {
		deleteL = new JLabel("삭제할 번호");

		deleteTF = new JTextField(10);

		deleteB = new JButton("삭제");

	}

	private void addComp() {
		super.add(deleteL, BorderLayout.WEST);
		super.add(deleteTF, BorderLayout.EAST);
		super.add(deleteB, BorderLayout.SOUTH);
	}

	private void addEvent() {
		dbM = new DbManagar();
		deleteB.addActionListener(e -> {
			String deleteNum = deleteTF.getText();

			if (deleteNum.equals("")) {
				super.eJop("빈칸이 있습니다", "오류");
			} else {
				dbM.query("DELETE FROM `" + databaseName + "`.`" + tableName + "` WHERE u_no = "+deleteNum+";");
				deleteTF.setText("");
			}

		});
	}

	public DataDelete(String databaseName, String tableName) {
		this.databaseName = databaseName;
		this.tableName = tableName;
		makeComp();
		addEvent();
		addComp();
		super.setFrame("데이터 삭제", 240, 100);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
