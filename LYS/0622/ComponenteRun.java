package com.kh.project.mini.cafaLogin.componente.run;

import com.kh.project.mini.cafaLogin.componente.veiw.A_Main;
import com.kh.project.mini.cafaLogin.componente.veiw.B_Login;
import com.kh.project.mini.cafaLogin.componente.veiw.C_MemberJoin;

public class Run {
	public static void main(String[] args) {
		new A_Main().doMain();
		new B_Login().doLogin();
		new C_MemberJoin().doMemberJoin();
		
	}

}
