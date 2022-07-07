package com.example.domain;

import java.time.LocalDateTime;

public class Account {

	private Long accountId;

	private String id;

	private String password;

	private String nickname;

	private LocalDateTime signUpDate; // 회원가입일

	private LocalDateTime withdrawalDate; // 탈퇴일

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Account [accountId=" + accountId + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", signUpDate=" + signUpDate + ", withdrawalDate=" + withdrawalDate + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
