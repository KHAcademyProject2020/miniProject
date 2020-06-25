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

// 생일 변경하는 GUI
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
		
		mf.setTitle("생일 변경");
		
		//1.(북) 프레임에 타이틀 라벨을 넣는다.
		JLabel title = new JLabel("생일을 변경해주세요");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,"North");
		
		//2.(중앙) 프레임에 그리드 레이아웃인 패널을 넣는다
		JPanel newBirthDayPanel = new JPanel();
		newBirthDayPanel.add(new Label("변경할 생일 입력"));
		JTextField newBirthDayInput= new JTextField(20);
		newBirthDayPanel.add(newBirthDayInput);
		this.add(newBirthDayPanel, "Center");
		
		//3.(남) 버튼클릭
		JButton submitButton = new JButton("생일변경");
		add(submitButton, "Center");
//		submitButton.addActionListener(new GoAfterLoginListener()); 
		
		
		//돌아가기버튼생성 => MyPage메뉴 창띄우기
		JButton backButton = new JButton("이전페이지로 돌아가기");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
				
		
		mf.add(this); //프레임에 현재패널을 넣는다.
	
	}
	//돌아가기 버튼 누르면  MyPage로 넘어가기
	class GoMyPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			changePanel(new MyPage(mf, me));
		}
	}
	
	class GoAfterLoginListener implements ActionListener {			
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//새로 입력한 생일
			String newBirthDay = newBirthDayInput.getText();
			if(newBirthDay.length() > 0) {
				//새로 입력한 생일이 최소 1글자 이상이라면
				//성공메시지
				JOptionPane.showMessageDialog(null, "생일 변경 성공!", "커피깡 - 생일 변경(성공)", JOptionPane.PLAIN_MESSAGE);
				mc.changeBirthday(id,newBirthDay);
				me = mc.updateMemberInfo(id);
				changePanel(new LoginAfter(mf, me));
			}else {
				//새로입력한 이름이 1글자 미만이라면
				JOptionPane.showMessageDialog(null, "최소 한 글자 이상의 이름을 입력해주세요!", "커피깡 - 이름 변경(실패)", JOptionPane.ERROR_MESSAGE);
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

