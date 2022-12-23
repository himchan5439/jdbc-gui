package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataAdd extends MyFrame{

	JLabel nameL;
	JLabel addresL;
	JLabel phoneL;
	
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
		nameL = new JLabel("이름");
		addresL = new JLabel("주소");
		phoneL = new JLabel("전화번호");
		
		nameTF = new JTextField(10);
		addressTF = new JTextField(10);
		phoneTF = new JTextField(10);		
		
		addB = new JButton("추가");
		
		leftP = new JPanel(new GridLayout(3, 1, 3, 3));
		rightP = new JPanel(new GridLayout(3, 1, 3, 3));
	}

	private void addComp() {
		leftP.add(nameL);
		leftP.add(addresL);
		leftP.add(phoneL);

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
			String name = nameTF.getText();
			String address = addressTF.getText();
			String phone = phoneTF.getText();
			
			if(name.equals("") || address.equals("") || phone.equals("")) {
				super.eJop("빈칸이 있습니다", "오류");
			}else {
				dbM.query("INSERT INTO `"+databaseName+"`.`"+tableName+"` (`u_name`, `u_address`, `u_phone`) VALUES ('" + name + "', '" + address + "', '" + phone + "');");
				nameTF.setText("");
				addressTF.setText("");
				phoneTF.setText("");
			}
			
		});
	}

	public DataAdd(String databaseName, String tableName) {
		this.databaseName = databaseName;
		this.tableName = tableName;
		makeComp();
		addEvent();
		addComp();
		super.setFrame("데이터 추가", 240, 250);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
