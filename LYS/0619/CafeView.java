package com.kh.project.mini.cafa.view;

import java.util.Scanner;

public class CafaView {
	public void mainMenu() {
		
		System.out.println("==== 안녕하세요 커피깡 입니다  =====");
		
	while(true){
		System.out.println(" ****** 메인 메뉴 ****** ");
		System.out.println("1. 회원가입 ");
		System.out.println("2. 로그인");
		System.out.print("메뉴 번호 선택 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("회원 가입 메뉴로 넘어갑니다.");
			memberJoinMenu();
			break;
				} else if (num == 2){
		    memberLogin(); 
		    break;
		} 
	 	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. ");
		
		System.out.println();
		
			}	
		}
	

	public void memberJoinMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ****** 회원 가입 ****** ");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("생년월일 8자리 : ");
		int bd = sc.nextInt();
		
		System.out.println("주소 : ");
		String addrass = sc.nextLine();
		
		
	}
	
	
	public void memberLogin() {
		System.out.println(" ****** 로그인  ****** ");
		
	}
		
}
