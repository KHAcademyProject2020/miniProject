package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.mini.cafa.model.vo.Member;

public class ShowMyOrders extends JPanel{
	private MainFrame mf;
	private Member me;
	
	//생성자
	public ShowMyOrders(MainFrame mf, Member me) {
		
		this.mf = mf;
		this.me = me;
		mf.setTitle(me.getName() + "님의 주문내역 ");
		
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel titleLabel= new JLabel(me.getName() + "님의 주문내역 입니다. ");
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //라벨을 가운데 정렬한다.
		add(titleLabel); //현재 패널안에 컴포넌트(타이틀-라벨)을 넣는다.
		
	}
}
