package com.impos.settings.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;


@Component("unitOfMeasurementModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UnitOfMeasurementModel extends AbstractModel{
	
	private String unitName;
	private String parentUnitId;
	private BigDecimal conversionValue;
	private Boolean isFixed;
	private String shortName;
	private Boolean isActive;
	
	
	
	
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getParentUnitId() {
		return parentUnitId;
	}
	public void setParentUnitId(String parentUnitId) {
		this.parentUnitId = parentUnitId;
	}
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	public Boolean getIsFixed() {
		return isFixed;
	}
	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	

}
