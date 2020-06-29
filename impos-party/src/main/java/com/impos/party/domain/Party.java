package com.impos.party.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "party")
@Entity
@Component
public class Party extends AbstractDomain {

	private String name;
	private String partyType;
	private String state;
	private String gstNo;
	private String phoneNo;
	private String emailId;
	private String address;
	private String currentBalance;
	private String creditPeriod;
	private String creditLimit;
	private String paymentType;
	private String companyId;
	private Boolean isActive;

	public Party() {

	}

	public Party(String name, String partyType, String state, String gstNo, String phoneNo, String emailId,
			String address, String currentBalance, String creditPeriod, String creditLimit, String paymentType,
			String companyId, Boolean isActive) {
		super();
		this.name = name;
		this.partyType = partyType;
		this.state = state;
		this.gstNo = gstNo;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.address = address;
		this.currentBalance = currentBalance;
		this.creditPeriod = creditPeriod;
		this.creditLimit = creditLimit;
		this.paymentType = paymentType;
		this.companyId = companyId;
		this.isActive = isActive;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "party_type")
	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "gst_no")
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(name = "phone_no")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "email_id")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "current_balance")
	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Column(name = "credit_period")
	public String getCreditPeriod() {
		return creditPeriod;
	}

	public void setCreditPeriod(String creditPeriod) {
		this.creditPeriod = creditPeriod;
	}

	@Column(name = "credit_limit")
	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Column(name = "payment_type")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
