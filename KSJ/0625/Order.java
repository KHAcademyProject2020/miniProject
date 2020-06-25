package com.kh.project.mini.cafe.view.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Order extends JPanel{
	public Order(MainFrame mf) {
		setBounds(700,300,300,400);
		
		mf.setTitle("커피깡 - 주문하기");
		
		setLayout(new GridLayout(5,5,20,20));

		JLabel label = new JLabel( getName() +"고객님 무엇을 주문하시겠습니까?");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		JButton drinkBtn = new JButton("Drink");
		JButton dessertBtn = new JButton("Dessert");
		
		JLabel label2 = new JLabel( getName() +"텅.. 주문한 메뉴가 없습니다!");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		add(drinkBtn,"Center");
		add(dessertBtn,"Center");
		
//		
//		drinkBtn.addActionListener(new GoOrderPageListener());
//		dessertBtn.addActionListener(new GoUserPageListener());
//		logoutbtn.addActionListener(new GoLogoutPageListener());
		mf.add(this);

	}
		
	}

