package com.example.LuggagueTransformation.dto;


import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;
 
public class SignupDriverRequest {

	
	
    @Size(max = 50)
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    @Size(max = 50)
  	private String name;

  	private String mobileNo;

 
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
    
}
