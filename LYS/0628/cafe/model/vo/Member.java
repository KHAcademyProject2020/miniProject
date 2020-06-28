package com.kh.project.mini.cafe.model.vo;

import java.util.Date;

public class Member {
	
	private String pwd;
	private String name;
	private String birthday;
	private String address;
	
	private int orderCnt = 0; //총 주문횟수 (0으로 초기화)
	private String latestOrderMenu; //가장최근에 주문한 메뉴
	private String orderHistory;
//	private LinkedList<> orderLog //(심화)주문기록로그- (주문날짜와 주문메뉴가 기록)
	
	//주문리스트
	
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
