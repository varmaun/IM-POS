package com.impos.settings.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("taxGroupRateModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxGroupRateModel extends AbstractModel{

	private String taxGroupId;
	private String taxRateId;
	private Boolean isOptional;
	private BigDecimal fromAmount;
	private BigDecimal toAmount;
	private String applicableOn;
	private TaxRateModel taxRateModel;
	private Boolean isActive;
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public TaxRateModel getTaxRateModel() {
		return taxRateModel;
	}
	public void setTaxRateModel(TaxRateModel taxRateModel) {
		this.taxRateModel = taxRateModel;
	}
	public String getTaxGroupId() {
		return taxGroupId;
	}
	public void setTaxGroupId(String taxGroupId) {
		this.taxGroupId = taxGroupId;
	}
	public String getTaxRateId() {
		return taxRateId;
	}
	public void setTaxRateId(String taxRateId) {
		this.taxRateId = taxRateId;
	}
	public Boolean getIsOptional() {
		return isOptional;
	}
	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}
	public BigDecimal getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}
	public BigDecimal getToAmount() {
		return toAmount;
	}
	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
	}
	public String getApplicableOn() {
		return applicableOn;
	}
	public void setApplicableOn(String applicableOn) {
		this.applicableOn = applicableOn;
	}
	
}
