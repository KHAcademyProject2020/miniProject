package com.kh.project.mini.cafaLogin.componente.veiw;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class B_Login {
	public void doLogin() {
		JFrame frame = new JFrame("로그인");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		JTextField id = new JTextField(13);
			panel.add(new JLabel("ID"));
			panel.add(id);
		
		JPasswordField password = new JPasswordField();
		panel.add(new JLabel("PW"));
		panel.add(password);
			
		JButton btn = new JButton("로그인");
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(btn,BorderLayout.SOUTH);
		
		frame.pack();	
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
