package com.impos.settings.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
@Table(name = "tax_group")
@Entity
@Component
public class TaxGroup extends AbstractDomain {
	
	private String taxGroupName;
	private Boolean isSlabBased;
	private String amountType;
	private String companyId;
	private List<TaxGroupRate> taxGroupRates;
	private Boolean isActive;
	
	
	public TaxGroup() {
	}

	public TaxGroup(String taxGroupName, Boolean isSlabBased, String amountType,String companyId, List<TaxGroupRate> taxGroupRates, Boolean isActive) {
		super();
		this.taxGroupName = taxGroupName;
		this.isSlabBased = isSlabBased;
		this.amountType = amountType;
		this.companyId = companyId;
		this.taxGroupRates = taxGroupRates;
		this.isActive = isActive;
	}
	@Column(name="is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(mappedBy="taxGroup", cascade = CascadeType.ALL)
	public List<TaxGroupRate> getTaxGroupRates() {
		return taxGroupRates;
	}

	public void setTaxGroupRates(List<TaxGroupRate> taxGroupRates) {
		this.taxGroupRates = taxGroupRates;
	}

	@Column(name = "tax_group_name")
	public String getTaxGroupName() {
		return taxGroupName;
	}
	public void setTaxGroupName(String taxGroupName) {
		this.taxGroupName = taxGroupName;
	}
	
	@Column(name = "is_slab_based")
	public Boolean getIsSlabBased() {
		return isSlabBased;
	}
	public void setIsSlabBased(Boolean isSlabBased) {
		this.isSlabBased = isSlabBased;
	}
	
	@Column(name = "amount_type")
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	
	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	
	

}
