package com.poscoict.vo;


public class UserVO {
	private String user_id;
	private String user_nm;
	private String user_pw;
	
	public UserVO() {
		
	}
	
	public UserVO(String id,String nm,String pw) {
		this.user_id=id;
		this.user_nm=nm;
		this.user_pw=pw;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
}
