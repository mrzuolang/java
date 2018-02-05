package com.lang.vo;

import com.jfinal.plugin.activerecord.Model;

public class UserVO extends Model<UserVO>{
	private static final long serialVersionUID = 1L;
	public String user_code;
	public String pass_word;
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	

}
