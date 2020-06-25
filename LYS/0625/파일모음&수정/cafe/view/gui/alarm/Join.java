package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;

public class Join extends JPanel{
	
	private MemberController mc = new MemberController();
	
	public Join(MainFrame mf) {
		mf.setTitle("ȸ������");
		setBounds(700,300,300,400);
		setLayout(new GridLayout(0,1));
		
		
		JLabel label1 = new JLabel("Ŀ�Ǳ��� ������ �Ǿ��ּ���!");
		label1.setHorizontalAlignment(JLabel.CENTER);
		add(label1);
		
		
		JLabel idLabel = new JLabel("ID");
		add(idLabel);
		JTextField idText = new JTextField(10);
		idText.setBounds(100,10,160,25);
		add(idText);
		
		
		JLabel pwdLabel = new JLabel("PW");
		add(pwdLabel);
		JPasswordField pwdText = new JPasswordField(20);
		add(pwdText);		
		

		JLabel nameLabel = new JLabel("�̸�");
		add(nameLabel);
		JTextField nameText = new JTextField(10);
		nameText.setBounds(100,10,160,25);
		add(nameText);
		
		
		JLabel birthdayLabel = new JLabel("�������(8�ڸ�)");
		add(birthdayLabel);
		JTextField birthdayText = new JTextField(10);
		birthdayText.setBounds(100,10,160,25);
		add(birthdayText);
		
		
		JLabel addrassLabel = new JLabel("�ּ�");
		add(addrassLabel);
		JTextField addrassText = new JTextField(10);
		addrassText.setBounds(100,10,160,25);
		add(addrassText);
		
		
		JButton button1 = new JButton("ȸ������");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//ȸ������ ������ ����
				try{
					BufferedWriter MemberList = new BufferedWriter(new FileWriter("C:/data/test/ȸ�����.txt",true));
					MemberList.write(idText.getText()+"/");
					MemberList.write(pwdLabel.getText()+"/");
					MemberList.write(nameText.getText()+"/");
					MemberList.write(birthdayText.getText()+"/");
					MemberList.write(addrassText.getText()+"\r\n");
					MemberList.close();
					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
					}
				}	
			});	
		//ȸ������ �����մϴ� Ȯ���� ������ �α��� â���� �Ѿ��
	}
}
//				String id = idText.getText();
//				
//				String pwd=mc.getPassWordToText(pwdText.getPassword());
//				
//				String name = nameText.getText();
//				String birthday = birthdayText.getText();
//				String addrass = addrassText.getText();
//				
//				
//				Member newMember= new Member(pwd, name, birthday, addrass);
//				
//				if(mc.isDuplicatedMember(id)) {
//					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�! �ٽ� �Է����ּ���!", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
//				}else {
//					JOptionPane.showMessageDialog(null, "Ŀ�Ǳ��� ���Ű� ȯ���մϴ�! "+name+"��!", "ȸ������ ����", JOptionPane.PLAIN_MESSAGE);
//					mc.joinMember(id, newMember);
//					setVisible(false);
//					setVisible(true);
//			
//				}
//		
//				//ȸ������ �Ϸ� �� Ȯ�� Ŭ�� �� â����ǰ� �α��� â(����)���� �ٽ� �Ѿ�� 
//			}
//		
//	}

		