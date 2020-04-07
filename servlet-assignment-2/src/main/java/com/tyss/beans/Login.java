package com.tyss.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
public class Login implements Serializable {

	@Id
	@Column(nullable = false)
	private String admin;
	@Column(nullable = false)
	private String password;
	
	public Login() {
		
	}
	
	public Login(String admin, String password) {
		this.admin = admin;
		this.password = password;
	}
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [admin=" + admin + ", password=" + password + "]";
	}
	
}
