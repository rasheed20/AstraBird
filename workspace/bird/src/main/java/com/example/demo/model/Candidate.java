
package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "CANDIDATE_LOGIN_SCREEN")
public class Candidate {
	
	@Id
	@Column(name="UID")
	String userId;
	
	@Column(name="PWD")
	 String Password;
	
	@Column(name="EM")
	String Email;
	
	@Column(name="LLOG")
	long lastLogin = System.currentTimeMillis();
	
	
	public Candidate() {
	}
	
	@Override
	public String toString() {
		return "Candidate [userId=" + userId + ", Password=" + Password + ", Email=" + Email + ", lastLogin="
				+ lastLogin + "]";
	}

	public String getUserId() {
		return userId;
	}
	
//	public void setUserId(String userId) {
//		if(this.userId == null)
//			this.userId = userId;
//	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public long getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}