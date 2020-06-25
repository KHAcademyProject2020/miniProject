package com.kh.project.mini.cafa.view;

import java.util.Scanner;

import com.kh.project.mini.cafa.controller.MemberController;
import com.kh.project.mini.cafa.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {
		System.out.println("==== �ȳ��ϼ��� Ŀ�Ǳ� �Դϴ�  =====");
		
		int menuNum = 0;
		while(menuNum != 4) {
		System.out.println(" ****** ���� �޴� ****** ");
		System.out.println("1. ȸ������ ");
		System.out.println("2. �α���");
		System.out.println("3. ȸ����������");
		System.out.println("4. ����");
		
		System.out.println();
		System.out.print("�޴� ��ȣ �Է� : ");
		menuNum = Integer.parseInt(sc.nextLine());
		
		switch(menuNum) {
		case 1: memberJoinMenu(); break;
		case 2: memberLogin(); break;
		case 3: memberEdit(); break;
		case 4: System.out.println("���α׷� ����"); return;
		default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	

	public void memberJoinMenu() {
		while(true) {
			System.out.println(" ****** ȸ�� ���� ****** ");
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String pwd = sc.nextLine();
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("������� 8�ڸ� : ");
			String birthday = sc.nextLine();
			System.out.print("�ּ� : ");
			String addrass = sc.next();

			Member m = new Member(pwd, name, birthday, addrass);
			if(mc.memberJoinMenu(id,m)) {
					System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");
					break;
			} else {
					System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���");
			}
		}
	}
	
	
	public void memberLogin() {
		while(true) {
			System.out.println(" ****** �α���  ****** ");
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String pwd = sc.nextLine();
		
			String name = mc.logIn(id, pwd);
			if(name != null) {
				System.out.println( name + "��, ȯ���մϴ�!");	
				break;	
			} else {
					System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ �Դϴ�. �ٽ� �Է����ּ���");
			}
		}
	}
	
	public void memberEdit() {
		int menuNum = 0;
		while(true) {
				System.out.println("  ****** ȸ���������� ****** ");
				System.out.println("1. ��й�ȣ �����ϱ�");
				System.out.println("2. �̸� �����ϱ� ");
				System.out.println("3. ������� �����ϱ� ");
				System.out.println("4. �ּ� �����ϱ�");
				System.out.println("5. �α׾ƿ�");
				
				System.out.println();
				System.out.print("�޴� ��ȣ �Է� : ");
				menuNum = Integer.parseInt(sc.nextLine());
				
				switch(menuNum) {
				case 1: changePassword(); break;
				case 2: changeName(); break;
				case 3: changeBirthday(); break;
				case 4: changeAddress(); break;
				case 5: System.out.println("�α׾ƿ� �Ǿ����ϴ�."); return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	
	public void changePassword() {
		while(true) {
				System.out.print("���̵� : ");
				String id = sc.nextLine();
				System.out.print("���� ��й�ȣ : ");
				String oldPw = sc.nextLine();
				System.out.print("���ο� ��й�ȣ : ");
				String newPw = sc.nextLine();
				
				boolean result = mc.changePassword(id, oldPw, newPw);
				if(result) {
							System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
							break;
				} else {
							System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
				}	
			}
	}	
	
	public void changeName() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();

			String name = mc.logIn(id, password);
			if(name != null) {
				System.out.println("���� ������ �̸� : " + name);
				System.out.print("������ �̸� : ");
				String newName = sc.nextLine();
				
				mc.changeName(id, newName);
				System.out.println("�̸� ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void changeBirthday() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();

			String birthday = mc.logIn(id, password);
			if(birthday != null) {
				System.out.println("���� ������ ���� : " + birthday);
				System.out.print("������ ���� : ");
				String newBirthday = sc.nextLine();
				
				mc.changeBirthday(birthday, newBirthday);
				System.out.println("���� ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("���� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void changeAddress() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();

			String address = mc.logIn(id, password);
			if(address != null) {
				System.out.println("���� ������ �ּ� : " + address);
				System.out.print("������ �ּ� : ");
				String newAddress = sc.nextLine();
				
				mc.changeAddress(address, newAddress);
				System.out.println("�ּ� ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("�ּ� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
	
}
	
	

