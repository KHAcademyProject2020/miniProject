package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainView extends JPanel{
	
	private MainFrame mf;
	
	public MainView(MainFrame mf){
		
		mf.setTitle("커피깡");
		this.mf = mf;
	
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel label = new JLabel("안녕하세요. 커피깡입니다*^^*");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		JButton loginBtn = new JButton("로그인");
		JButton joinBtn = new JButton("회원가입");
		JButton exitBtn = new JButton("종료하기");
		
		add(loginBtn,"Center");
		add(joinBtn,"Center");
		add(exitBtn,"Center");
		
		
		loginBtn.addActionListener(new GoLoginPageListener());
		
		joinBtn.addActionListener(new GoJoinPageListener());
		
		exitBtn.addActionListener(new GoExitPageListener());
		
		mf.add(this);
	}
	
	class GoLoginPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new Login(mf));
		}
	}	
	
	class GoJoinPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new Join(mf));
			
		}
	}
	
	class GoExitPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "커피깡 프로그램을 종료합니다!","프로그램 종료",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);	
		}
	}
	
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.revalidate();
		mf.repaint();
	}
}
	
