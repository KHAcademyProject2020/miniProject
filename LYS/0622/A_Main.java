package com.kh.project.mini.cafaLogin.componente.veiw;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class A_Main {
	public void doMain() {
		JFrame frame = new JFrame("Ŀ�Ǳ�");
		
		frame.setLayout(new GridLayout(3,3));
		
		frame.setBounds(550,300,300,500);
		
		
		frame.setLayout(new GridLayout(3, 3, 50, 50));
		
		frame.add(new JButton("�α���"));	
		frame.add(new JButton("ȸ������"));
		frame.add(new JButton("�����ϱ�"));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
