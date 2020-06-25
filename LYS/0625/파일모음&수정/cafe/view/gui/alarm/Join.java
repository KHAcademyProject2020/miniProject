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
		mf.setTitle("회원가입");
		setBounds(700,300,300,400);
		setLayout(new GridLayout(0,1));
		
		
		JLabel label1 = new JLabel("커피깡의 가족이 되어주세요!");
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
		

		JLabel nameLabel = new JLabel("이름");
		add(nameLabel);
		JTextField nameText = new JTextField(10);
		nameText.setBounds(100,10,160,25);
		add(nameText);
		
		
		JLabel birthdayLabel = new JLabel("생년월일(8자리)");
		add(birthdayLabel);
		JTextField birthdayText = new JTextField(10);
		birthdayText.setBounds(100,10,160,25);
		add(birthdayText);
		
		
		JLabel addrassLabel = new JLabel("주소");
		add(addrassLabel);
		JTextField addrassText = new JTextField(10);
		addrassText.setBounds(100,10,160,25);
		add(addrassText);
		
		
		JButton button1 = new JButton("회원가입");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//회원가입 데이터 저장
				try{
					BufferedWriter MemberList = new BufferedWriter(new FileWriter("C:/data/test/회원명단.txt",true));
					MemberList.write(idText.getText()+"/");
					MemberList.write(pwdLabel.getText()+"/");
					MemberList.write(nameText.getText()+"/");
					MemberList.write(birthdayText.getText()+"/");
					MemberList.write(addrassText.getText()+"\r\n");
					MemberList.close();
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					}
				}	
			});	
		//회원가입 축하합니다 확인을 누르면 로그인 창으로 넘어가기
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
//					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다! 다시 입력해주세요!", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
//				}else {
//					JOptionPane.showMessageDialog(null, "커피깡에 오신걸 환영합니다! "+name+"님!", "회원가입 성공", JOptionPane.PLAIN_MESSAGE);
//					mc.joinMember(id, newMember);
//					setVisible(false);
//					setVisible(true);
//			
//				}
//		
//				//회원가입 완료 후 확인 클릭 후 창종료되고 로그인 창(이전)으로 다시 넘어가기 
//			}
//		
//	}

		