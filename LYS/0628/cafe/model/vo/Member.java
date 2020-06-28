package com.kh.project.mini.cafe.model.vo;

import java.util.Date;

public class Member {
	
	private String pwd;
	private String name;
	private String birthday;
	private String address;
	
	private int orderCnt = 0; //�� �ֹ�Ƚ�� (0���� �ʱ�ȭ)
	private String latestOrderMenu; //�����ֱٿ� �ֹ��� �޴�
	private String orderHistory;
//	private LinkedList<> orderLog //(��ȭ)�ֹ���Ϸα�- (�ֹ���¥�� �ֹ��޴��� ���)
	
	//�ֹ�����Ʈ
	
	public Member() {}
	public Member(String pwd, String name, String birthday, String address) {
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
				
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrdetCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	
	public String getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(String orderHistory) {
		this.orderHistory = orderHistory;
	}
	@Override
	public String toString() {
		return pwd + name + birthday + address +  orderCnt + orderHistory ;
	}

}
