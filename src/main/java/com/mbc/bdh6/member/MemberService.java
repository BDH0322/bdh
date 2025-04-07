package com.mbc.bdh6.member;

import java.util.ArrayList;

public interface MemberService {

	int idcount(String id);

	void insert(String id, String pw, String name, int age);

	ArrayList<MemberDTO> select();

}
