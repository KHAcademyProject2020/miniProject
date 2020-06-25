package com.kh.project.mini.cafe.view.gui.alarm;



import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kh.project.mini.cafa.model.vo.Member;
import com.kh.project.mini.cafe.view.gui.alarm.Login.GoLoginAfterListener;

//Ŀ�Ǳ� ���������� GUI
public class MyPage extends JPanel {
	//���������� �ȿ� �ִ� �г��� �ٲ� �����.
	private MainFrame mf;
	private Member me;
	
	// ������
	public MyPage(MainFrame mf, Member me) {
		// �������̸� : Ŀ�Ǳ� - ����������
		mf.setTitle("����������");
		this.mf = mf;
		this.me = me;
		
		// ���� �г��� ���̾ƿ��� GridLayout���� �Ѵ�.
		setLayout(new GridLayout(5,5,20,20)); //5�� 5��/ ���� 20��
		
	
		//1. ��(Ÿ��Ʋ) ������Ʈ
		String name= me.getName();
		JLabel titleLabel= new JLabel( name + " ���� ������ �Դϴ�.");
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //���� ��� �����Ѵ�.
		add(titleLabel); //���� �гξȿ� ������Ʈ(Ÿ��Ʋ-��)�� �ִ´�.
		
		
		//2. �޴�����Ʈ ������Ʈ
		String[] menuStr= { 
				"�ֹ����� ��ȸ", 
				"��й�ȣ ����", 
				"�̸� ����",
				"���� ����",
				"�ּ� ����",
				"ȸ�� Ż��"
		};
		
		JList<String> menu = new JList<String>(menuStr);
		
		// ����Ʈ �޴��� �Ѱ��� ������ �� �ֵ��� �����Ѵ�.
		JPanel resultPanel = new JPanel();
		JLabel choiceMenu = new JLabel("�޴��� Ŭ���Ͻø� �ٷ� �̵��մϴ�.");
		
		resultPanel.add(choiceMenu);
		add(resultPanel, "Center");
		
		//��ũ�ѹٸ� �����
		//��ũ�ѹ� ������Ʈ �ȿ� menu�� �ִ´�.
		JScrollPane scroller= new JScrollPane(menu);
		scroller.setPreferredSize(new Dimension(300,300));//��ũ�ѷ��� ũ�⸦ �����Ѵ�.
		add(scroller); //�гο� ��ũ�ѷ��� �ִ´�.
		
		menu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		//����Ʈ�� �����ϸ�, �߻��ϴ� �̺�Ʈ �����ʸ� �����.
		menu.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//����Ʈ�� �ϳ��� ����
				String selectedMenu= menu.getSelectedValue(); //������ ����Ʈ�� ���� ����.
				int selectIdx= menu.getSelectedIndex(); //������ ����Ʈ�� �ε�����ȣ
				
				// ������ �޴� �̸��� selectMenuLabel �󺧿� ǥ��
//				selectMenuLabel.setText(selectedMenu);

				if(selectIdx == 0) {
					//�ֹ� ���� ��ȸ
					changePanel(new ShowMyOrders(mf,me));
				}
				else if(selectIdx == 1){
					changePanel(new UpdatePassword(mf,selectedMenu, me));
					//selectIdx>=2 && selectIdx<=6
					//String selectMenu= menu.getSelectedValue(); //���õ� �޴� �̸��� �θ���.
					//�α���ȭ���� �ҷ��´�.
					//changePanel(new LoginAgain(mf, selectedMenu,selectIdx));
				}
				else if(selectIdx == 2) {
					changePanel(new UpdateName(mf,selectedMenu, me));
				}
				else if(selectIdx == 3) {
					changePanel(new UpdateBirthDay(mf,selectedMenu, me));
				}
				else if(selectIdx == 4) {
					changePanel(new UpdateAddress(mf,selectedMenu, me));
				}
				else if(selectIdx == 5) {
//					changePanel(new (mf,selectedMenu, me));
				}
				else if(selectIdx == 6) {
					JOptionPane.showConfirmDialog(null, "���� Ż���Ͻðڽ��ϱ�?", "Membership Withdrawal", JOptionPane.YES_NO_OPTION);
					if(selectIdx == JOptionPane.YES_OPTION) {
						
					} else {
						changePanel(new LoginAfter(mf,me));
					}
				}
			}
		});
		
		//���ư����ư���� => LoginAfter�޴� â����
		JButton button = new JButton("������������ ���ư���");
		add(button, "Center");
		button.addActionListener(new GoLoginAfterListener());
		
		// �����г��� ���������ӿ� �����Ѵ�.
		mf.add(this);
	}
	
	//���ư��� ��ư ������  LoginAfter�� �Ѿ��
	class GoLoginAfterListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new LoginAfter(mf, me));
		}
	}
	
	
	//�޼ҵ�
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.revalidate();
		mf.repaint();
	}

}
