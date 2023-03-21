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
	private Long id;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private Long userId;

	@Column(name = "LiencesUrl")
	private String liencesUrl;
	
	@Column(name = "LiencesName")
	private String liencesName;
	
	@Column(name = "VehicalName")
	private String vehicalName;
	
	@Column(name = "VehicalNumber")
	private String vehicalNo;

	

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



	public DriverDetails( Long userId, String liencesName,String liencesUrl) {
		this.userId = userId;
		this.liencesName=liencesName;
		this.liencesUrl = liencesUrl;
	}
	
	
	

}
