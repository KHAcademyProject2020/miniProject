package com.kh.project.mini.cafe.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import com.kh.project.mini.cafe.model.vo.Member;

public class ShowMyOrders extends JPanel{
	private MainFrame mf;
	private Member me;
	
	//������
	public ShowMyOrders(MainFrame mf, Member me) {
		this.mf = mf;
		this.me = me;
		String name = me.getName();
		
		mf.setTitle(name + "���� �ֹ����� ");
		setLayout(new GridLayout(5,5,20,20));
		
		JLabel label= new JLabel(name + "���� �ֹ����� �Դϴ�. ");
		label.setHorizontalAlignment(JLabel.CENTER); //���� ��� �����Ѵ�.
		add(label); //���� �гξȿ� ������Ʈ(Ÿ��Ʋ-��)�� �ִ´�.
//		System.out.println("myorder : " + me.getOrderHistory());
		
		
		//�ֹ������� ǥ���� �ؽ�Ʈ �ָ���
		JTextArea textArea = new JTextArea(30, 30);
		textArea.setText(me.getOrderHistory());
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JPanel resultPanel = new JPanel();
		resultPanel.add(textArea);
		add(resultPanel, "Center");
		
		//����Ʈ �޴��� �Ѱ��� ������ �� �ְ� �Ѵ�.
		JLabel OrderList = new JLabel("�ֱ� �ֹ���� (��������)");
		resultPanel.add(OrderList);
		add(resultPanel, "Center");
		
		 
		 
		
		

		
		//�ֹ���Ͽ� ���� ��ũ�ѹ� ����
		JScrollPane scroller= new JScrollPane();
		scroller.setPreferredSize(new Dimension(300,300));//��ũ�ѷ��� ũ�⸦ �����Ѵ�.
		add(scroller); //�гο� ��ũ�ѷ��� �ִ´�.
		
		
		
		
		
		//���ư��� ��ư ����
		JButton backButton = new JButton("������������ ���ư���");
		add(backButton,"South");
		backButton.addActionListener(new GoMyPageListener());
		
		mf.add(this);
		
	}
	

	//���ư��� ��ư�� ������ MyPage�� ���ư��� �߰�
	class GoMyPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new MyPage(mf,me));
			
		}
	}
	
	public void changePanel(JPanel panel) {
		mf.remove(this); // ���� �г��� �����
		mf.add(panel); // �ٸ� �гη� ����ȭ���� ����
		mf.revalidate();
		mf.repaint();
	}

}