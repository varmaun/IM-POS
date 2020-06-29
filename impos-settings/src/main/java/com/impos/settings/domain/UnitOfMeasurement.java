package com.impos.settings.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.avitcore.domain.AbstractDomain;

@Table(name = "unit_of_measurement")
@Entity
public class UnitOfMeasurement extends AbstractDomain {
	
	private String unitName;
	private String parentUnitId;
	private BigDecimal conversionValue;
	private Boolean isFixed;
	private String shortName;
	private Boolean isActive;
	
	
	
	
	@Column(name="is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UnitOfMeasurement() {
	}

	public UnitOfMeasurement(String unitName, String parentUnitId, BigDecimal conversionValue,Boolean isFixed,String shortName) {
		super();
		this.unitName = unitName;
		this.parentUnitId = parentUnitId;
		this.conversionValue = conversionValue;
		this.isFixed = isFixed;
		this.shortName = shortName;
	}
	
	@Column(name = "unit_name")
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Column(name = "parent_unit_id")
	public String getParentUnitId() {
		return parentUnitId;
	}
	public void setParentUnitId(String parentUnitId) {
		this.parentUnitId = parentUnitId;
	}
	
	@Column(name = "conversion_value")
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	@Column(name = "is_fixed")
	public Boolean getIsFixed() {
		return isFixed;
	}
	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
	}
	
	@Column(name = "short_name")
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	

}
