package com.webappsecurity.security.DTO;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class LoginUsuario {
	@NotNull
	private String nickname;
	@NotBlank
	private String password;
	
	
	public String getNickname() {
	
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginUsuario [nickname=" + nickname + ", password=" + password + "]";
	}
	
	
}
