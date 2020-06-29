package com.impos.catalogue.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("productModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductModel extends AbstractModel {
	
	private String name;
	private String categoryId;
	private String brandId;
	private String companyId;
	private Boolean isActive;
	private List<ProductSkuModel> skuProductModels = new ArrayList<ProductSkuModel>();
	
	
	public List<ProductSkuModel> getSkuProductModels() {
		return skuProductModels;
	}
	public void setSkuProductModels(List<ProductSkuModel> skuProductModels) {
		this.skuProductModels = skuProductModels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
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
