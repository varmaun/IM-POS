package com.impos.catalogue.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "product_attributes")
@Entity
@Component
public class ProductAttributes extends AbstractDomain {

	private ProductSku skuProduct;
	private Attribute attribute;
	private Boolean isActive;

	public ProductAttributes() {

	}

	public ProductAttributes(Boolean isActive, Attribute attribute, ProductSku skuProduct) {
		super();
		this.attribute = attribute;
		this.skuProduct = skuProduct;
		this.isActive = isActive;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_sku_id")
	public ProductSku getSkuProduct() {
		return skuProduct;
	}

	public void setSkuProduct(ProductSku skuProduct) {
		this.skuProduct = skuProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "attribute_id")
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
