package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

public class LoginAfter extends JPanel{
	
	private MemberController mc = new MemberController();
	private MainFrame mf;
	private Member me;
			
	public LoginAfter(MainFrame mf, Member member) {
		mf.setTitle("커피깡 - 회원님");
		this.mf=mf;
		this.me=member;
		
		String userName= member.getName(); //로그인 성공한 유저이름
		setBounds(700,300,300,400);
		
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel label = new JLabel( userName +"고객님 환영합니다");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		JButton orderBtn = new JButton("주문하기");
		JButton userPageBtn = new JButton("마이페이지");
		JButton logoutbtn = new JButton("로그아웃");
		
		add(orderBtn,"Center");
		add(userPageBtn,"Center");
		add(logoutbtn,"Center");
		
		orderBtn.addActionListener(new GoOrderPageListener());
		userPageBtn.addActionListener(new GoUserPageListener());
		logoutbtn.addActionListener(new GoLogoutPageListener());
		
		mf.add(this);
	}
	//내부 클래스 생성
	class GoOrderPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//changePanel(new (mf)); 수진씨 주문하기 페이지로 넘어가기
			
		}
	}
	
	class GoUserPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//은강씨 회원정보 페이지로 넘어가기
			changePanel(new MyPage(mf, me)); //(은강)
		}
	}
	
	//로그아웃 버튼 클릭시 이벤트 생성
	class GoLogoutPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION);
			//창 닫기, 예, 아니오 버튼 클릭시 이벤트 생성
			if(result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);	
				} else if(result == JOptionPane.YES_OPTION) {
					//Yes 버튼을 누르면 메인화면으로 돌아가기
					setVisible(false);
					
					
					changePanel(new MainView(mf));
					setVisible(true);
				} 
			}
		}

	
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.revalidate();
		mf.repaint();
		
	}

}