package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	public void setFrame(String title, int width, int height) {
		super.setTitle(title);
		super.setSize(width, height);
		super.setVisible(true);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void eJop(String title, String text) {
		new JOptionPane().showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
	}

	public void iJop(String title, String text) {
		new JOptionPane().showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
