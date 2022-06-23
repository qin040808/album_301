package com.example.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AccountMapper {

	@Insert("INSERT INTO" + "   member(id, password , nickname , sign_member_date)"
			+ "   VALUES(#{id}, #{pw}, #{uname}, now())")
	void newAccount(String id, String pw, String uname);

}
