package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "faculty")
public class Faculty
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	
	@Column
	@Size(min = 4,max = 20,message = "Incorrect Username length")
	String username;
	
	@Pattern(regexp = "^[a-z0-9\\.]+@[a-z]+\\.[a-z]{3}$",message = "Invalid Email Id")
	String email;
	
	@Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number")
	String mobile;
	
	@Size(min = 4,message = "Incorrect Password")
	String password;
	String authority;
	boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "faculty")
	private List<Batch> batches;
	
	
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}
