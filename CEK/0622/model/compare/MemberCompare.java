package com.kh.project.mini.cafe.model.compare;

import java.util.Comparator;
import java.util.HashMap;

import com.kh.project.mini.cafe.controller.MemberController;
import com.kh.project.mini.cafe.model.vo.Member;

public class MemberCompare implements Comparator<String>{
	private MemberController mc= new MemberController();
	//키값(Member의 id필드)의 타입이 String
	//멤버 이름순으로 오름차순 정렬
	@Override
	public int compare(String id1, String id2) {
		//회원가입한 사람들의 map을 보여준다.
		HashMap<String, Member> map=mc.enrolledMembers();
		Member member1=map.get(id1);
		Member member2=map.get(id2);
		
		String memberName1= member1.getName();
		String memberName2= member2.getName();
		return memberName1.compareTo(memberName2);
	}
}
