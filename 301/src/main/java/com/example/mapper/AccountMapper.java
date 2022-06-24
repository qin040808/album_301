package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Account;

public interface AccountMapper {

	@Insert("INSERT INTO" + "   account(id, password , nickname , sign_up_date)"
			+ "   VALUES(#{id}, #{pw}, #{uname}, now())")
	void newAccount(String id, String pw, String uname);

	@Select("SELECT * FROM account WHERE id = #{id} AND password = #{pw}")
	Account accountCheck(String id, String pw);

}
