package com.impos.inventory.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.impos.catalogue.domain.ProductSku;
import com.impos.settings.domain.UnitOfMeasurement;

@Table(name = "stock_log_items")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class StockLogItems extends AbstractDomain implements Serializable {

	private ProductSku fromSku;
	private ProductSku toSku;
	private Double quantity;
	private Double units;
	private UnitOfMeasurement uomId;
	private String fromSkuUom;
	private String toSkuUom;
	private Double fromSkuQty;
	private Double toSkuQty;
	private StockPoint fromStockPoint;
	private StockPoint toStockPoint;
	private StockLogs stockLogId;

	public StockLogItems() {
	}

	public StockLogItems(String id, ProductSku fromSku, ProductSku toSku, Double quantity, Double units,
			UnitOfMeasurement uomId, String fromSkuUom, String toSkuUom, Double fromSkuQty, Double toSkuQty,
			StockPoint fromStockPoint, StockPoint toStockPoint, StockLogs stockLogId) {
		super();
		this.id = id;
		this.fromSku = fromSku;
		this.toSku = toSku;
		this.quantity = quantity;
		this.units = units;
		this.uomId = uomId;
		this.fromSkuUom = fromSkuUom;
		this.toSkuUom = toSkuUom;
		this.fromSkuQty = fromSkuQty;
		this.toSkuQty = toSkuQty;
		this.fromStockPoint = fromStockPoint;
		this.toStockPoint = toStockPoint;
		this.stockLogId = stockLogId;
	}

	public StockLogItems(String id, ProductSku fromSku, ProductSku toSku, Double quantity, Double units,
			UnitOfMeasurement uomId, String fromSkuUom, String toSkuUom, Double fromSkuQty, Double toSkuQty,
			StockPoint fromStockPoint, StockPoint toStockPoint, StockLogs stockLogId, String userCreated,
			String userModified, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		super();
		this.fromSku = fromSku;
		this.toSku = toSku;
		this.quantity = quantity;
		this.units = units;
		this.uomId = uomId;
		this.fromSkuUom = fromSkuUom;
		this.toSkuUom = toSkuUom;
		this.fromSkuQty = fromSkuQty;
		this.toSkuQty = toSkuQty;
		this.fromStockPoint = fromStockPoint;
		this.toStockPoint = toStockPoint;
		this.stockLogId = stockLogId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.userCreated = userCreated;
		this.userModified = userModified;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "product_sku_id")
	public ProductSku getFromSku() {
		return fromSku;
	}

	public void setFromSku(ProductSku fromSku) {
		this.fromSku = fromSku;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "product_sku_id")
	public ProductSku getToSku() {
		return toSku;
	}

	public void setToSku(ProductSku toSku) {
		this.toSku = toSku;
	}

	@Column
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Column
	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "uom_id")
	public UnitOfMeasurement getUomId() {
		return uomId;
	}

	public void setUomId(UnitOfMeasurement uomId) {
		this.uomId = uomId;
	}

	@Column
	public String getFromSkuUom() {
		return fromSkuUom;
	}

	public void setFromSkuUom(String fromSkuUom) {
		this.fromSkuUom = fromSkuUom;
	}

	@Column
	public String getToSkuUom() {
		return toSkuUom;
	}

	public void setToSkuUom(String toSkuUom) {
		this.toSkuUom = toSkuUom;
	}

	@Column
	public Double getFromSkuQty() {
		return fromSkuQty;
	}

	public void setFromSkuQty(Double fromSkuQty) {
		this.fromSkuQty = fromSkuQty;
	}

	@Column
	public Double getToSkuQty() {
		return toSkuQty;
	}

	public void setToSkuQty(Double toSkuQty) {
		this.toSkuQty = toSkuQty;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "stock_point_id")
	public StockPoint getFromStockPoint() {
		return fromStockPoint;
	}

	public void setFromStockPoint(StockPoint fromStockPoint) {
		this.fromStockPoint = fromStockPoint;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "stock_point_id")
	public StockPoint getToStockPoint() {
		return toStockPoint;
	}

	public void setToStockPoint(StockPoint toStockPoint) {
		this.toStockPoint = toStockPoint;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "stock_logs_id")
	public StockLogs getStockLogId() {
		return stockLogId;
	}

	public void setStockLogId(StockLogs stockLogId) {
		this.stockLogId = stockLogId;
	}

}
