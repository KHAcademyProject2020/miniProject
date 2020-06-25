package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

// 이름변경하는 GUI
public class UpdateName extends JPanel{
	private MemberController mc = new MemberController();
	private MainFrame mf;
	
	public UpdateName(MainFrame mf, String id, Member member) {
		// 로그인성공할때 아이디(HashMap- key)와
		// Member객체(HashMap- value)를
		// 매개변수로 한다.
		this.mf=mf;
		mf.setTitle("커피깡 - 이름 변경");

		// 1. (북) 프레임에 타이틀 라벨을 넣는다.
		JLabel title = new JLabel("이름을 변경해주세요~");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, "North");

		// 2. (중앙) 프레임에 그리드레이아웃인 패널을 넣는다.
		JPanel newNamePanel = new JPanel();
		newNamePanel.add(new JLabel("변경할 이름 입력"));
		JTextField newNameInput= new JTextField(25);
		newNamePanel.add(newNameInput);
		this.add(newNamePanel, "Center");
		
		//3. (남) 버튼 클릭
		JButton submitButton= new JButton("이름 변경");
		this.add(submitButton, "South");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//새로 입력한 이름
				String newName= newNameInput.getText();
				if(newName.length()>0) {
					//새로 입력한 이름이 최소 1글자 이상이라면
					//성공메시지
					JOptionPane.showMessageDialog(null, "이름 변경 성공!", "커피깡 - 이름 변경(성공)", JOptionPane.PLAIN_MESSAGE);
					mc.changeName(id,newName);
				}else {
					//새로입력한 이름이 1글자 미만이라면
					JOptionPane.showMessageDialog(null, "최소 한 글자 이상의 이름을 입력해주세요!", "커피깡 - 이름 변경(실패)", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
