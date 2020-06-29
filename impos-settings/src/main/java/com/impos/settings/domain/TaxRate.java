package com.impos.settings.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "tax_rate")
@Entity
@Component
public class TaxRate extends AbstractDomain {
	
	private String name;
	private BigDecimal rate;
	private String companyId;
	private List<TaxGroupRate> taxGroupRates;
	private Boolean isActive;

	
	public TaxRate() {
	}

	public TaxRate(String name, BigDecimal rate, String companyId,  Boolean isActive, List<TaxGroupRate> taxGroupRates) {
		super();
		this.name = name;
		this.rate = rate;
		this.companyId = companyId;
		this.taxGroupRates =taxGroupRates;
		this.isActive = isActive;
	
	}
	
	@Column(name="is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	@OneToMany(mappedBy="taxRate")
	public List<TaxGroupRate> getTaxGroupRates() {
		return taxGroupRates;
	}

	public void setTaxGroupRates(List<TaxGroupRate> taxGroupRates) {
		this.taxGroupRates = taxGroupRates;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "rate")
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
