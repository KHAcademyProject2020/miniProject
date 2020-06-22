package com.kh.project.mini.cafe.view.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_AfterLogin {
	public void runApp(String memberName) {
		// java.swing을 이용하여 gui를 구현한다.
		// JFrame 객체를 가지고온다. 
		JFrame frame =new JFrame("커피깡 - "+memberName+"님 환영합니다");
		
		//닫기 버튼을 누르면, 프로세스를 종료시키게끔한다.
		// EXIT_ON_CLOSE 는 상수이다.
		// 상수는 기본적으로 public static final 로 구성.
		// static변수이므로, 클래스이름.EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//레이아웃은 BorderLayout 으로 한다.
		
		
		//타이틀 패널을 만든다.
		JPanel titlePanel= new JPanel();
		
		//컴포넌트를 만든다 - 라벨
		JLabel title= new JLabel("커피깡 - "+memberName+"님");
		
		//패널에 컴포넌트를 넣는다.
		titlePanel.add(title);
		
		//프레임에 패널을 넣는다. - 위치: 북쪽
		frame.add(titlePanel, "North");
		
		
		
		//버튼 패널을 만든다.
		JPanel buttonPanel= new JPanel();
		
		// 컴포넌트인 버튼을 만든다.
		String [] buttonsStr= {"주문하기", "마이 페이지", "로그아웃"};
		JButton [] buttons= new JButton[buttonsStr.length];
		for(int i=0; i<buttons.length; i++)
			buttons[i]=new JButton(buttonsStr[i]);
		
		//버튼 패널에 컴포넌트(버튼)을 넣는다.
		for(int i=0; i<buttons.length; i++)
			buttonPanel.add(buttons[i]);
		
		//프레임(frame)의 중앙(Center)에 버튼패널(buttonPanel)을 넣는다.
		frame.add(buttonPanel, "Center");
		
		//크기 자동조절
		frame.pack();
		
		//gui 화면을 보이도록한다.
		frame.setVisible(true);
	}
}
