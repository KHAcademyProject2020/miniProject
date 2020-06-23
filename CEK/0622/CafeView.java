package com.kh.project.mini.cafe.view;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

public class CafeView {
	
// 로그인 - 이영실//
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public CafeView() {
		mc.inputRoot(); // 관리자계정 딱한번만 삽입.
	}

	// 로그인 아웃 상태 /////////////////////////////////////////////////////////////////
	// 로그인 페이지 - 로그아웃 상태
	public void mainMenu() {
		System.out.println("==== 안녕하세요 커피깡 입니다  =====");

		int menuNum = 0;
		while (menuNum != 3) {
			System.out.println("\n로그아웃 상태");
			System.out.println(" ****** 메인 메뉴 ****** ");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");

			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
			case 1: // 회원가입
				memberJoinMenu();
				break;
			case 2:// 로그인
				memberLogin();
				break;
			case 3:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	// 로그인
	public void memberLogin() {
		while (true) {
			System.out.println(" ****** 로그인  ****** ");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();

			Member me = mc.logIn(id, pwd);

			// 비밀번호가 null이 아니라면...
			if (me != null) {
				String name = me.getName();
				System.out.println(name + "님, 환영합니다!");
				mainMenu(name);
				break;

			} else {
				System.out.println("틀린 아이디 또는 비밀번호 입니다. 다시 입력해주세요");
			}
		}
	}

	// 회원가입
	public void memberJoinMenu() {
		while (true) {
			System.out.println(" ****** 회원 가입 ****** ");
			// 최소 한글자 이상입력해야한다.
			System.out.print("아이디 : ");
			String id = sc.nextLine();

			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();

			System.out.print("이름 : ");
			String name = sc.nextLine();

			System.out.print("생년월일 8자리 : ");
			String birthday = sc.nextLine();

			System.out.print("주소 : ");
			String addrass = sc.nextLine();

			Member m = new Member(pwd, name, birthday, addrass);
			if (mc.memberJoinMenu(id, m)) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요");
			}
		}
	}

	// 로그인 성공 /////////////////////////////////////////////////////////////////
	// 로그인 페이지 - 로그인 성공 (로그인 상태)
	public void mainMenu(String memberName) {
		// findMember 멤버를 찾아는다.
		System.out.println("\n[ " + memberName + "님 환영합니다 ]");

		int menu;
		do {
			System.out.println("1. 주문하기");
			System.out.println("2. 나의 정보 조회");
			System.out.println("3. 로그아웃");
			System.out.println("4. 등록된 회원 조회");
			System.out.print("메뉴>> ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				orderMenu();
				break;

			case 2:
				goMyInfo();
				return;

			case 3:
				System.out.println("로그아웃을 합니다.");
				return;

			case 4:
				showMembers();
				break;

			default:
				System.out.println("잘못된 메뉴입니다! 다시입력해주세요!");
			}
			System.out.println();
		} while (true);
	}

////////////////////////////////////////////////////////////////////////////////
// 주문하기 - 김수진//
	public void orderMenu() {

		Scanner sc = new Scanner(System.in);

		int menuNum = 0;
		do {
			System.out.println("****** 주문 하기 ******");
			System.out.println("어떤 메뉴를 고르실래요?");
			System.out.println("1. Drink");
			System.out.println("2. Dessert");
			System.out.println("3. 이전으로");
			System.out.println("4. 종료");
			// 1.(회원이름)님 무엇을 주문하시겠습니까?
			// 2.커피
			// 3.디저트
			// 4."텅.." 주문한 메뉴가 없습니다!

			System.out.println();
			System.out.print("메뉴 번호 입력: ");
			menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
			case 1:
				orderCoffee();
				break;
			case 2:
				orderDessert();
				break;
			case 3:
				return;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		} while (menuNum != 4);
	}

	public void orderCoffee() {

		int menuNum = 0;
//		char menuNum = 0;
		Scanner sc = new Scanner(System.in);
		boolean coffee_bool = true;
		boolean tea_bool = true;
		boolean shot_bool = true;
		boolean sirup_bool = true;

		while (true) {
			System.out.println("무슨 종류로 하시겠습니까?");
			System.out.println("1. Coffee");
			System.out.println("2. Tea");

//			char menu = sc.next().charAt(0);
			menuNum = Integer.parseInt(sc.nextLine());

			if (menuNum == 1) {
				System.out.println("Coffee 선택");
				String coffee = "";
				String sirup_ok = "";
				String shot_ok = "";

				while (coffee_bool) {
					coffee_bool = false;
					System.out.println("무슨커피를 드시겠습니까?");
					System.out.println("1. 아메리카노");
					System.out.println("2. 카페라떼");
					System.out.println("3. 카페모카");
					System.out.println("4. 바닐라라떼");
					System.out.println("5. 카라멜마끼아토");

//					char cf = sc.next().charAt(0);
					int cf = Integer.parseInt(sc.nextLine());

					if (cf == 1) {
						coffee = "아메리카노";
					} else if (cf == 2) {
						coffee = "카페라떼";
					} else if (cf == 3) {
						coffee = "카페모카";
					} else if (cf == 4) {
						coffee = "바닐라라떼";
					} else if (cf == 5) {
						coffee = "카라멜마끼아토";
					} else {
						System.out.println("1,2,3,4,5 중 다시 선택해주세요!");
						coffee_bool = true;
					}
				} // coffee선택 while끝

				while (shot_bool) {
					shot_bool = false;
					System.out.println("샷 추가하시겠습니까? Y/N");
					char shot = sc.next().charAt(0);
					if (shot == 'y' || shot == 'Y') {
						shot_ok = "샷 추가";
					} else if (shot == 'n' || shot == 'N') {
						shot_ok = "";
					} else {
						System.out.println("다시 선택해주세요!");
						shot_bool = true;
					}

				} // 샷추가 while 끝

				while (sirup_bool) {
					sirup_bool = false;

					System.out.println("시럽 추가하시겠습니까? Y/N");
					char sirup = sc.next().charAt(0);
					if (sirup == 'y' || sirup == 'Y') {
						sirup_ok = "샷 추가";
					} else if (sirup == 'n' || sirup == 'N') {
						sirup_ok = "";
					} else {
						System.out.println("다시 선택해주세요!");
						sirup_bool = true;
					}
				} // 시럽선택 끝

				System.out.println("주문하신 음료는" + shot_ok + sirup_ok + coffee + "입니다.");
				break;
			} else if (menuNum == 2) {
				String tea = "";
				while (tea_bool) {
					tea_bool = false;

					while (true) {
						System.out.println(" 무슨 차를 드시겠습니까? ");
						System.out.println("1. 얼그레이");
						System.out.println("2. 캐모마일 ");
						System.out.println("3. 페퍼민트 ");
						System.out.println("4. 녹차");

						System.out.println();
						System.out.print("메뉴 번호 입력 : ");
						menuNum = Integer.parseInt(sc.nextLine());

						int cf = sc.nextInt();

						if (cf == 1) {
							tea = "얼그레이";
						} else if (cf == 2) {
							tea = "캐모마일";
						} else if (cf == 3) {
							tea = "페퍼민트";
						} else if (cf == 4) {
							tea = "녹차";
						} else {
							System.out.println("차 종류를 다시 선택해주세요!");
							tea_bool = true;
						}
					} // 티 선택 끝

				}
			} // if문 끝
		} // while문 끝
	}

	public void orderDessert() {

		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		boolean cake_bool = true;
		boolean cookie_bool = true;
		while (true) {
			System.out.println("무슨 종류로 하시겠습니까?");
			System.out.println("1. 케이크");
			System.out.println("2. 쿠키");

			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			menuNum = Integer.parseInt(sc.nextLine());

			if (menuNum == 1) {
				String cake = "";
				while (cake_bool) {
					cake_bool = false;

					while (true) {
						System.out.println(" 무슨 종류로 하시겠습니까? ");
						System.out.println("1. 초콜릿케이크");
						System.out.println("2. 치즈케이크 ");
						System.out.println("3. 티라미수케이크 ");
						System.out.println("4. 당근케이크");

						System.out.println();
						System.out.print("메뉴 번호 입력 : ");
						menuNum = Integer.parseInt(sc.nextLine());

						int cf = sc.nextInt();

						if (cf == 1) {
							cake = "초콜릿케이크";
						} else if (cf == 2) {
							cake = "치즈케이크";
						} else if (cf == 3) {
							cake = "티라미수케이크";
						} else if (cf == 4) {
							cake = "당근케이크";
						} else {
							System.out.println("케이크 종류를 다시 선택해주세요!");
							cake_bool = true;
						}
					}
				}
			} else if (menuNum == 2) {
				String cookie = "";
				while (cookie_bool) {
					cookie_bool = false;

					while (true) {
						System.out.println(" 무슨 종류로 하시겠습니까? ");
						System.out.println("1. 오트밀쿠키");
						System.out.println("2. 라즈베리쿠키 ");
						System.out.println("3. 오레오쿠키 ");
						System.out.println("4. 버터쿠키");

						System.out.println();
						System.out.print("메뉴 번호 입력 : ");
						menuNum = Integer.parseInt(sc.nextLine());

						int cf = sc.nextInt();

						if (cf == 1) {
							cookie = "오트밀쿠키";
						} else if (cf == 2) {
							cookie = "라즈베리쿠키";
						} else if (cf == 3) {
							cookie = "오레오쿠키";
						} else if (cf == 4) {
							cookie = "버터쿠키";
						} else {
							System.out.println("쿠키 종류를 다시 선택해주세요!");
							cookie_bool = true;
						}
					} // 티 선택 끝

				}
			} // if문 끝
		}
	}

////////////////////////////////////////////////////////////////////////////////
/// 나의정보 조회 //	
	public void goMyInfo() {
		int menu;
		do {
			System.out.println("1. 쿠폰 및 주문내역 조회");
			System.out.println("2. 비밀번호 변경");
			System.out.println("3. 이름변경");
			System.out.println("4. 생일변경");
			System.out.println("5. 주소변경");

			System.out.println("6. 회원탈퇴");
			System.out.println("7. 뒤로");
			System.out.print("메뉴>> ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				showMyOrderAndCoupon(); // 쿠폰 및 주문내역 조회
				break;
			case 2:
				changeMyPassword(); // 비밀번호 변경
				break;
			case 3:
				changeMyName(); // 이름 변경
				break;

			case 4:
				changeMyBirth(); // 생일변경
				break;

			case 5:
				changeMyAddress(); // 주소변경
				break;

			case 6:
				dropOutMember(); // 회원탈퇴
				return;

			case 7:
				System.out.println("이전페이지로 돌아갑니다.");
				return;

			default:
				System.out.println("잘못된 메뉴입니다! 다시입력해주세요!");
			}
			System.out.println();
		} while (true);
	}

	// 쿠폰 및 주문내역 조회
	public void showMyOrderAndCoupon() {

	}

	// 비밀번호 변경
	public void changeMyPassword() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();

			// 내가 입력한 비밀번호
			System.out.print("현재 비밀번호 : ");
			String oldPw = sc.nextLine();

			Member me = mc.logIn(id, oldPw);
			if (me != null) {
				System.out.print("새로운 비밀번호 : ");
				String newPw = sc.nextLine();
				mc.changePassword(id, newPw);
				System.out.println("비밀번호 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("비멀번호가 일치하지 않습니다. 다시 입력해주세요!");
			}
		}
	}

