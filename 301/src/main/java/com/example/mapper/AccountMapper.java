package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Account;

public interface AccountMapper {

	@Insert("INSERT INTO" + "   account(id, password , nickname , sign_up_date)"
			+ "   VALUES(#{id}, #{pw}, #{nickname}, now())")
	void newAccount(String id, String pw, String nickname);

	@Update("UPDATE account " + "SET password = #{pw}," + " nickname = #{nickname} " + "WHERE id = #{id}")
	void redataAccount(String id, String pw, String nickname);

	@Select("SELECT * FROM account WHERE id = #{id} and withdrawal_date is null")
	Account accountCheck(String id);

	@Update("UPDATE account" + " SET withdrawal_date = now(), id = #{id} " + "WHERE account_id = #{accountId}")
	void userDelete(Long accountId, String id);

}
