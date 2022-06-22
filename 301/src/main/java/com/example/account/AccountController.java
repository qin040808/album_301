package com.example.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Account;

@Controller
public class AccountController {

	@GetMapping("/login")
	public String showLoginPage() {
		return "account/login";
	}

	@GetMapping("/sign-up")
	public String showSignUpPage() {
		return "account/sign-up";
	}

	@PostMapping("/sign-up")
	public String signUpProcess(@ModelAttribute Account account) {
		// TODO: 회원가입 처리

		System.out.println(account);
		return "account/login";
	}

}
