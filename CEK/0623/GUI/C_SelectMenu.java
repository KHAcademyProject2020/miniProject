package com.kh.project.mini.cafe.view.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_SelectMenu extends JFrame {
	public C_SelectMenu() {
		// 프레임을 생성한다.
		// 프레임 이름도 같이 설정.
		super("커피깡 - 커피 메뉴 선택");

		// 프레임을 닫으면, 프로세스가 닫아지게끔한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 기본레이아웃(BorderLayout)을 이용한다.
		// 동- 서- 남 -북 -중앙 => 5개의 영역에 패널/컴포넌트를 넣을 수 있다.

		// 라벨 //
		// 패널을 만든다.
		JPanel titlePanel = new JPanel();

		// 컴포넌트를 만든다.- JLabel을 이용
		JLabel title = new JLabel("< 커피 메뉴 >");

		// 컴포넌트를 패널에 넣는다.
		titlePanel.add(title);

		// 프레임에 패널을 넣는다. (북쪽)
		this.add(titlePanel, "North");

		// 체크 박스 //
		// 패널을 만든다.
		JPanel checkBoxPanel = new JPanel();

		// 컴포넌트를 만든다. - checkbox
		// checkbox -> 여러개 선택 가능
		// 단, 그룹으로 묶으면, 그룹내에서 한개만 선택가능

		// 객체배열 생성
		String[] coffeeMenuStr = { "아메리카노", "카라멜 마끼아또", "카페라떼", "디카페인", "아이스티", "콜드브루" };
		JCheckBox[] coffeeMenu = new JCheckBox[coffeeMenuStr.length];
		for (int i = 0; i < coffeeMenu.length; i++)
			coffeeMenu[i] = new JCheckBox(coffeeMenuStr[i]);

		// 컴포넌트를 패널에 넣는다.
		for (int i = 0; i < coffeeMenu.length; i++)
			checkBoxPanel.add(coffeeMenu[i]);

		// 패널을 frame에 넣는다 (중앙)
		add(checkBoxPanel, "Center");

		// 텍스트 //
		// 체크박스에 선택한 메뉴를 텍스트에 삽입
		// 패널 생성
		JPanel textPanel = new JPanel();

		// 컴포넌트 생성
		String emptyMenu = "텅...\n주문한 메뉴가 없습니다!!";
		JLabel text = new JLabel(emptyMenu);

		// 패널에 컴포넌트를 넣는다.
		textPanel.add(text);
		
		//프레임에 패널을 넣는다 (남쪽);
		this.add(textPanel, "South");
		

		// 체크박스 이벤트 리스너 //
		// 체크박스에서 선택한 메뉴를 text에 삽입한다.
		for (int i = 0; i < coffeeMenu.length; i++) {
			// 이벤터 리스너를 추가한다.
			coffeeMenu[i].addItemListener(new ItemListener() {

				// ItemListener은 추상클래스이기때문에
				// 정의되지 않은 메소드(itemStateChanged)를 오버라이딩하여 메소드의 본체를 완성시킨다.
				@Override
				public void itemStateChanged(ItemEvent e) {
					String result = "";
					int selectCnt = 0; // 선택한 체크박스 개수

					// 체크가 되어있는 것들만 선택
					for (int i = 0; i < coffeeMenu.length; i++) {
						// i번째 해당하는 버튼이 선택이 되었다면
						if (coffeeMenu[i].isSelected()) {
							// 선택한 메뉴를 result에 추가한다.
							// getText() => i번째 체크박스에 해당하는 텍스트값을 가져온다(커피메뉴 이름 문자열)
							result += coffeeMenu[i].getText() + "\n";
							selectCnt++;
						}
						//text 컴포넌트가 갖고 있는 텍스트 내용을 수정한다.
						text.setText(result);
						
					}
					
					// 아무것도 선택되어있지 않는다면 -> 텅... 주문한 메뉴가 없습니다! 출력
					if(selectCnt==0)
						text.setText(emptyMenu);
				}

			});
		}

		// 화면 크기 자동조정
		pack();
		// 프레임을 보이도록한다.
		setVisible(true);
	}
}
