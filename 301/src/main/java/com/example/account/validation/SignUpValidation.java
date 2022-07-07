package com.example.account.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.account.AccountRepository;
import com.example.account.form.SignUpForm;

@Component
public class SignUpValidation implements Validator {
	private final AccountRepository accountRepository;

	public SignUpValidation(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignUpForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignUpForm signUpForm = (SignUpForm) target;

		String id = signUpForm.getId();
		if (accountRepository.login(id) != null) {
			errors.rejectValue("id", "wrong.id", "중복된 아이디입니다.");
		}
	}
}
