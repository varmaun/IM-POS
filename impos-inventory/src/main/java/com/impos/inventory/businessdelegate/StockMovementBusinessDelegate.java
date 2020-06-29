package com.impos.inventory.businessdelegate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.converters.DateConverter;
import com.avitcore.exception.RecordNotFoundException;
import com.impos.catalogue.domain.ProductSku;
import com.impos.company.domain.CompanyBranch;
import com.impos.inventory.businessdelegate.context.StockMovementContext;
import com.impos.inventory.domain.Batch;
import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.domain.StockPoint;
import com.impos.inventory.model.StockMovementModel;
import com.impos.inventory.service.ProductSkuBranchBatchStockPointService;
import com.impos.inventory.service.ProductSkuBranchStockPointService;
import com.impos.inventory.service.StockLogsService;
import com.impos.settings.domain.UnitOfMeasurement;

@Service
public class StockMovementBusinessDelegate
		implements IBusinessDelegate<StockMovementModel, StockMovementContext, IKeyBuilder<String>, String> {

	@Autowired
	private ProductSkuBranchBatchStockPointService productSkuBranchBSPointService;
	@Autowired
	private ProductSkuBranchStockPointService productSkuBranchSPointService;
	@Autowired
	private StockLogsService stockLogsService;

	@Override
	@Transactional
	public StockMovementModel create(StockMovementModel model) {

		try {
			/*
			 * ProductSkuBranchBatchStockPoint and ProductSkuBranchStockPoint create based
			 * on stock movement
			 */
			ProductSkuBranchBatchStockPoint productStockBBatchSPoint = new ProductSkuBranchBatchStockPoint();
			ProductSkuBranchStockPoint productSkuBranchSPoint = new ProductSkuBranchStockPoint();
			String batchId = model.getBatchId() != null ? model.getBatchId() : null;
			String companyBranchId = model.getCompanyBranchId() != null ? model.getCompanyBranchId() : null;
			String productSkuId = model.getProductSkuId() != null ? model.getProductSkuId() : null;
			String uomId = model.getUomId() != null ? model.getUomId() : null;
			String toStockPointId = model.getToStockPoint() != null ? model.getToStockPoint() : null;
			String fromStockPointId = model.getFromStockPoint()!=null? model.getFromStockPoint():null;
			String unit = model.getUnits() != null ? model.getUnits() : null;
			String quantity = model.getQuantity() != null ? model.getQuantity() : null;
			String nonSellableUnits = model.getNonSellableUnits() != null ? model.getNonSellableUnits() : null;
			String expDate = model.getExpiryDate() != null ? model.getExpiryDate() : null;

			if (batchId != null) {
				Batch batch = new Batch();
				batch.setId(model.getBatchId());
				productStockBBatchSPoint.setBatchId(batch);
			}
			if (companyBranchId != null) {
				CompanyBranch companyBranch = new CompanyBranch();
				companyBranch.setId(model.getCompanyBranchId());
				productStockBBatchSPoint.setCompnayBranchId(companyBranch);
				productSkuBranchSPoint.setCompanyBranchId(companyBranch);
			}
			if (productSkuId != null) {
				ProductSku productSku = new ProductSku();
				productSku.setId(model.getProductSkuId());
				productStockBBatchSPoint.setProductSkuId(productSku);
				productSkuBranchSPoint.setProductSkuId(productSku);
			}
			if (toStockPointId != null) {
				StockPoint sp = new StockPoint();
				sp.setId(model.getToStockPoint());
				productStockBBatchSPoint.setStockPointId(sp);
				productSkuBranchSPoint.setStockPointId(sp);
			}
			if (uomId != null) {
				UnitOfMeasurement uom = new UnitOfMeasurement();
				uom.setId(model.getUomId());
				productStockBBatchSPoint.setUomId(uom);
				productSkuBranchSPoint.setUomId(uom);
			}
			if (quantity != null) {
				Double qty = Double.parseDouble(model.getQuantity());
				productStockBBatchSPoint.setQuantity(qty);
				productSkuBranchSPoint.setQuantity(qty);
			}
			if (unit != null) {
				Double units = Double.parseDouble(model.getUnits());
				productStockBBatchSPoint.setUnits(units);
				productSkuBranchSPoint.setUnits(units);
			}
			if (nonSellableUnits != null) {
				Double nonSUnits = Double.parseDouble(model.getNonSellableUnits());
				productStockBBatchSPoint.setNonSellableUnits(nonSUnits);
				productSkuBranchSPoint.setNonSellableUnits(nonSUnits);
			}
			if (expDate != null) {
				LocalDate expiryDate = DateConverter.dateFormater(model.getExpiryDate());
				productStockBBatchSPoint.setExpiryDate(expiryDate);
				productSkuBranchSPoint.setExpiryDate(expiryDate);
			}
			/*
			 * Service call to create ProductSkuBranchBatchStockPoint
			 * Checking whether the product exists if exists update the qty and units
			 */
			ProductSkuBranchBatchStockPoint psbbspt = productSkuBranchBSPointService.getProductSkuBranchBatchStockPointByContext(batchId, companyBranchId, fromStockPointId, uomId,
					productSkuId);
			if(psbbspt!=null && !psbbspt.getId().isEmpty()) {
				Double units = Double.parseDouble(model.getUnits());
				Double oldUnits = psbbspt.getUnits();
				psbbspt.setUnits(oldUnits+units);
				Double qty = Double.parseDouble(model.getQuantity());
				Double oldQty = psbbspt.getQuantity();
				psbbspt.setQuantity(oldQty+qty);
				productStockBBatchSPoint = productSkuBranchBSPointService.create(psbbspt);
			}else {
			productStockBBatchSPoint = productSkuBranchBSPointService.create(productStockBBatchSPoint);
			}
			/*
			 * Service call to create ProductSkuBranchStockPoint
			 * Checking whether the product exists if exists update the qty and units
			 */
			ProductSkuBranchStockPoint psbspt = productSkuBranchSPointService.getProductSkuBranchStockPointByContext(companyBranchId, fromStockPointId, uomId,
					productSkuId);
			if(psbspt!=null && !psbspt.getId().isEmpty()) {
				Double units = Double.parseDouble(model.getUnits());
				Double oldUnits = psbspt.getUnits();
				psbspt.setUnits(oldUnits+units);
				Double qty = Double.parseDouble(model.getQuantity());
				Double oldQty = psbspt.getQuantity();
				psbspt.setQuantity(oldQty+qty);
				productSkuBranchSPoint = productSkuBranchSPointService.create(psbspt);
			}else {
				productSkuBranchSPoint = productSkuBranchSPointService.create(productSkuBranchSPoint);

			}
			
			Double qty = Double.parseDouble(model.getQuantity());
			Double units = Double.parseDouble(model.getUnits());

			/*
			 * Service call to update ProductSkuBranchBatchStockPoint
			 */
			if (productStockBBatchSPoint.getId() != null | !productStockBBatchSPoint.getId().isEmpty()) {
				ProductSkuBranchBatchStockPoint psbbsp = productSkuBranchBSPointService
						.getProductSkuBranchBatchStockPointByContext(batchId, companyBranchId, fromStockPointId, uomId,
								productSkuId);
				if (psbbsp != null) {
					Double oQty = psbbsp.getQuantity();
					Double nQty = oQty - qty;
					psbbsp.setQuantity(nQty);
					Double oUnits = psbbsp.getUnits();
					Double nUnits = oUnits - units;
					psbbsp.setUnits(nUnits);
					productSkuBranchBSPointService.updateProductSkuBranchBatchStockPoint(psbbsp);
				} else {
					throw new RecordNotFoundException("Record Not Found");
				}
			}

			/*
			 * Service call to update ProductSkuBranchStockPoint
			 */
			if (productSkuBranchSPoint.getId() != null | !productSkuBranchSPoint.getId().isEmpty()) {
				String fromStockPoint = model.getFromStockPoint() != null ? model.getFromStockPoint() : null;
				ProductSkuBranchStockPoint psbsp = productSkuBranchSPointService
						.getProductSkuBranchStockPointByContext(companyBranchId, fromStockPoint, uomId, productSkuId);
				if (psbsp != null) {
					Double oQty = psbsp.getQuantity();
					Double nQty = oQty - qty;
					psbsp.setQuantity(nQty);
					Double oUnits = psbsp.getUnits();
					Double nUnits = oUnits - units;
					psbsp.setUnits(nUnits);
					productSkuBranchSPointService.updateProductSkuBranchStockPoint(psbsp);
				} else {
					throw new RecordNotFoundException("Record Not Found");
				}
			}

			/*
			 * Service call to Create StockLogs and StockLogItems;
			 */
			StockLogs stockLog = new StockLogs();
			if (batchId != null) {
				Batch batch = new Batch();
				batch.setId(model.getBatchId());
				stockLog.setFromBatch(batch);
			}
			Set<StockLogItems> stockLogItems = new HashSet<StockLogItems>();
			StockLogItems stockLogItem = new StockLogItems();
			if (productSkuId != null) {
				ProductSku productSku = new ProductSku();
				productSku.setId(model.getProductSkuId());
				stockLogItem.setFromSku(productSku);
			}
			if (toStockPointId != null) {
				StockPoint sp = new StockPoint();
				sp.setId(model.getFromStockPoint());
				stockLogItem.setFromStockPoint(sp);
			}
			if (toStockPointId != null) {
				StockPoint sp = new StockPoint();
				sp.setId(model.getToStockPoint());
				stockLogItem.setToStockPoint(sp);
			}
			if (uomId != null) {
				UnitOfMeasurement uom = new UnitOfMeasurement();
				uom.setId(model.getUomId());
				stockLogItem.setUomId(uom);
			}
			if (quantity != null) {
				stockLogItem.setQuantity(qty);
			}
			if (unit != null) {
				stockLogItem.setUnits(units);
			}
			stockLogItems.add(stockLogItem);
			stockLog.setStockLogItems(stockLogItems);
			stockLog = stockLogsService.create(stockLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, StockMovementContext context) {
	}

	@Override
	public StockMovementModel edit(IKeyBuilder<String> keyBuilder, StockMovementModel model) {
		return null;
	}

	@Override
	public StockMovementModel edit(IKeyBuilder<String> keyBuilder, StockMovementModel model,
			StockMovementContext context) {
		return null;
	}

	@Override
	public StockMovementModel getByKey(IKeyBuilder<String> keyBuilder, StockMovementContext context) {
		return null;
	}

	@Override
	public Collection<StockMovementModel> getCollection(StockMovementContext context) {
		return null;
	}

}
