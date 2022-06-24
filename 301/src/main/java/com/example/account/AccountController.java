package com.example.account;

import javax.servlet.http.HttpSession;

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

	@GetMapping("/")
	public String normalHome() {
		return "home/index";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "account/login";
	}

	@PostMapping("/login")
	public String loginHome(@ModelAttribute Account account, HttpSession session) {
		Account loginAccount = accountService.login(account.getId(), account.getPassword());

		if (loginAccount != null) {
			session.setAttribute("current_login", session);
		}

		return "home/index";
	}

	@GetMapping("/sign-up")
	public String showSignUpPage() {
		return "account/signup";
	}

	@PostMapping("/sign-up")
	public String signUpProcess(@ModelAttribute Account account) {
		accountService.signUp(account);

		return "account/login";
	}

}
