package com.impos.settings.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "tax_group_rate")
@Entity
@Component
public class TaxGroupRate extends AbstractDomain {

//	private String taxGroupId;
//	private String taxRateId;
	private Boolean isOptional;
	private BigDecimal fromAmount;
	private BigDecimal toAmount;
	private String applicableOn;
	private TaxRate taxRate;
	private TaxGroup taxGroup;
	private String companyId;
	private Boolean isActive;

	public TaxGroupRate() {
	}

	public TaxGroupRate(Boolean isOptional, BigDecimal fromAmount, BigDecimal toAmount, String applicableOn,
			TaxRate taxRate, TaxGroup taxGroup, Boolean isActive, String companyId) {
		super();
//		this.taxGroupId = taxGroupId;
//		this.taxRateId = taxRateId;
		this.isOptional = isOptional;
		this.fromAmount = fromAmount;
		this.toAmount = toAmount;
		this.applicableOn = applicableOn;
		this.taxRate = taxRate;
		this.taxGroup = taxGroup;
		this.isActive = isActive;
		this.companyId = companyId;

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

	@ManyToOne
	@JoinColumn(name = "tax_group_id")
	public TaxGroup getTaxGroup() {
		return taxGroup;
	}

	public void setTaxGroup(TaxGroup taxGroup) {
		this.taxGroup = taxGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tax_rate_id")
	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	@Column(name = "is_optional")
	public Boolean getIsOptional() {
		return isOptional;
	}

	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}

	@Column(name = "from_amount")
	public BigDecimal getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}

	@Column(name = "to_amount")
	public BigDecimal getToAmount() {
		return toAmount;
	}

	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
	}

	@Column(name = "applicable_on")
	public String getApplicableOn() {
		return applicableOn;
	}

	public void setApplicableOn(String applicableOn) {
		this.applicableOn = applicableOn;
	}

}
