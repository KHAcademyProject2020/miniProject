package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;
import com.kh.project.mini.cafe.view.gui.alarm.UpdateName.GoMyPageListener;

// ���� �����ϴ� GUI
public class UpdateBirthDay extends JPanel{
	private MemberController mc = new MemberController();
	private MainFrame mf;
	private JTextField newBirthDayInput;
	private Member me;
	private String id;

	
	public UpdateBirthDay(MainFrame mf, String id, Member me) {
		this.mf=mf;
		this.me=me;
		this.id=id;
		
		mf.setTitle("���� ����");
		
		//1.(��) �����ӿ� Ÿ��Ʋ ���� �ִ´�.
		JLabel title = new JLabel("������ �������ּ���");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,"North");
		
		//2.(�߾�) �����ӿ� �׸��� ���̾ƿ��� �г��� �ִ´�
		JPanel newBirthDayPanel = new JPanel();
		newBirthDayPanel.add(new Label("������ ���� �Է�"));
		JTextField newBirthDayInput= new JTextField(20);
		newBirthDayPanel.add(newBirthDayInput);
		this.add(newBirthDayPanel, "Center");
		
		//3.(��) ��ưŬ��
		JButton submitButton = new JButton("���Ϻ���");
		add(submitButton, "Center");
//		submitButton.addActionListener(new GoAfterLoginListener()); 
		
		
		//���ư����ư���� => MyPage�޴� â����
		JButton backButton = new JButton("������������ ���ư���");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
				
		
		mf.add(this); //�����ӿ� �����г��� �ִ´�.
	
	}
	//���ư��� ��ư ������  MyPage�� �Ѿ��
	class GoMyPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new MyPage(mf, me));
		}
	}
	
	class GoAfterLoginListener implements ActionListener {			
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//���� �Է��� ����
			String newBirthDay = newBirthDayInput.getText();
			if(newBirthDay.length() > 0) {
				//���� �Է��� ������ �ּ� 1���� �̻��̶��
				//�����޽���
				JOptionPane.showMessageDialog(null, "���� ���� ����!", "Ŀ�Ǳ� - ���� ����(����)", JOptionPane.PLAIN_MESSAGE);
				mc.changeBirthday(id,newBirthDay);
				me = mc.updateMemberInfo(id);
				changePanel(new LoginAfter(mf, me));
			}else {
				//�����Է��� �̸��� 1���� �̸��̶��
				JOptionPane.showMessageDialog(null, "�ּ� �� ���� �̻��� �̸��� �Է����ּ���!", "Ŀ�Ǳ� - �̸� ����(����)", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	
	
	
	
	
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);

		mf.revalidate();
		mf.repaint();
	}
}

