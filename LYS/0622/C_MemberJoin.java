package com.kh.project.mini.cafaLogin.componente.veiw;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class C_MemberJoin {
	public void doMemberJoin() {
		JFrame frame = new JFrame("ȸ������");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,7));
		
		JTextField id = new JTextField(13);
			panel.add(new JLabel("ID"));
			panel.add(id);
		
		JPasswordField password = new JPasswordField();
		panel.add(new JLabel("PW"));
		panel.add(password);
		
		JTextField name = new JTextField(13);
		panel.add(new JLabel("�̸�"));
		panel.add(name);
		
		JTextField brd = new JTextField(13);
		panel.add(new JLabel("�������(8�ڸ�)"));
		panel.add(brd);
		
		JTextField address = new JTextField(13);
		panel.add(new JLabel("�ּ�"));
		panel.add(address);
			
		JButton btn = new JButton("ȸ������");
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(btn,BorderLayout.SOUTH);

		
		frame.pack();	
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
