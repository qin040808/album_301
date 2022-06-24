package com.example.account;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Account;
import com.example.mapper.AccountMapper;

@Repository
public class AccountRepository {

	private SqlSessionTemplate sessionTemplate;

	public AccountRepository(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public void signUp(Account account) {
		sessionTemplate.getMapper(AccountMapper.class).newAccount(account.getId(), account.getPassword(),
				account.getUname());
	}

	public Account login(String id, String pw) {
		return sessionTemplate.getMapper(AccountMapper.class).accountCheck(id, pw);
	}
}
