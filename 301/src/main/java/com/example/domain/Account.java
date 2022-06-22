package com.example.domain;

import java.time.LocalDateTime;

public class Account {

	private Long accountId;

	private LocalDateTime signUpDate = LocalDateTime.now(); // 회원가입일

	private LocalDateTime withdrawalDate; // 탈퇴일

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public LocalDateTime getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(LocalDateTime signUpDate) {
		this.signUpDate = signUpDate;
	}

	public LocalDateTime getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(LocalDateTime withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", signUpDate=" + signUpDate + ", withdrawalDate=" + withdrawalDate
				+ "]";
	}

}
