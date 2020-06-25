package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	public Login() {
		setTitle("로그인");
		setBounds(700,300,300,400);
		setLayout(new GridLayout(0,1));
		
		JLabel label1 = new JLabel("아이디와 비밀번호를 입력해주세요.");
		add(label1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel idLabel = new JLabel("ID");
		add(idLabel);
		
		JTextField idText = new JTextField(10);
		idText.setBounds(100,10,160,25);
		add(idText);
		
		
		JLabel pwdLabel = new JLabel("PW");
		add(pwdLabel);
		
		JPasswordField pwdText = new JPasswordField(20);
		add(pwdText);		
		

		try {
			setIconImage(ImageIO.read(new File("image/coffee.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JButton button1 = new JButton("로그인");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
