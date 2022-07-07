package com.example.account;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.Account;

@Service
public class AccountService implements UserDetailsService {
	private PasswordEncoder passwordEncoder;
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.login(username);

		if (account == null) {
			throw new UsernameNotFoundException(username);
		}

		return new LoginAccount(account);
	}

	public void signUp(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.signUp(account);
	}

	public void userDelete(Account account) {
		accountRepository.userDelete(account);
	}

	public void Updata(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.Updata(account);
	}
}
