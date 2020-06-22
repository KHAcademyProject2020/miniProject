package com.kh.project.mini.cafa.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.kh.project.mini.cafa.model.vo.Member;

public class MemberController {
	private HashMap map = new HashMap();

	public boolean memberJoinMenu(String id, Member m) {
		if(!map.containsKey(id)) {
				map.put(id, m);
				return true;
		} else {
				return false;
		}
	}
	
	public String logIn(String id, String password) {
		if(map.containsKey(id)) {
			Member m = (Member)map.get(id);
			String savedPw = m.getPwd();
			
			if(savedPw.equals(password))
				return m.getName();
			else
				return null;
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		boolean existedId = map.containsKey(id);
		
		Member m = (Member)map.get(id);
		String savedPw = m.getPwd();
		boolean existedPw = savedPw.equals(oldPw);
		
		if(existedId && existedPw) {
			m.setPwd(newPw);
			return true;
		}
		
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member m = (Member)map.get(id);
		m.setName(newName);
	}

	public void changeBirthday(String birthday, String newBirthday) {
		Member m = (Member)map.get(birthday);
		m.setBirthday(newBirthday);
	}
	
	public void changeAddress(String address, String newAddress) {
		Member m = (Member)map.get(address);
		m.setAddress(newAddress);

	}
}