	// 이름 변경
	public void changeMyName() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			Member me = mc.logIn(id, password); // id에 대응하는 Member객체를 받는다.
			if (me != null) {
				System.out.println("현재 설정된 이름 : " + me.getName());
				System.out.print("변경할 이름 : ");
				String newName = sc.nextLine();

				mc.changeName(id, newName);
				System.out.println("이름 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}

	// 생일 변경
	public void changeMyBirth() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			Member me = mc.logIn(id, password);
			if (me != null) {
				String birthday = me.getBirthday(); // 현재 내생일을 갖고온다.
				System.out.println("현재 설정된 생일 : " + birthday);
				System.out.print("변경할 생일 : ");
				String newBirthday = sc.nextLine();

				mc.changeBirthday(id, newBirthday);
				System.out.println("생일 변경에 성공했습니다.");
				break;
			} else {

				System.out.println("생일 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}

	// 주소변경
	public void changeMyAddress() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();

			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			Member me = mc.logIn(id, password);
			if (me != null) {
				String address = me.getAddress();
				System.out.println("현재 설정된 주소 : " + address);
				System.out.print("변경할 주소 : ");
				String newAddress = sc.nextLine();

				mc.changeAddress(id, newAddress);
				System.out.println("주소 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("주소 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}

	// 회원탈퇴
	public void dropOutMember() {
		// 아이디 비밀번호를 입력하고
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		// 아이디 비밀번호가 일치
		Member me = mc.logIn(id, password);
		if (me != null) {
			char ans;
			System.out.print("정말 탈퇴하시겠습니까?: ");
			ans = sc.nextLine().toLowerCase().charAt(0);
			switch (ans) {
			case 'y':
				Member dropOuted = mc.dropOutMember(id);
				System.out.println(dropOuted.getName() + "님의 탈퇴가 정상적으로 처리되었습니다!");
				// 로그아웃 메인화면으로 돌아간다.
				return;
			case 'n':
			default:
				System.out.println("탈퇴를 취소합니다.");
				break;
			}

		} else {
			System.out.println("아이디와 비밀번호가 일치하지 않습니다!");
		}
	}

//////////////////////////////////////////////////////////////////////////////
// 등록된 회원 조회//
	public void showMembers() {
		HashMap<String, Member> memberList = mc.enrolledMembers();

		if (!memberList.isEmpty()) { // 비어있지 않는다면 조회가능
			// (2) 회원의 이름을 기준으로 정렬한다.
			// (1) 가입된 회원을 조회한다.
			for (Entry<String, Member> e : memberList.entrySet()) {
				System.out.println(e.getKey() + " " + e.getValue());
			}

		} else {// 비어있다
			System.out.println("등록된 회원이 없습니다!");
		}
	}
}
