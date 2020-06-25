package com.kh.project.mini.cafe.view.gui.alarm;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame(){
		// 메인 프레임 위치(700,300)
		// 메인 프레임 크기(가로:300, 세로: 400)
		setBounds(700,300,300,400);
		
		// MainView 패널에 메인 프레임(this)을 전달.
		new MainView(this); //초기 화면 -로그인 이전
//		new MyPage(this); //MyPage패널에 프레임을 전달한다. - 마이페이지
		
		
		
		//커피 아이콘을 프레임에 붙여준다.
		try {
			setIconImage(ImageIO.read(new File("image/coffee.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 메인프레임을 보이도록 한다.
		setResizable(false); //메인프레임의 크기조정 불가능.
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
