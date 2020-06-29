package com.impos.catalogue.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "product")
@Entity
@Component
public class Product extends AbstractDomain {

	private String name;
	private Category category;
	private Brand brand;
	private String companyId;
	private Boolean isActive;

	Set<ProductSku> skuProducts = new HashSet<ProductSku>(0);

	public Product() {

	}

	public Product(String name, String companyId, Boolean isActive, Set<ProductSku> skuProducts) {
		super();
		this.name = name;

		this.companyId = companyId;
		this.isActive = isActive;
		this.skuProducts = skuProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
	public Set<ProductSku> getSkuProducts() {
		return skuProducts;
	}

	public void setSkuProducts(Set<ProductSku> skuProducts) {
		this.skuProducts = skuProducts;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

}
