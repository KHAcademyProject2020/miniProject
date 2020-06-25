package com.kh.project.mini.cafe.controller;

import java.util.HashMap;
import java.util.TreeMap;

import com.kh.project.mini.cafe.model.compare.MemberCompare;
import com.kh.project.mini.cafe.model.vo.Member;

public class MemberController {
	//비어있는 해시맵
	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	//map에 관리자 계정을 넣는다.(딱한번만 넣는다)
	public final void inputRoot() {
		map.put("root" , new Member("root","root","20200101","None") );
	}

	// 회원가입
	public boolean memberJoinMenu(String id, Member m) {
		// 아이디(hash map의 Key)가 중복되는지 확인
		if (!map.containsKey(id)) {
			map.put(id, m);
			return true;
		} 
		return false;
	}

	// 로그인 확인
	// 이미 가입된 회원이라면 -> 회원의 이름을 리턴.
	public Member logIn(String id, String password) {
		//map에 존재하는 아이디?
		if (map.containsKey(id)) {
			//이미 가입된 회원이라면
			Member m = (Member) map.get(id);// key(id)에 대한 value(id에 대응하는 Member객체)
			String savedPw = m.getPwd();// 패스워드를 갖고온다.

			//등록된 비밀번호와 같은가?
			if (savedPw.equals(password))
				return m;
		}
		return null; //없음.
	}

	// 회원 비밀번호 변경.
	public void changePassword(String id, String newPw) {
		Member m= map.get(id); //id에 대응하는 value(Member)을 갖고온다.
		m.setPwd(newPw);
	}

	// 회원 이름 변경
	public void changeName(String id, String newName) {
		Member m = map.get(id);
		m.setName(newName);
	}

	// 회원 생일 변경
	public void changeBirthday(String id, String newBirthday) {
		Member m = map.get(id); //id가 필요 
		m.setBirthday(newBirthday);
	}

	// 회원 주소값 변경
	public void changeAddress(String id, String newAddress) {
		Member m = map.get(id);
		m.setAddress(newAddress);
	}
	
	//회원탈퇴
	public Member dropOutMember(String id) {
		Member dropOuted=map.remove(id);
		return dropOuted;
	}
	
	
	//등록된 멤버의 이름을 기준으로 오름차순 정렬한다.
	public void sortingByMemberName() {
		// Comparator을 이용하여 정렬한다.
		TreeMap<String, Member> map= new TreeMap<String, Member>(new MemberCompare());
	}
	
	// 
	//현재 등록된 회원들을 보여준다.
	public HashMap<String, Member> enrolledMembers(){
		return map;
	}
	
	// 새로운 멤버 가입/ 기존 멤버탈퇴/ 멤버 정보 변경 이 발생한경우
	// enrolled.txt 에 멤버 정보를 업데이트 한다.
	// 현재 등록된 멤버들을 저장한다. -> (review  - 1단계) 파일입출력 io를 이용하여
	//							 (upgrade - 2단계) mysql db에 저장.
	public void updateMemberFile() {
//		File enrolledMemberListfile= new File("enrolled.txt");
	}
	
	//파일에 저장되어있는 멤버들을 map에 저장한다.
	//파일 -> 객체
	public void initHashMap() {
		
	}
}
