package com.example.LuggagueTransformation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DriverDetails")
public class DriverDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "user_id")
	public Long userId;

	@Column(name = "LiencesUrl")
	public String liencesUrl;
	
	@Column(name = "LiencesName")
	public String liencesName;
	
	@Column(name = "VehicalName")
	public String vehicalName;
	
	@Column(name = "VehicalNumber")
	public String vehicalNo;

	

	public String getVehicalName() {
		return vehicalName;
	}



	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}



	public String getVehicalNo() {
		return vehicalNo;
	}



	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getUserId() {
		return userId;
	}



	public DriverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getLiencesUrl() {
		return liencesUrl;
	}



	public void setLiencesUrl(String liencesUrl) {
		this.liencesUrl = liencesUrl;
	}



	public String getLiencesName() {
		return liencesName;
	}



	public void setLiencesName(String liencesName) {
		this.liencesName = liencesName;
	}






	public DriverDetails( Long userId, String liencesName,String liencesUrl,String vehicalName,	String vehicalNo) {
		this.userId = userId;
		this.liencesName=liencesName;
		this.liencesUrl = liencesUrl;
		this.vehicalName=vehicalName;
		this.vehicalNo =vehicalNo;
	}
	
	
	

}
