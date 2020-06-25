package com.kh.project.mini.cafe.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.kh.project.mini.cafe.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();

//	// map�� ������ ������ �ִ´�.(���ѹ��� �ִ´�)
//	public final void inputRoot() {
//		map.put("root", new Member("root", "root", "20200101", "None"));
//	}

//	public MemberController() {
//		inputRoot();
//	}

//	// �����̵� ��������� ������Ʈ�Ѵ�.
//	public Member updateMemberInfo(String id) {
//		return map.get(id);
//	}

	// ȸ������
	public boolean memberJoinMenu(String id, Member m) {
		// ���̵�(hash map�� Key)�� �ߺ��Ǵ��� Ȯ��
		if (!map.containsKey(id)) {
			map.put(id, m);
			return true;
		}
		return false;
	}

	// �α��� Ȯ��
	// �̹� ���Ե� ȸ���̶�� -> ȸ���� �̸��� ����.
	public Member logIn(String id, String password) {
		// map�� �����ϴ� ���̵�?
		if (map.containsKey(id)) {
			// �̹� ���Ե� ȸ���̶��
			Member m = (Member) map.get(id);// key(id)�� ���� value(id�� �����ϴ� Member��ü)
			String savedPw = m.getPwd();// �н����带 ����´�.

			// ��ϵ� ��й�ȣ�� ������?
			if (savedPw.equals(password))
				return m;
		}
		return null; // ����.
	}

	// �ߺ��� ���̵� ���� ȸ������ Ȯ��.
	public boolean isDuplicatedMember(String id) {
		return map.containsKey(id) ? true : false;
	}

	// ȸ�������� �����ϸ�, map�� ����Ѵ�.
	public void joinMember(String id, Member newMember) {
		map.put(id, newMember);
	}

	// ȸ�� ��й�ȣ ����.
	public void changePassword(String id, String newPw) {
		Member m = map.get(id); // id�� �����ϴ� value(Member)�� ����´�.
		m.setPwd(newPw);
	}

	// ȸ�� �̸� ����
	public void changeName(String id, String newName) {
		Member m = map.get(id);
		m.setName(newName);
	}

	// ȸ�� ���� ����
	public void changeBirthday(String id, String newBirthday) {
		Member m = map.get(id); // id�� �ʿ�
		m.setBirthday(newBirthday);
	}

	// ȸ�� �ּҰ� ����
	public void changeAddress(String id, String newAddress) {
		Member m = map.get(id);
		m.setAddress(newAddress);
	}

	// ȸ��Ż��
	public Member dropOutMember(String id) {
		Member dropOuted = map.remove(id);
		return dropOuted;
	}

	// ��ϵ� ����� �̸��� �������� �������� �����Ѵ�.
	public void sortingByMemberName() {
		// Comparator�� �̿��Ͽ� �����Ѵ�.
//		TreeMap<String, Member> map = new TreeMap<String, Member>(new MemberCompare());
	}

	//
	// ���� ��ϵ� ȸ������ �����ش�.
	public HashMap<String, Member> enrolledMembers() {
		return map;
	}
	
	public void showEnrolledMember() {
		for(Entry<String, Member> e: map.entrySet()) {
			System.out.println("id: "+e.getKey() +"\t=>"+e.getValue() );
		}
	}
	

	// ���ο� ��� ����/ ���� ���Ż��/ ��� ���� ���� �� �߻��Ѱ��
	// enrolled.txt �� ��� ������ ������Ʈ �Ѵ�.
	// ���� ��ϵ� ������� �����Ѵ�. -> (review - 1�ܰ�) ��������� io�� �̿��Ͽ�
	// (upgrade - 2�ܰ�) mysql db�� ����.
	public void updateMemberFile() {
//		File enrolledMemberListfile= new File("enrolled.txt");
	}

	// ���Ͽ� ����Ǿ��ִ� ������� map�� �����Ѵ�.
	// ���� -> ��ü
	public void initHashMap() {

	}

	// ��й�ȣ(char�� �迭)�� ���ڿ��� ��Ÿ����
	public String getPassWordToText(char[] passWords) {
		String cArrToString = ""; // ���� �迭���� ���ڿ��� ��ȯ
		for (int i = 0; i < passWords.length; i++)
			cArrToString += passWords[i];

		return cArrToString;
	}

}
