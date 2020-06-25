package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;
import com.kh.project.mini.cafe.view.gui.alarm.UpdatePassword.GoMyPageListener;

// �̸������ϴ� GUI
public class UpdateName extends JPanel{
	private MemberController mc = new MemberController();
	private MainFrame mf;
	private JTextField newNameInput;
	private String id;
	private Member me;
	
	public UpdateName(MainFrame mf, String id, Member me) {
		// �α��μ����Ҷ� ���̵�(HashMap- key)��
		// Member��ü(HashMap- value)��
		// �Ű������� �Ѵ�.
		this.mf=mf;
		this.id=id;
		this.me=me;
		
		mf.setTitle("�̸� ����");
		
		// 1. (��) �����ӿ� Ÿ��Ʋ ���� �ִ´�.
		JLabel title = new JLabel("�̸��� �������ּ���.");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, "North");

		// 2. (�߾�) �����ӿ� �׸��巹�̾ƿ��� �г��� �ִ´�.
		JPanel newNamePanel = new JPanel();
		newNamePanel.add(new JLabel("������ �̸� �Է�"));
		JTextField newNameInput= new JTextField(25);
		newNamePanel.add(newNameInput);
		this.add(newNamePanel, "Center");
		
		//3. (��) ��ư Ŭ��
		JButton submitButton= new JButton("�̸� ����");
		add(submitButton, "Center");
//		submitButton.addActionListener(new GoAfterLoginListener()); 
	
		//���ư����ư���� => MyPage�޴� â����
		JButton backButton = new JButton("������������ ���ư���");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
		
		mf.add(this);
		
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
				//���� �Է��� �̸�
				String newName= newNameInput.getText();
				if(newName.length() > 0) {
					//���� �Է��� �̸��� �ּ� 1���� �̻��̶��
					//�����޽���
					JOptionPane.showMessageDialog(null, "�̸� ���� ����!", "Ŀ�Ǳ� - �̸� ����(����)", JOptionPane.PLAIN_MESSAGE);
					mc.changeName(id,newName);
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


