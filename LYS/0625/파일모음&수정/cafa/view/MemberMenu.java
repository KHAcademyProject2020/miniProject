package com.kh.project.mini.cafa.view;

import java.util.Scanner;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {
		System.out.println("==== 안녕하세요 커피깡 입니다  =====");
		
		int menuNum = 0;
		while(menuNum != 4) {
		System.out.println(" ****** 메인 메뉴 ****** ");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 로그인");
		System.out.println("3. 회원정보수정");
		System.out.println("4. 종료");
		
		System.out.println();
		System.out.print("메뉴 번호 입력 : ");
		menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: memberJoinMenu(); break;
		case 2: memberLogin(); break;
		case 3: memberEdit(); break;
		case 4: System.out.println("프로그램 종료"); return;
		default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	

	public void memberJoinMenu() {
		while(true) {
			System.out.println(" ****** 회원 가입 ****** ");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("생년월일 8자리 : ");
			String birthday = sc.nextLine();
			System.out.print("주소 : ");
			String addrass = sc.next();

			Member m = new Member(pwd, name, birthday, addrass);
			if(mc.memberJoinMenu(id,m)) {
					System.out.println("성공적으로 회원가입 완료하였습니다.");
					break;
			} else {
					System.out.println("중복된 아이디입니다. 다시 입력해주세요");
			}
		}
	}
	
	
	public void memberLogin() {
		while(true) {
			System.out.println(" ****** 로그인  ****** ");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
		
			String name = mc.logIn(id, pwd);
			if(name != null) {
				System.out.println( name + "님, 환영합니다!");	
				break;	
			} else {
					System.out.println("틀린 아이디 또는 비밀번호 입니다. 다시 입력해주세요");
			}
		}
	}
	
	public void memberEdit() {
		int menuNum = 0;
		while(true) {
				System.out.println("  ****** 회원정보수정 ****** ");
				System.out.println("1. 비밀번호 수정하기");
				System.out.println("2. 이름 수정하기 ");
				System.out.println("3. 생년월일 수정하기 ");
				System.out.println("4. 주소 소정하기");
				System.out.println("5. 로그아웃");
				
				System.out.println();
				System.out.print("메뉴 번호 입력 : ");
				menuNum = Integer.parseInt(sc.nextLine());
				
				switch(menuNum) {
				case 1: changePassword(); break;
				case 2: changeName(); break;
				case 3: changeBirthday(); break;
				case 4: changeAddress(); break;
				case 5: System.out.println("로그아웃 되었습니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}	
	}
	
	public void changePassword() {
		while(true) {
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("현재 비밀번호 : ");
				String oldPw = sc.nextLine();
				System.out.print("새로운 비밀번호 : ");
				String newPw = sc.nextLine();
				
				boolean result = mc.changePassword(id, oldPw, newPw);
				if(result) {
							System.out.println("비밀번호 변경에 성공했습니다.");
							break;
				} else {
							System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
				}	
			}
	}	
	
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			String name = mc.logIn(id, password);
			if(name != null) {
				System.out.println("현재 설정된 이름 : " + name);
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
	
	
	public void changeBirthday() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			String birthday = mc.logIn(id, password);
			if(birthday != null) {
				System.out.println("현재 설정된 생일 : " + birthday);
				System.out.print("변경할 생일 : ");
				String newBirthday = sc.nextLine();
				
				mc.changeBirthday(birthday, newBirthday);
				System.out.println("생일 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("생일 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	public void changeAddress() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();

			String address = mc.logIn(id, password);
			if(address != null) {
				System.out.println("현재 설정된 주소 : " + address);
				System.out.print("변경할 주소 : ");
				String newAddress = sc.nextLine();
				
				mc.changeAddress(address, newAddress);
				System.out.println("주소 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("주소 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
}
	
	

