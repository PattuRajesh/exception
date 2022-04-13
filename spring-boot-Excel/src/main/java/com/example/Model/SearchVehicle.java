package com.example.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="circle")
public class SearchVehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="regNo")
	private Long regNo;
	
	@Column(name="chasNo")
	private Long chasNo;
	
	@Column(name="ownName")
	private String ownName;
	
	@Column(name="vehClass")
	private String vehClass;
	
	@Column(name="model")
	private String model;
	
	@Column(name="regUpTo")
	private Date regUpTo;
	
	@Column(name="insureUpTo")
	private Date insureUpTo;
	
	@Column(name="emNorms")
	private String emNorms;
	
	@Column(name="regDate")
	private Date regDate;
	
	@Column(name="engineNo")
	private Long engineNo;
	
	@Column(name="fuel")
	private String fuel;
	
   public SearchVehicle() {
	   
   }

public SearchVehicle(Long regNo, Long chasNo, String ownName, String vehClass, String model, Date regUpTo,
		Date insureUpTo, String emNorms, Date regDate, Long engineNo, String fuel) {
	super();
	this.regNo = regNo;
	this.chasNo = chasNo;
	this.ownName = ownName;
	this.vehClass = vehClass;
	this.model = model;
	this.regUpTo = regUpTo;
	this.insureUpTo = insureUpTo;
	this.emNorms = emNorms;
	this.regDate = regDate;
	this.engineNo = engineNo;
	this.fuel = fuel;
}

public Long getRegNo() {
	return regNo;
}

public void setRegNo(Long regNo) {
	this.regNo = regNo;
}

public Long getChasNo() {
	return chasNo;
}

public void setChasNo(Long chasNo) {
	this.chasNo = chasNo;
}

public String getOwnName() {
	return ownName;
}

public void setOwnName(String ownName) {
	this.ownName = ownName;
}

public String getVehClass() {
	return vehClass;
}

public void setVehClass(String vehClass) {
	this.vehClass = vehClass;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public Date getRegUpTo() {
	return regUpTo;
}

public void setRegUpTo(Date regUpTo) {
	this.regUpTo = regUpTo;
}

public Date getInsureUpTo() {
	return insureUpTo;
}

public void setInsureUpTo(Date insureUpTo) {
	this.insureUpTo = insureUpTo;
}

public String getEmNorms() {
	return emNorms;
}

public void setEmNorms(String emNorms) {
	this.emNorms = emNorms;
}

public Date getRegDate() {
	return regDate;
}

public void setRegDate(Date regDate) {
	this.regDate = regDate;
}

public Long getEngineNo() {
	return engineNo;
}

public void setEngineNo(Long engineNo) {
	this.engineNo = engineNo;
}

public String getFuel() {
	return fuel;
}

public void setFuel(String fuel) {
	this.fuel = fuel;
}
		
}