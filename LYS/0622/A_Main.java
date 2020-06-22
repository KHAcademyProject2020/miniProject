package com.kh.project.mini.cafaLogin.componente.veiw;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class A_Main {
	public void doMain() {
		JFrame frame = new JFrame("커피깡");
		
		frame.setLayout(new GridLayout(3,3));
		
		frame.setBounds(550,300,300,500);
		
		
		frame.setLayout(new GridLayout(3, 3, 50, 50));
		
		frame.add(new JButton("로그인"));	
		frame.add(new JButton("회원가입"));
		frame.add(new JButton("종료하기"));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
