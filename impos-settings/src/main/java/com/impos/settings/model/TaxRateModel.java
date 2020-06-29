package com.impos.settings.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("taxRateModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxRateModel extends AbstractModel{
	private String name;
	private String rate;
	private String companyId;
	private Boolean isActive;
	
	
	
	
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	

}
