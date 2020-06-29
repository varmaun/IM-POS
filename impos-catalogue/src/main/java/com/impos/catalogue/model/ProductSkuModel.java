package com.impos.catalogue.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("productSkuModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductSkuModel extends AbstractModel{
	
	private String productId;
	private String skuCode;
	private String barcode;
	private String activeBatch;
	private String mrp;
	private String sellingPrice;
	private String hsnCode;
	private String taxGroupId;
	private String quantity;
	private String uomId;
	private String companyId;
	private Boolean isActive;
	private String name;
	private String description;
	private List<ProductAttributesModel> productAttributeModels = new ArrayList<ProductAttributesModel>();
	
	

	public List<ProductAttributesModel> getProductAttributeModels() {
		return productAttributeModels;
	}
	public void setProductAttributeModels(List<ProductAttributesModel> productAttributeModels) {
		this.productAttributeModels = productAttributeModels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getActiveBatch() {
		return activeBatch;
	}
	public void setActiveBatch(String activeBatch) {
		this.activeBatch = activeBatch;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getTaxGroupId() {
		return taxGroupId;
	}
	public void setTaxGroupId(String taxGroupId) {
		this.taxGroupId = taxGroupId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUomId() {
		return uomId;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
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
