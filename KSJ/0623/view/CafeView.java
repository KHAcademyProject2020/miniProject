package com.kh.project.mini.cafe.modle.vo;

import java.util.Scanner;

public class CafeMenu {
	
	
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
			//1.(회원이름)님 무엇을 주문하시겠습니까?
			//2.커피
			//3.디저트
			//4."텅.." 주문한 메뉴가 없습니다!
			
			System.out.println();
			System.out.print("메뉴 번호 입력: ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: orderCoffee(); break;
			case 2: orderDessert(); break;
			case 3: return;
			case 4: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}while(menuNum != 4);
	}
	
	
	
	public void orderCoffee() {
	
		int menuNum = 0;
//		char menuNum = 0;
		Scanner sc = new Scanner(System.in);
		boolean coffee_bool = true;
		boolean tea_bool = true;
		boolean shot_bool = true;
		boolean sirup_bool=true;

		
		while(true) {
			System.out.println("무슨 종류로 하시겠습니까?");
			System.out.println("1. Coffee");
			System.out.println("2. Tea");


			menuNum = Integer.parseInt(sc.nextLine());
			
			if(menuNum == 1) {
				System.out.println("Coffee 선택");
				String coffee ="";
				String sirup_ok = "";
				String shot_ok = "";
				
				while(coffee_bool) {
					coffee_bool = false;
					System.out.println("무슨커피를 드시겠습니까?");
					System.out.println("1. 아메리카노");
					System.out.println("2. 카페라떼");
					System.out.println("3. 카페모카");
					System.out.println("4. 바닐라라떼");
					System.out.println("5. 카라멜마끼아토");
					
					
//					char cf = sc.next().charAt(0);
					int cf = Integer.parseInt(sc.nextLine());
					
					if(cf == 1) {
						coffee = "아메리카노";
					}
					else if(cf == 2) {
						coffee = "카페라떼";
					}
					else if(cf == 3) {
						coffee = "카페모카";
					}
					else if(cf == 4) {
						coffee = "바닐라라떼";
					}
					else if(cf == 5) {
						coffee = "카라멜마끼아토";
					}
					else {
						System.out.println("1,2,3,4,5 중 다시 선택해주세요!");
						coffee_bool = true;
					}
				}// coffee선택 while끝
				
				while(shot_bool) {
					shot_bool = false;
					System.out.println("샷 추가하시겠습니까? Y/N");
					char shot = sc.next().charAt(0);
					if(shot == 'y' || shot == 'Y') {
						shot_ok="샷 추가";
					}else if(shot == 'n' || shot == 'N') {
						shot_ok="";
					}else {
						System.out.println("다시 선택해주세요!");
						shot_bool = true;
					}
					
				}//샷추가 while 끝
				
				while(sirup_bool) {
					sirup_bool = false;
					
					System.out.println("시럽 추가하시겠습니까? Y/N");
					char sirup = sc.next().charAt(0);
					if(sirup == 'y' || sirup == 'Y') {
						sirup_ok="시럽 추가";
					}else if(sirup == 'n' || sirup == 'N') {
						sirup_ok="";
					}else {
						System.out.println("다시 선택해주세요!");
						sirup_bool = true;
				}
			}//시럽선택 끝
			
				System.out.println("주문하신 음료는" + " " + shot_ok + " " +  sirup_ok + " " + coffee + "입니다.");
				break;
			}
			else if(menuNum == 2) {
				String tea = "";
				while(tea_bool) {
					tea_bool = false;

						System.out.println("무슨 차를 드시겠습니까? ");
						System.out.println("1. 얼그레이");
						System.out.println("2. 캐모마일 ");
						System.out.println("3. 페퍼민트 ");
						System.out.println("4. 녹차");

						System.out.println();
						System.out.print("메뉴 번호 입력 : ");
						
						
						
						int cf = Integer.parseInt(sc.nextLine());
						
						if(cf == 1) {
							tea = "얼그레이";
						}
						else if(cf == 2) {
							tea = "캐모마일";
						}
						else if(cf == 3) {
							tea = "페퍼민트";
						}
						else if(cf == 4) {
							tea = "녹차";
						}
						else {
							System.out.println("차 종류를 다시 선택해주세요!");
							tea_bool = true;
						}System.out.println("주문하신 음료는 " + tea + "입니다.");
						System.out.println();
					}//티 선택 끝		
				break;
				}//if문 끝
				}//while문 끝
			}


			
		
		
	public void orderDessert() {

		
			Scanner sc = new Scanner(System.in);
			int menuNum = 0;
			boolean cake_bool = true;
			boolean cookie_bool = true;
			while(true) {
			System.out.println("무슨 종류로 하시겠습니까?");
			System.out.println("1. 케이크");
			System.out.println("2. 쿠키");
			
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			if(menuNum == 1) {
				String cake = "";
				while(cake_bool) {
					cake_bool = false;
						System.out.println("어떤 케이크로 주문하시겠습니까? ");
						System.out.println("1. 스트로베리초콜릿생크림");
						System.out.println("2. 뉴욕치즈 ");
						System.out.println("3. 티라미수 ");
						System.out.println("4. 아이스박스");

						System.out.println();
						System.out.print("메뉴 번호 입력 : ");

						int cf = Integer.parseInt(sc.nextLine());

						
						if(cf == 1) {
							cake = "스트로베리초콜릿생크림";
						}
						else if(cf == 2) {
							cake = "뉴욕치즈";
						}
						else if(cf == 3) {
							cake = "티라미수";
						}
						else if(cf == 4) {
							cake = "아이스박스";
						}
						else {
							System.out.println("케이크 종류를 다시 선택해주세요!");
							cake_bool = true;
						}System.out.println("주문하신 디저트는 " + cake + "입니다.");
						System.out.println();
					}break;//while문 끝
				}
			
				else if(menuNum == 2) {
					String cookie = "";
					while(cookie_bool) {
						cookie_bool = false;

							System.out.println("어떤 쿠키로 주문하시겠습니까? ");
							System.out.println("1. 오트밀쿠키");
							System.out.println("2. 라즈베리쿠키 ");
							System.out.println("3. 오레오쿠키 ");
							System.out.println("4. 버터쿠키");

							System.out.println();
							System.out.print("메뉴 번호 입력 : ");

							int cf = Integer.parseInt(sc.nextLine());

							
							if(cf == 1) {
								cookie = "오트밀쿠키";
							}
							else if(cf == 2) {
								cookie = "라즈베리쿠키";
							}
							else if(cf == 3) {
								cookie = "오레오쿠키";
							}
							else if(cf == 4) {
								cookie = "버터쿠키";
							}
							else {
								System.out.println("쿠키 종류를 다시 선택해주세요!");
								cookie_bool = true;
							}System.out.println("주문하신 디저트는 " + cookie + "입니다.");
							System.out.println();
						}//while쿠키 선택 끝
					break;
					}
					}//if문 끝
			}
	
		}

