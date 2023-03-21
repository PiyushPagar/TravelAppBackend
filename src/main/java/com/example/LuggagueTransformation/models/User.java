package com.example.LuggagueTransformation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "email", nullable = false, length = 60)
	private String email;
	
	@Column(name = "password", nullable = false, length = 80)
	private String password;
	@Column(name = "name", nullable = false, length = 60)
	private String name;



	@Column(name = "mobile_no", nullable = false, length = 60)
	private String mobileNo;
	
	 @ManyToOne(targetEntity = Role.class)
	 @JoinColumn(name = "role_id")
	 @JsonIgnore
	 private  Role role;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	
	public User( String email, String password, String name, String mobileNo) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

	
	public User(String password) {
		super();
		this.password = password;
	}
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
