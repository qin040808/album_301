package com.example.account;

import java.util.UUID;

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
				account.getNickname());
	}

	public void Updata(Account account) {
		sessionTemplate.getMapper(AccountMapper.class).redataAccount(account.getId(), account.getPassword(),
				account.getNickname());
	}

	public void userDelete(Account account) {
		sessionTemplate.getMapper(AccountMapper.class).userDelete(account.getAccountId(),
				account.getId() + "/" + (UUID.randomUUID().toString().substring(0, 13)));
	}

	public Account login(String id) {
		return sessionTemplate.getMapper(AccountMapper.class).accountCheck(id);
	}
}
