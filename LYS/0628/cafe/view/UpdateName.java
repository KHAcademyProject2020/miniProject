package com.kh.project.mini.cafe.view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;
import com.kh.project.mini.cafe.view.UpdatePassword.GoMyPageListener;

//�̸������ϴ� GUI
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
		System.out.println("id: "+ this.id+ "me:"+ this.me);
		
		mf.setTitle("�̸�����");
		
		// 1. (��) �����ӿ� Ÿ��Ʋ ���� �ִ´�.
		JLabel title = new JLabel("������ �̸��� �Է����ּ���");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, "North");

		// 2. (�߾�) �����ӿ� �׸��巹�̾ƿ��� �г��� �ִ´�.
		JPanel newNamePanel = new JPanel();
		newNamePanel.add(new JLabel("������ �̸��Է�"));
		JTextField newNameInput= new JTextField(10);
		newNamePanel.add(newNameInput);
		this.add(newNamePanel, "Center");
		
	
		
		//3. (��) ��ư Ŭ��
		JButton submitButton= new JButton("�̸������ϱ�");
		add(submitButton, "Center");
		submitButton.addActionListener(new GoAfterLoginListener()); 
	
		//���ư����ư���� => MyPage�޴� â����
		JButton backButton = new JButton("������������ ���ư���");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
		
		mf.add(this);
		
	}
	
	
	class GoMyPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new MyPage(mf, me));
			
		}
	}
	
	class GoAfterLoginListener implements ActionListener {			
		//���� �Է��� �̸�
			@Override
			public void actionPerformed(ActionEvent e) {
				String newName= newNameInput.getText();
				if(newName.length() > 0) {
					//���� �Է��� �̸��� �ּ� 1���� �̻��̶��
					//�����޽���
					JOptionPane.showMessageDialog(null, "�̸� ���� ����!", "�̸� ����(����)", JOptionPane.PLAIN_MESSAGE);
					mc.changeName(id,newName);
					changePanel(new LoginAfter(mf, me));
				}else {
					JOptionPane.showMessageDialog(null, "�ּ� �� ���� �̻��� �̸��� �Է����ּ���!", "�̸� ����(����)", JOptionPane.ERROR_MESSAGE);
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

