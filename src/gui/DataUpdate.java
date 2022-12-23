package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataUpdate extends MyFrame{

	JLabel updateL;
	JLabel nameL;
	JLabel addresL;
	JLabel phoneL;
	
	JTextField updateTF;
	JTextField nameTF;
	JTextField addressTF;
	JTextField phoneTF;
	
	JButton addB;
	
	JPanel leftP;
	JPanel rightP;

	DbManagar dbM;
	
	String databaseName;
	String tableName;

	private void makeComp() {
		updateL = new JLabel("수정할 번호");
		nameL = new JLabel("이름");
		addresL = new JLabel("주소");
		phoneL = new JLabel("전화번호");
		
		updateTF = new JTextField(10);
		nameTF = new JTextField(10);
		addressTF = new JTextField(10);
		phoneTF = new JTextField(10);		
		
		addB = new JButton("추가");
		
		leftP = new JPanel(new GridLayout(4, 1, 3, 3));
		rightP = new JPanel(new GridLayout(4, 1, 3, 3));
	}

	private void addComp() {
		leftP.add(updateL);
		leftP.add(nameL);
		leftP.add(addresL);
		leftP.add(phoneL);

		rightP.add(updateTF);
		rightP.add(nameTF);
		rightP.add(addressTF);
		rightP.add(phoneTF);
		
		super.add(leftP, BorderLayout.WEST);
		super.add(rightP, BorderLayout.EAST);
		super.add(addB, BorderLayout.SOUTH);
	}

	private void addEvent() {		
		dbM = new DbManagar();
		addB.addActionListener(e -> {
			String updateNum = updateTF.getText();
			String name = nameTF.getText();
			String address = addressTF.getText();
			String phone = phoneTF.getText();
			
			if(updateNum.equals("") || name.equals("") || address.equals("") || phone.equals("")) {
				super.eJop("빈칸이 있습니다", "오류");
			}else {
				dbM.query("UPDATE `"+databaseName+"`.`"+tableName+"` SET `u_name` = '"+name+"', `u_address` = '"+address+"', `u_phone` = '"+phone+"' WHERE `u_no` = '"+updateNum+"';");
				nameTF.setText("");
				addressTF.setText("");
				phoneTF.setText("");
			}
			
		});
	}

	public DataUpdate(String databaseName, String tableName) {
		this.databaseName = databaseName;
		this.tableName = tableName;
		makeComp();
		addEvent();
		addComp();
		super.setFrame("데이터 수정", 240, 270);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
