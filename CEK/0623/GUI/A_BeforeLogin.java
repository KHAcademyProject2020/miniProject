package com.kh.project.mini.cafe.view.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 부모클래스: JFrame
// 자식클래스: A_BeforeLogin
public class A_BeforeLogin extends JFrame {

	// 기본생성자 호출
	public A_beforeLogin() {
		//부모 클래스 호출
		// 프레임 이름을 커피깡으로 한다.
		super("커피깡");
		
		//프레임을 닫으면 프로세스도 같이 종료할 수 있도록한다.
		//닫기버튼을 누르면 프로세스도 종료한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//프레임의 위치와 크기 초기화한다.
		//x좌표 y좌표 가로길이 세로길이
//		int XPos=300;
//		int YPos=200;
//		int frameWidth=500;
//		int frameHeight=500;
//		setBounds(XPos,YPos, frameWidth, frameHeight);

		
//		panel.setLayout(null); // => 기본레이아웃도 없애버린다.
		// 레이아웃을 설정하지 않으면 기본적으로 BorderLayout으로 설정한다.
		//기본 레이아웃 -BorderLayout 을 이용한다.
		
		
		//컴포넌트 만들기1 - 라벨 
		//패널을 생성한다.  -  패널배치 (북)
		JPanel titlePanel = new JPanel();
		JLabel title=new JLabel("< 커피깡! >");
		
		// 패널(titlePanel)안에 컴포넌트(title)를 넣는다.
		titlePanel.add(title); 
		
		//프레임(this)에 패널(titlePanel)을 넣는다 / (BorderLayout의 특징)
		this.add(titlePanel, "North");
	
		
		
		//컴포넌트 만들기 2 - 버튼
		//패널을 생성한다 - 패널배치 (중앙)
		JPanel buttonPanel= new JPanel();
		
		String [] buttonStrs= {"로그인", "회원가입", "종료하기"};
		JButton[] buttons= new JButton[buttonStrs.length]; //객체배열 -null 로 초기화

		//객체배열의 원소에 버튼객체를 가리키도록한다. 
		for(int i=0; i<buttonStrs.length; i++) {
			buttons[i] =new JButton(buttonStrs[i]);
		}
	
		//버튼3개 - 패널안에 컴포넌트를 넣는다.
		for(int i=0; i<buttons.length; i++)
			buttonPanel.add(buttons[i]);
		
		// 프레임(this)안에 패널(buttonPanel)을 넣는다.
		add(buttonPanel);
		
		//프레임 크기 자동조절
		pack();
		
		// 프레임을 보여준다.
		setVisible(true);
	}

}
