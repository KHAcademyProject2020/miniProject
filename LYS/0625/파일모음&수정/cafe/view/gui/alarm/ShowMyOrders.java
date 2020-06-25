package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.mini.cafa.model.vo.Member;

public class ShowMyOrders extends JPanel{
	private MainFrame mf;
	private Member me;
	
	//������
	public ShowMyOrders(MainFrame mf, Member me) {
		
		this.mf = mf;
		this.me = me;
		mf.setTitle(me.getName() + "���� �ֹ����� ");
		
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel titleLabel= new JLabel(me.getName() + "���� �ֹ����� �Դϴ�. ");
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //���� ��� �����Ѵ�.
		add(titleLabel); //���� �гξȿ� ������Ʈ(Ÿ��Ʋ-��)�� �ִ´�.
		
	}
}
