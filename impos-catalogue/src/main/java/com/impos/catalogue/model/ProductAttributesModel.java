package com.impos.catalogue.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("productAttributesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductAttributesModel extends AbstractModel{
	
	private String productSkuId;
	private String attributeId;
	private String attributeName;
	private String attributeValue;
	private String attributeType;
	private Boolean isActive;
	
	
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	public String getProductSkuId() {
		return productSkuId;
	}
	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}
	public String getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
