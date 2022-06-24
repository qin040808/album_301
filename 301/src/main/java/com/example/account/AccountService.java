package com.example.account;

import org.springframework.stereotype.Service;

import com.example.domain.Account;

@Service
public class AccountService {
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void signUp(Account account) {
		accountRepository.signUp(account);
	}

	public Account login(String id, String pw) {
		Account account = accountRepository.login(id, pw);

		if (account == null) {
			return null;
		}

		return account;
	}
}
