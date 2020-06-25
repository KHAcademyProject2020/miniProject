package com.kh.project.mini.cafe.view.gui.alarm;

import javax.swing.JPanel;

import com.kh.project.mini.cafe.model.vo.Member;

// 생일 변경
public class UpdateBirthDay extends JPanel{
	private MainFrame mf;
	private Member me;
	private String id;
	
	public UpdateBirthDay(MainFrame mf, String id, Member me) {
		this.mf=mf;
		this.me=me;
		this.id=id;
		
		
		mf.add(this); //프레임에 현재패널을 넣는다.
	}
}
