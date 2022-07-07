package com.example.account;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.domain.Account;

public class LoginAccount extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Account account;

	public Account getAccount() {
		return account;
	}

	public LoginAccount(Account account) {
		super(account.getId(), account.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
		this.account = account;
	}

}
