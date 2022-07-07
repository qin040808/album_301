package com.example.account;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.account.form.SignUpForm;
import com.example.account.form.UpdateuserForm;
import com.example.account.validation.SignUpValidation;
import com.example.domain.Account;

@Controller
public class AccountController {
	private final AccountService accountService;
	private final SignUpValidation signUpValidation;

	public AccountController(AccountService accountService, SignUpValidation signUpValidation) {
		this.accountService = accountService;
		this.signUpValidation = signUpValidation;
	}

	@InitBinder("signUpForm")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(signUpValidation);
	}

	@GetMapping("/")
	public String normalPages(Model model, @CurrentAccount Account account) {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			model.addAttribute("username", account.getNickname());
		}
		return "pages/main";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "account/login";
	}

	@GetMapping("/userinfo")
	public String myInfo(Model model, @CurrentAccount Account account) {
		model.addAttribute("account", account);
		model.addAttribute("username", account.getNickname());
		return "pages/myinfo";
	}

	@GetMapping("/update")
	public String UpData(Model model, @CurrentAccount Account account) {
		model.addAttribute("username", account.getNickname());
		model.addAttribute("updateuserForm", new UpdateuserForm());

		return "pages/update";
	}

	@PostMapping("/update")
	public String UpData(@CurrentAccount Account account, @Valid @ModelAttribute UpdateuserForm updateuserForm,
			Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pages/userinfo";
		}

		account.setPassword(updateuserForm.getPassword());
		account.setNickname(updateuserForm.getNickname());
		accountService.Updata(account);
		return "redirect:/userinfo";

	}

	@GetMapping("/sign-up")
	public String showSignUpPage(Model model) {
		model.addAttribute("signUpForm", new SignUpForm());

		return "account/signup";
	}

	@GetMapping("delete")
	public String userDelete(Model model, @CurrentAccount Account account) {
		accountService.userDelete(account);
		return "redirect:/logout";
	}

	@PostMapping("/sign-up")
	public String signUpProcess(@Valid @ModelAttribute SignUpForm signUpForm, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "account/signup";
		}

		Account newAccount = new Account();
		newAccount.setId(signUpForm.getId());
		newAccount.setPassword(signUpForm.getPassword());
		newAccount.setNickname(signUpForm.getNickname());

		accountService.signUp(newAccount);
		return "redirect:/login";
	}
}