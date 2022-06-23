package com.example.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Account;

@Controller
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "account/login";
	}

	@GetMapping("/sign-up")
	public String showSignUpPage() {
		return "account/signup";
	}

	@PostMapping("/sign-up")
	public String signUpProcess(@ModelAttribute Account account) {
		accountService.signUp(account);

		System.out.println(account);

		return "account/login";
	}

}
