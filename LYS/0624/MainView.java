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
		
		mf.setTitle("Ŀ�Ǳ�");
		this.mf = mf;
	
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel label = new JLabel("�ȳ��ϼ���. Ŀ�Ǳ��Դϴ�*^^*");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		JButton loginBtn = new JButton("�α���");
		JButton joinBtn = new JButton("ȸ������");
		JButton exitBtn = new JButton("�����ϱ�");
		
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
			JOptionPane.showMessageDialog(null, "Ŀ�Ǳ� ���α׷��� �����մϴ�!","���α׷� ����",JOptionPane.PLAIN_MESSAGE);
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
	