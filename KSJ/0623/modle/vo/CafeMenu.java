package com.kh.project.mini.cafe.modle.vo;

import java.util.Scanner;

public class CafeMenu {
	
	
	public void orderMenu() {
		

		Scanner sc = new Scanner(System.in);

		int menuNum = 0;
		do {
			System.out.println("****** �ֹ� �ϱ� ******");
			System.out.println("� �޴��� ���Ƿ���?");
			System.out.println("1. Drink");
			System.out.println("2. Dessert");
			System.out.println("3. ��������");
			System.out.println("4. ����");
			//1.(ȸ���̸�)�� ������ �ֹ��Ͻðڽ��ϱ�?
			//2.Ŀ��
			//3.����Ʈ
			//4."��.." �ֹ��� �޴��� �����ϴ�!
			
			System.out.println();
			System.out.print("�޴� ��ȣ �Է�: ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: orderCoffee(); break;
			case 2: orderDessert(); break;
			case 3: return;
			case 4: System.out.println("���α׷��� �����մϴ�."); break;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}while(menuNum != 4);
	}
	
	
	
	public void orderCoffee() {
	
		int menuNum = 0;
		Scanner sc = new Scanner(System.in);
		boolean coffee_bool = true;
		boolean tea_bool = true;
		boolean shot_bool = true;
		boolean sirup_bool=true;

		
		while(true) {
			System.out.println("���� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1. Coffee");
			System.out.println("2. Tea");

			
//			char menu = sc.next().charAt(0);
			menuNum = Integer.parseInt(sc.nextLine());
			
			if(menuNum=='1') {
				System.out.println("Coffee ����");
				String coffee ="";
				String sirup_ok = "";
				String shot_ok = "";
				
				while(coffee_bool) {
					coffee_bool = false;
					System.out.println("����Ŀ�Ǹ� ��ðڽ��ϱ�?");
					System.out.println("1. �Ƹ޸�ī��");
					System.out.println("2. ī���");
					System.out.println("3. ī���ī");
					System.out.println("4. �ٴҶ��");
					System.out.println("5. ī��Ḷ������");
					
					
					char cf = sc.next().charAt(0);
					
					if(cf == '1') {
						coffee = "�Ƹ޸�ī��";
					}
					else if(cf == '2') {
						coffee = "ī���";
					}
					else if(cf == '3') {
						coffee = "ī���ī";
					}
					else if(cf == '4') {
						coffee = "�ٴҶ��";
					}
					else if(cf == '5') {
						coffee = "ī��Ḷ������";
					}
					else {
						System.out.println("1,2,3,4,5 �� �ٽ� �������ּ���!");
						coffee_bool = true;
					}
				}// coffee���� while��
				
				while(shot_bool) {
					shot_bool = false;
					System.out.println("�� �߰��Ͻðڽ��ϱ�? Y/N");
					char shot = sc.next().charAt(0);
					if(shot == 'y' || shot == 'Y') {
						shot_ok="�� �߰�";
					}else if(shot == 'n' || shot == 'N') {
						shot_ok="";
					}else {
						System.out.println("�ٽ� �������ּ���!");
						shot_bool = true;
					}
					
				}//���߰� while ��
				
				while(sirup_bool) {
					sirup_bool = false;
					
					System.out.println("�÷� �߰��Ͻðڽ��ϱ�? Y/N");
					char sirup = sc.next().charAt(0);
					if(sirup == 'y' || sirup == 'Y') {
						sirup_ok="�� �߰�";
					}else if(sirup == 'n' || sirup == 'N') {
						sirup_ok="";
					}else {
						System.out.println("�ٽ� �������ּ���!");
						sirup_bool = true;
				}
			}//�÷����� ��
			
				System.out.println("�ֹ��Ͻ� �����" + shot_ok + sirup_ok + coffee + "�Դϴ�.");
				break;
			}
			else if(menuNum == '2') {
				String tea = "";
				while(tea_bool) {
					tea_bool = false;
				
				while(true) {
						System.out.println(" ���� ���� ��ðڽ��ϱ�? ");
						System.out.println("1. ��׷���");
						System.out.println("2. ĳ���� ");
						System.out.println("3. ���۹�Ʈ ");
						System.out.println("4. ����");

						System.out.println();
						System.out.print("�޴� ��ȣ �Է� : ");
						menuNum = Integer.parseInt(sc.nextLine());
						
						int cf = sc.nextInt();
						
						if(cf == 1) {
							tea = "��׷���";
						}
						else if(cf == 2) {
							tea = "ĳ����";
						}
						else if(cf == 3) {
							tea = "���۹�Ʈ";
						}
						else if(cf == 4) {
							tea = "����";
						}
						else {
							System.out.println("�� ������ �ٽ� �������ּ���!");
							tea_bool = true;
						}
					}//Ƽ ���� ��
					
				}
				}//if�� ��
			} //while�� ��
	}

			
		
		
	public void orderDessert() {

		
			Scanner sc = new Scanner(System.in);
			int menuNum = 0;
			boolean cake_bool = true;
			boolean cookie_bool = true;
			while(true) {
			System.out.println("���� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1. ����ũ");
			System.out.println("2. ��Ű");
			
			System.out.println();
			System.out.print("�޴� ��ȣ �Է� : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			if(menuNum == '1') {
				String cake = "";
				while(cake_bool) {
					cake_bool = false;
				
					while(true) {
						System.out.println(" ���� ������ �Ͻðڽ��ϱ�? ");
						System.out.println("1. ���ݸ�����ũ");
						System.out.println("2. ġ������ũ ");
						System.out.println("3. Ƽ��̼�����ũ ");
						System.out.println("4. �������ũ");

						System.out.println();
						System.out.print("�޴� ��ȣ �Է� : ");
						menuNum = Integer.parseInt(sc.nextLine());
						
						int cf = sc.nextInt();
						
						if(cf == 1) {
							cake = "���ݸ�����ũ";
						}
						else if(cf == 2) {
							cake = "ġ������ũ";
						}
						else if(cf == 3) {
							cake = "Ƽ��̼�����ũ";
						}
						else if(cf == 4) {
							cake = "�������ũ";
						}
						else {
							System.out.println("����ũ ������ �ٽ� �������ּ���!");
							cake_bool = true;
						}
					}
				}
			}
				else if(menuNum == '2') {
					String cookie = "";
					while(cookie_bool) {
						cookie_bool = false;
					
					while(true) {
							System.out.println(" ���� ������ �Ͻðڽ��ϱ�? ");
							System.out.println("1. ��Ʈ����Ű");
							System.out.println("2. �������Ű ");
							System.out.println("3. ��������Ű ");
							System.out.println("4. ������Ű");

							System.out.println();
							System.out.print("�޴� ��ȣ �Է� : ");
							menuNum = Integer.parseInt(sc.nextLine());
							
							int cf = sc.nextInt();
							
							if(cf == 1) {
								cookie = "��Ʈ����Ű";
							}
							else if(cf == 2) {
								cookie = "�������Ű";
							}
							else if(cf == 3) {
								cookie = "��������Ű";
							}
							else if(cf == 4) {
								cookie = "������Ű";
							}
							else {
								System.out.println("��Ű ������ �ٽ� �������ּ���!");
								cookie_bool = true;
							}
						}//Ƽ ���� ��
						
					}
					}//if�� ��
			}
			}

}