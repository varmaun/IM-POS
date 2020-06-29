package com.impos.inventory.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.impos.catalogue.domain.ProductSku;
import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.domain.StockPoint;
import com.impos.settings.domain.UnitOfMeasurement;

@Component("stockLogItemsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockLogItemsModel extends AbstractModel {

	private String fromSku;
	private String toSku;
	private String quantity;
	private String units;
	private String uomId;
	private String fromSkuUom;
	private String toSkuUom;
	private String fromSkuQty;
	private String toSkuQty;
	private String fromStockPoint;
	private String toStockPoint;
	private String stockLogId;

	public String getFromSku() {
		return fromSku;
	}

	public void setFromSku(String fromSku) {
		this.fromSku = fromSku;
	}

	public String getToSku() {
		return toSku;
	}

	public void setToSku(String toSku) {
		this.toSku = toSku;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getFromSkuUom() {
		return fromSkuUom;
	}

	public void setFromSkuUom(String fromSkuUom) {
		this.fromSkuUom = fromSkuUom;
	}

	public String getToSkuUom() {
		return toSkuUom;
	}

	public void setToSkuUom(String toSkuUom) {
		this.toSkuUom = toSkuUom;
	}

	public String getFromSkuQty() {
		return fromSkuQty;
	}

	public void setFromSkuQty(String fromSkuQty) {
		this.fromSkuQty = fromSkuQty;
	}

	public String getToSkuQty() {
		return toSkuQty;
	}

	public void setToSkuQty(String toSkuQty) {
		this.toSkuQty = toSkuQty;
	}

	public String getFromStockPoint() {
		return fromStockPoint;
	}

	public void setFromStockPoint(String fromStockPoint) {
		this.fromStockPoint = fromStockPoint;
	}

	public String getToStockPoint() {
		return toStockPoint;
	}

	public void setToStockPoint(String toStockPoint) {
		this.toStockPoint = toStockPoint;
	}

	public String getStockLogId() {
		return stockLogId;
	}

	public void setStockLogId(String stockLogId) {
		this.stockLogId = stockLogId;
	}

}
