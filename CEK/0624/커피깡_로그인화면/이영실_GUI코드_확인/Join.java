package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

public class Join extends JPanel{
	//회원관리 컨트롤러 - 중복된 아이디가 있는지 확인.
	private MemberController mc= new MemberController();
	
	//
	
	public Join(MainFrame mf) {
		mf.setTitle("커피깡 - 회원가입");
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
		
		//비밀번호 입력
		JLabel pwdLabel = new JLabel("PW");
		add(pwdLabel);
		JPasswordField pwdText = new JPasswordField(20);
		add(pwdText);		
		
		//이름입력
		JLabel nameLabel = new JLabel("이름");
		add(nameLabel);
		JTextField nameText = new JTextField(10);
		nameText.setBounds(100,10,160,25);
		add(nameText);
		
		//생일입력
		JLabel birthdayLabel = new JLabel("생년월일(8자리)");
		add(birthdayLabel);
		JTextField birthdayText = new JTextField(10);
		birthdayText.setBounds(100,10,160,25);
		add(birthdayText);
		
		//주소입력
		JLabel addressLabel = new JLabel("주소");
		add(addressLabel);
		JTextField addressText = new JTextField(10);
		addressText.setBounds(100,10,160,25);
		add(addressText);
		
		//회원가입 버튼
		JButton joinButton = new JButton("회원가입");
		joinButton.setPreferredSize(new Dimension(45, 28));
		add(joinButton,"Center");
		add(joinButton);
		
		//버튼을 누르면 이벤트 리스너를 작동
		joinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//현재 가입되어있는 회원인지 확인한다.
				//MemberController를 이용.
				//입력한 아이디값을 가져온다.
				String id=idText.getText();
				
				//비밀번호 pwdText.getPassword() => char형 배열
				//char형 배열 => String으로 변환
				String pwd=mc.getPassWordToText(pwdText.getPassword());
				
				String name=nameText.getText();
				String birthday=birthdayText.getText();
				String address=addressText.getText();
				
				//일단 새로운 객체 생성.
				Member newMember= new Member(pwd, name, birthday, address);
				
				if(mc.isDuplicatedMember(id)) {
					//중복된 아이디 에러메시지를 보낸다.
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다! 다시 입력해주세요!", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
				}else {
					//성공 Dialog 
					JOptionPane.showMessageDialog(null, "커피깡에 오신걸 환영합니다! "+name+"님!", "회원가입 성공", JOptionPane.PLAIN_MESSAGE);
					
					//회원가입하기.
					mc.joinMember(id, newMember);
				}
			}
		});
	

	}

}