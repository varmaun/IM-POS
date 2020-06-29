package com.impos.catalogue.domain;

import java.math.BigDecimal;
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
import com.impos.settings.domain.TaxGroup;

@Table(name = "product_sku")
@Entity
@Component
public class ProductSku extends AbstractDomain{
	
	private Product product;
	private String skuCode;
	private String barcode;
	private String activeBatch;
	private BigDecimal mrp;
	private BigDecimal sellingPrice;
	private String hsnCode;
	private TaxGroup taxGroup;
	private Double quantity;
	private String uomId;
	private String companyId;
	private Boolean isActive;
	private String name;
	private String description;
	private Set<ProductAttributes> productAttributes  = new HashSet<ProductAttributes>();
	public ProductSku() {
		
	}

	public ProductSku( String skuCode, String barcode, String activeBatch, BigDecimal mrp,
			BigDecimal sellingPrice, String hsnCode, String taxGroupId, Double quantity, String uomId,
			String companyId, Boolean isActive, Product product, TaxGroup taxGroup, Set<ProductAttributes> productAttributes) {
		super();
		this.product = product;
		this.skuCode = skuCode;
		this.barcode = barcode;
		this.activeBatch = activeBatch;
		this.mrp = mrp;
		this.sellingPrice = sellingPrice;
		this.hsnCode = hsnCode;
		this.quantity = quantity;
		this.uomId = uomId;
		this.companyId = companyId;
		this.isActive = isActive;
		this.taxGroup = taxGroup;
		this.productAttributes = productAttributes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "skuProduct", cascade = CascadeType.ALL)
	public Set<ProductAttributes> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(Set<ProductAttributes> productAttributes) {
		this.productAttributes = productAttributes;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "sku_code")
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	@Column(name = "barcode")
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	@Column(name = "active_batch")
	public String getActiveBatch() {
		return activeBatch;
	}

	public void setActiveBatch(String activeBatch) {
		this.activeBatch = activeBatch;
	}
	@Column(name = "mrp")
	public BigDecimal getMrp() {
		return mrp;
	}

	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}
	@Column(name = "selling_price")
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Column(name = "hsn_code")
	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	@JoinColumn(name = "tax_group_id")
	@ManyToOne(fetch = FetchType.LAZY)
	public TaxGroup getTaxGroup() {
		return taxGroup;
	}

	public void setTaxGroup(TaxGroup taxGroup) {
		this.taxGroup = taxGroup;
	}

	@Column(name = "quantity")
	public Double getQuantity() {
		return quantity;
	}

	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	@Column(name = "uom_id")
	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
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
