package com.impos.party.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("partyModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PartyModel extends AbstractModel{
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getCreditPeriod() {
		return creditPeriod;
	}
	public void setCreditPeriod(String creditPeriod) {
		this.creditPeriod = creditPeriod;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
