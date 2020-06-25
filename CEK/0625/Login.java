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

public class Login extends JPanel{
	private MainFrame mf;
	private MemberController mc =new MemberController();
	
	private JTextField idText;
	private JPasswordField pwdText;
	
	public Login(MainFrame mf) {
		mf.setTitle("커피깡 - 로그인");
		this.mf=mf; //메인프레임 초기화
		
		//로그인 화면의 레이아웃 지정.
//		setBounds(700,300,300,400);
		setLayout(new GridLayout(0,1));
		
		JLabel label1 = new JLabel("아이디와 비밀번호를 입력해주세요.");
		add(label1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel idLabel = new JLabel("ID");
		add(idLabel);
		
		idText = new JTextField(10);
		idText.setBounds(100,10,160,25);
		add(idText);
		
		
		JLabel pwdLabel = new JLabel("PW");
		add(pwdLabel);
		
		pwdText = new JPasswordField(20);
		add(pwdText);		
		
		
		JButton button1 = new JButton("로그인");
		button1.setPreferredSize(new Dimension(45, 28));
		add(button1,"Center");
		add(button1);
	
		//버튼을 누르면, 버튼이벤트가 발생하고
		//로그인이 성공적으로 이루어지면, 현재프레임의 패널이 변경된다.
		button1.addActionListener(new GoLoginAfterPanelListener());
		

		//현재 패널을 메인프레임 적용(화면변경)
		mf.add(this);
	}
	
	class GoLoginAfterPanelListener implements ActionListener {
		// 로그인 버튼을 누르면
		// 성공적으로 로그인하면, 페이지가 넘어간다.
		@Override
		public void actionPerformed(ActionEvent e) {
			String inputID=idText.getText();
			String inputPW=mc.getPassWordToText(pwdText.getPassword());
			if(!mc.isDuplicatedMember(inputID)) {
				//등록되어있지 않은 아이디입력
				JOptionPane.showMessageDialog(null, "등록되어 있지 않은 아이디입니다!", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}else {
				//아이디 비밀번호 에 대응하는 멤버를 구한다. 
				Member me= mc.logIn(inputID, inputPW);
				
				if(me!=null) {
					//로그인 성공 다이얼로그 띄운다.
					String userName = me.getName();
					JOptionPane.showMessageDialog(null, userName + "님 반갑습니다!", "로그인 성공", JOptionPane.PLAIN_MESSAGE);
					
					//로그인 이후의 페이지로 이동.
					changePanel(new LoginAfter(mf, me));
				}else {
					//로그인 실패 다이얼로그 띄운다.
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다!\n다시입력해주세요!", "로그인 실패",
							JOptionPane.ERROR_MESSAGE);
				}
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