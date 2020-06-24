package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 메인 프레임: MainView
public class MainView extends JPanel{
	//필드 메인프레임 - null로 초기화
	private MainFrame mf; 
	
	// 매개변수 mf: MainFrame객체를 의미
	public MainView(MainFrame mf) {
		//메인프레임 이름 변경
		mf.setTitle("커피깡");
		this.mf=mf; //메인프레임 매개변수의 메인프레임으로 초기화.
		
		
		//로그인 이전화면 - 현재 레이아웃의 형태를 GridLayout으로 바꿈.
		setLayout(new GridLayout(5,5,20,20));
		
		//컴포넌트를 만든후, beforeLoginPanel에 컴포넌트를 넣는다.
		// => JLabel 컴포넌트 추가
		JLabel label = new JLabel("안녕하세요. 커피깡입니다*^^*");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		// => JButton 컴포넌트 추가
		JButton loginBtn = new JButton("로그인");
		JButton joinBtn = new JButton("회원가입");
		JButton exitBtn = new JButton("종료하기");
		
		add(loginBtn,"Center");
		add(joinBtn,"Center");
		add(exitBtn,"Center");
		
		// 버튼 ActionListener
		// 버튼을 클릭하면, 이벤트리스너로 인해서 -> 패널을 변경
		// 버튼과 버튼클릭할 때 발생하는 이벤트 리스너를 연결.
		
		//loginBtn 클릭 => 로그인 페이지로 이동하는 이벤트리스너 GoLoginPageListener
		loginBtn.addActionListener(new GoLoginPageListener()); 
		
		//joinBtn 클릭 => GoJoinPageListener
		joinBtn.addActionListener(new GoJoinPageListener());
		
		//exitBtn 클릭 => GoExitPageListener
		exitBtn.addActionListener(new GoExitPageListener());
		
		
		//현재 나(MainView)를 메인프레임에 넣는다.
		mf.add(this);
		
	}
	
	//내부클래스를 만든다. - ActionListener 생성
	class GoLoginPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new Login(mf)); //메인프레임을 건네주고 패널 변경.
		}
	}
	
	class GoJoinPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new Join(mf));//메인프레임을 건네주고 패널변경.
		}
	}
	
	class GoExitPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//클릭하면 Dialog 창과 함께 종료.
			JOptionPane.showMessageDialog(null, "커피깡 프로그램을 종료합니다!","프로그램 종료",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	//패널을 바꾸도록한다.
	public void changePanel(JPanel panel) {
		mf.remove(this); //현재 패널을  지운다.
		mf.add(panel); //매개변수 panel, 새로운 판넬로 변경. (화면변경)
		
		mf.revalidate();
		mf.repaint();
	}
}