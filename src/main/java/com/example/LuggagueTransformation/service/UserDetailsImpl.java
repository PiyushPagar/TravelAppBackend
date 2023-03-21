package com.example.LuggagueTransformation.service;

import java.util.Collection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.LuggagueTransformation.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	@JsonIgnore
	private String password;
	private String name;
	private String mobileNo;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String password, String name, String mobileNo,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobileNo = mobileNo;
		this.authorities = authorities;
	}

//	public static UserDetailsImpl build(User user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
//		return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(),user.isSos(),user.getMobileNo(), authorities);
//	}
//    
	public static UserDetailsImpl build(User user) {
		SimpleGrantedAuthority simpleAuthority = new SimpleGrantedAuthority(user.getRole().getName().name());
		List<GrantedAuthority> authorities = List.of(simpleAuthority);
		return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword(), user.getName(),
				user.getMobileNo(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}