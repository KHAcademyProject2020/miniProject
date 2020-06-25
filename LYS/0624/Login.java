package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	
	private MainFrame mf;
	
	
	public Login(MainFrame mf) {
		mf.setTitle("커피깡 - 로그인");
		this.mf=mf; //메인프레임 초기화
		
		//로그인 화면의 레이아웃 지정.
//		setBounds(700,300,300,400);
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
		
		
		JButton button1 = new JButton("로그인");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		
		button1.addActionListener(new GoLoginAfterListener());

		//현재 패널을 메인프레임 적용(화면변경)
		mf.add(this);
		
	}
	//로그인 버튼 누르면 LoginAfter로 넘어가기
	class GoLoginAfterListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new LoginAfter(mf));
			
		}
	}
	
public void changePanel(JPanel panel) {
	mf.remove(this);
	mf.add(panel);
	mf.revalidate();
	mf.repaint();
	
	}	
}