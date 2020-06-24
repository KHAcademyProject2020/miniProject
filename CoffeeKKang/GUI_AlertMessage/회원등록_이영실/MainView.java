package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends JFrame{
	public MainView() {
		setTitle("커피깡");
		setBounds(700,300,300,400);
		
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel label = new JLabel("안녕하세요. 커피깡입니다*^^*");
		add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		JButton button1 = new JButton("로그인");
		JButton button2 = new JButton("회원가입");
		JButton button3 = new JButton("종료하기");
		
		add(button1,"Center");
		add(button2,"Center");
		add(button3,"Center");
		
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();	
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Join();	
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setResizable(true);	
			}
		});
		
		
	
		try {
			setIconImage(ImageIO.read(new File("image/coffee.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
