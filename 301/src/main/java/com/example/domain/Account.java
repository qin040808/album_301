package com.example.domain;

import java.time.LocalDateTime;

public class Account {

	private Long accountId;

	private String id;

	private String pw;

	private String uname;

	private LocalDateTime signUpDate; // 회원가입일

	private LocalDateTime withdrawalDate; // 탈퇴일

	public Long getAccountId() {
		return accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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
		return "Account [accountId=" + accountId + ", id=" + id + ", pw=" + pw + ", uname=" + uname + ", signUpDate="
				+ signUpDate + ", withdrawalDate=" + withdrawalDate + "]";
	}

}
