package com.kh.project.mini.cafe.view.gui.alarm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.mini.cafa.model.vo.Member;
import com.kh.project.mini.cafe.view.gui.alarm.UpdatePassword.GoMyPageListener;

//주소변경 GUI
public class UpdateAddress extends JPanel {
	// 필드//
	private MainFrame mf;
	private Member me;
	private String id;

	private JComboBox<String> mcityOption;
	private JComboBox<String> cityOption;
	private String[] matchedCities;

	// id: LoginAgain에서 입력한 사용자의 아이디
	// me: id에 일치한 해시맵의 value(멤버 정보)
	// mf: 메인프레임
	public UpdateAddress(MainFrame mf, String id, Member me) {
		this.mf = mf;
		mf.setTitle("주소변경");
		this.id = id;
		this.me = me;

		// BorderLayout으로 한다.
		// 타이틀 라벨 (북)
		JLabel title = new JLabel("주소 변경");
		title.setHorizontalAlignment(JLabel.CENTER); // 가운데정렬
		add(title, "North");

		// 주소 변경 입력란(중앙)
		JPanel changeAddressPanel = new JPanel();
		changeAddressPanel.setLayout(new GridLayout(4, 1));

		// 1. 시 입력
		JPanel inputMcityPanel=new JPanel();
		JLabel mcityLabel = new JLabel("도시");
		inputMcityPanel.add(mcityLabel);
		
		// 콤보박스 (중복선택 불가/ 수정불가)
		String mcities[] = { "서울특별시", // 0
				"부산광역시", // 1
				"대구광역시", // 2
				"인천광역시", // 3
				"광주광역시", // 4
				"대전광역시", // 5
				"울산광역시", // 6
				"세종특별자치시", // 7
				"경기도", // 8
				"강원도", // 9
				"충청북도", // 10
				"충청남도", // 11
				"전라북도", // 12
				"전라남도", // 13
				"경상북도", // 14
				"경상남도", // 15
				"제주특별자치도"// 16
		};

		mcityOption = new JComboBox<String>(mcities);
		inputMcityPanel.add(mcityOption);
		changeAddressPanel.add(inputMcityPanel);
		
		
		// 2. 구/군
		JPanel inputCityPanel= new JPanel();
		JLabel cityLabel = new JLabel("구/군");
		inputCityPanel.add(cityLabel);
		
		cityOption = new JComboBox<String>(new String[] { "구/군 선택" });
		inputCityPanel.add(cityOption);
		changeAddressPanel.add(inputCityPanel);
		
		// 3. 상세주소 입력
		JLabel detailedAddressLabel = new JLabel("상세 주소를 입력해주세요.");
		detailedAddressLabel.setHorizontalAlignment(JLabel.CENTER);
		changeAddressPanel.add(detailedAddressLabel);
		
		// JTextField 컴포넌트
		JTextField detailedAddress = new JTextField(25);		
		changeAddressPanel.add(detailedAddress);
		
		
		add(changeAddressPanel, "Center");

		// (남)
		JButton submitButton = new JButton("주소 변경하기");
		submitButton.addActionListener(new GoUpdateAddressListener());
		add(submitButton, "Center");
		mf.add(this); // 프레임에 현재패널을 적용
		
		//돌아가기버튼생성 => MyPage메뉴 창띄우기
		JButton backButton = new JButton("이전페이지로 돌아가기");
		add(backButton, "Center");
		backButton.addActionListener(new GoMyPageListener());
		
		
		// 행정자치 (시) 선택할때 -> 구/군 콤보박스 내용이 달라짐.
		mcityOption.addActionListener(new ActionListener() {
			// 시를 선택하면, 행정자치시에 속하는 구를 cityOption에 나타낸다.

			@Override
			public void actionPerformed(ActionEvent e) {
				// mcityOption에서 선택한 행정자치 시
				JComboBox cb = (JComboBox) e.getSource(); // 선택한 대상에 대한 이벤트정보를 갖고온다.
				// 선택한 행정자치시 인덱스 정보를 갖고온다.

				int selectMcityIndex = cb.getSelectedIndex();
				
				System.out.println(selectMcityIndex);

				// 그에 따른 구/군 다르게한다.
				switch (selectMcityIndex) {
				case 0: // 서울 특별시
					matchedCities = new String[] { "종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구",
							"노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구",
							"송파구", "강동구" };
					break;

				case 1: // 부산광역시
					matchedCities = new String[] { "중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구",
							"금정구", "강서구", "연제구", "수영구", "사상구", "기장군" };
					break;

				case 2:// 대구광역시
					matchedCities = new String[] {
							"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군"
					};
					break;

				case 3:// 인천광역시
					matchedCities = new String[] {
							"중구", "동구", "남구", "연수구", "남동구","부평구", "계양구", "서구", "강화군", "옹진군", "미추홀구"
					};
					break;

				case 4:// 광주광역시
					matchedCities = new String[] {
							"동구", "서구", "남구", "북구", "광산구"
					};
					break;

				case 5:// 대전광역시
					matchedCities = new String[] {
							"동구", "중구", "서구", "유성구", "대덕구"
					};
					break;

				case 6:// 울산광역시
					matchedCities = new String[] {
							"중구", "남구", "동구", "북구", "울주군"
					};
					break;

				case 7:// 세종특별자치시 - 없음 ㅠㅠ
					matchedCities = new String[] {
							""
					};
					break;

				case 8: // 경기도
					matchedCities = new String[] {
							"수원시", "성남시", "의정부시", "안양시", "부천시", "광명시",
							"평택시", "동두천시", "안산시", "고양시", "과천시", "구리시",
							"남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시",
							"용인시", "파주시", "이천시", "안성시", "김포시", "화성시",
							"광주시", "양주시", "포천시", "여주시", "여주군", "연천군",
							"가평군", "양평군"
					};
					break;

				case 9:// 강원도
					matchedCities = new String[] {
							"춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시",
							"삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군",
							"철원군", "화천군", "양구군", "인제군", "고성군", "양양군"
					};
					break;

				case 10:// 충청북도
					matchedCities = new String[] {
							"청주시", "충주시", "제천시", "청원군", "보은군", "옥천군",
							"영동군", "진천군", "괴산군", "음성군", "단양군", "증평군"
					};
					break;

				case 11:// 충청남도
					matchedCities = new String[] {
							"천안시", "공주시", "보령시", "아산시", "서산시", "논산시",
							"계룡시", "당진시", "금산군", "연기군", "부여군", "서천군",
							"청양군", "홍성군", "예산군", "태안군", "당진군"
					};
					break;

				case 12:// 전라북도
					matchedCities = new String[] {
							"전주시", "군산시", "익산시", "정읍시", "남원시", "김제시",
							"완주군", "진안군", "무주군", "장수군", "임실군", "순창군",
							"고창군", "부안군"
					};
					break;

				case 13:// 전라남도
					matchedCities = new String[] {
							"목포시", "여수시", "순천시", "나주시", "광양시", "담양군",
							"곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군",
							"강진군", "해남군", "영암군", "무안군", "함평군", "영광군",
							"장성군", "완도군", "진도군", "신안군"
					};
					break;

				case 14:// 경상북도
					matchedCities = new String[] {
							"포항시", "경주시", "김천시", "안동시", "구미시", "영주시",
							"영천시", "상주시", "문경시", "경산시", "군위군", "의성군",
							"청송군", "영양군", "영덕군", "청도군", "고령군", "성주군",
							"칠곡군", "예천군", "봉화군", "울진군", "울릉군"
					};
					break;

				case 15:// 경상남도
					matchedCities = new String[] {
							"창원시", "마산시", "진주시", "진해시", "통영시", "사천시",
							"김해시", "밀양시", "거제시", "양산시", "의령군", "함안군",
							"창녕군", "고성군", "남해군", "하동군", "산청군", "함양군",
							"거창군", "합천군"
					};
					break;

				case 16:// 제주특별자치도
					matchedCities = new String[] {
							"제주시", "서귀포시"
					};
					break;
				}
				
				
				System.out.println(Arrays.toString(matchedCities));
				cityOption = new JComboBox<String>(matchedCities);
				System.out.println(cityOption.toString());

			}
		});
	}
	
	//돌아가기 버튼 누르면  MyPage로 넘어가기
		class GoMyPageListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(new MyPage(mf, me));
				
			}
		}
		
		
	// submitButton 버튼을 누르면 실행
	// 3개의 입력란이 모두 입력된 상태라면?
	class GoUpdateAddressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	// 패널 변경 - 주소 변경이 성공적으로 이뤄지면 LoginAfter페이지로 이동
	public void changePanel(JPanel panel) {
		mf.remove(this); // 현재 패널을 지우고
		mf.add(panel);// 새로운 패널로 바꾼다.
		mf.revalidate();
		mf.repaint();
	}
}
