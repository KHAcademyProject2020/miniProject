package com.kh.project.mini.cafe.view.gui.alarm;

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

public class Join extends JFrame{
	public Join() {
		setTitle("ȸ������");
		setBounds(700,300,300,400);
		setLayout(new GridLayout(0,1));
		
		JLabel label1 = new JLabel("Ŀ�Ǳ��� ������ �Ǿ��ּ���!");
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
		

		JLabel nameLabel = new JLabel("�̸�");
		add(nameLabel);
		JTextField nameText = new JTextField(10);
		nameText.setBounds(100,10,160,25);
		add(nameText);
		
		JLabel birthdayLabel = new JLabel("�������(8�ڸ�)");
		add(birthdayLabel);
		JTextField birthdayText = new JTextField(10);
		birthdayText.setBounds(100,10,160,25);
		add(birthdayText);
		
		JLabel addrassLabel = new JLabel("�ּ�");
		add(addrassLabel);
		JTextField addrassText = new JTextField(10);
		addrassText.setBounds(100,10,160,25);
		add(addrassText);
		
		
		try {
			setIconImage(ImageIO.read(new File("image/coffee.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JButton button1 = new JButton("ȸ������");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
		