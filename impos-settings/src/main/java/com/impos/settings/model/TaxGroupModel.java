package com.impos.settings.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("taxGroupModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxGroupModel extends AbstractModel {
	
	private String taxGroupName;
	private Boolean isSlabBased;
	private String amountType;
	private String companyId;
	private List<TaxGroupRateModel> taxGroupRateModels = new ArrayList<TaxGroupRateModel>();
	
	private Boolean isActive;
	
	
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public List<TaxGroupRateModel> getTaxGroupRateModels() {
		return taxGroupRateModels;
	}
	public void setTaxGroupRateModels(List<TaxGroupRateModel> taxGroupRateModels) {
		this.taxGroupRateModels = taxGroupRateModels;
	}
	public String getTaxGroupName() {
		return taxGroupName;
	}
	public void setTaxGroupName(String taxGroupName) {
		this.taxGroupName = taxGroupName;
	}
	public Boolean getIsSlabBased() {
		return isSlabBased;
	}
	public void setIsSlabBased(Boolean isSlabBased) {
		this.isSlabBased = isSlabBased;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	

}
