package com.example.account.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SignUpForm {

	@NotBlank
	private String id;

	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*._\\-])(?=.*[0-9]).{8,25}$", message = "비밀번호는 8~25자리 영어,숫자,특수문자를 포함하여야 합니다")
	private String password;

	@NotBlank
	private String nickname;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "SignupForm [id=" + id + ", password=" + password + ", nickname=" + nickname + "]";
	}

}
