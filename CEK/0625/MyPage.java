package com.kh.project.mini.cafe.view.gui.alarm;



import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kh.project.mini.cafe.model.vo.Member;

//커피깡 마이페이지 GUI
public class MyPage extends JPanel {
	//메인프레임 안에 있는 패널을 바꿀 때사용.
	private MainFrame mf;
	
	// 생성자
	public MyPage(MainFrame mf, Member me) {
		// 프레임이름 : 커피깡 - 마이페이지
		mf.setTitle("커피깡 - 마이페이지");
		this.mf=mf;
		
		// 현재 패널의 레이아웃을 GridLayout으로 한다.
		setLayout(new GridLayout(5,5,20,20)); //5행 5열/ 간격 20씩
		
	
		//1. 라벨(타이틀) 컴포넌트
		JLabel titleLabel= new JLabel("마이 페이지");
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //라벨을 가운데 정렬한다.
		add(titleLabel); //현재 패널안에 컴포넌트(타이틀-라벨)을 넣는다.
		
		
		//2. 메뉴리스트 컴포넌트
		String[] menuStr= {
				"이전 페이지로 이동", 
				"쿠폰 및 주문내역 조회", 
				"비밀번호 변경", 
				"이름 변경",
				"생일 변경",
				"주소 변경",
				"회원 탈퇴"
		};
		
		JList<String> menu=new JList<String>(menuStr);
		
		// 리스트 메뉴는 한개만 선택할 수 있도록 설정한다.
		menu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
		//스크롤바를 만들고
		//스크롤바 컴포넌트 안에 menu를 넣는다.
		JScrollPane scroller= new JScrollPane(menu);
		scroller.setPreferredSize(new Dimension(300,300));//스크롤러의 크기를 지정한다.
		add(scroller); //패널에 스크롤러를 넣는다.
		
		//3. 선택한 메뉴를 확인
		JLabel selectTitle=new JLabel("선택한 메뉴");
		add(selectTitle);
		
		//선택한 메뉴 이름을 출력.
		JLabel selectMenuLabel= new JLabel();
		add(selectMenuLabel);
	
		
		//리스트를 선택하면, 발생하는 이벤트 리스너를 만든다.
		menu.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//리스트중 하나를 선택
				String selectedMenu= menu.getSelectedValue(); //선택한 리스트의 값을 추출.
				int selectIdx= menu.getSelectedIndex(); //선택한 리스트의 인덱스번호
				
				// 선택한 메뉴 이름을 selectMenuLabel 라벨에 표시
				selectMenuLabel.setText(selectedMenu);

				if(selectIdx==0) {
					//이전페이지로 이동 -> 로그인 이후 메뉴페이지(영실)
					changePanel(new LoginAfter(mf, me));
					
				}else if(selectIdx==1) {
					//주문 내역 조회
					changePanel(new ShowMyOrders(mf));
				}
				else {
					//selectIdx>=2 && selectIdx<=6
					String selectMenu= menu.getSelectedValue(); //선택된 메뉴 이름을 부른다.
					//로그인화면을 불러온다.
					changePanel(new LoginAgain(mf, selectedMenu,selectIdx));
				}
			}
		});
		
		// 현재패널을 메인프레임에 적용한다.
		mf.add(this);
	}
	
	//메소드
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		
		mf.revalidate();
		mf.repaint();
	}
}
