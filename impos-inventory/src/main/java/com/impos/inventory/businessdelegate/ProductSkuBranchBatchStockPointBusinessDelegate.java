package com.impos.inventory.businessdelegate;

import static org.springframework.core.convert.TypeDescriptor.forObject;
import static org.springframework.core.convert.TypeDescriptor.valueOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.inventory.businessdelegate.context.ProductSkuBranchBatchStockPointContext;
import com.impos.inventory.converters.ProductSkuBranchBatchStockPointModelToProductSkuBranchBatchStockPointConverter;
import com.impos.inventory.converters.ProductSkuBranchBatchStockPointToProductSkuBranchBatchStockPointModelConverter;
import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.model.ProductSkuBranchBatchStockPointModel;
import com.impos.inventory.service.IProductSkuBranchBatchStockPointService;

/*
*@Author varma
*/

@Service
public class ProductSkuBranchBatchStockPointBusinessDelegate implements
		IBusinessDelegate<ProductSkuBranchBatchStockPointModel, ProductSkuBranchBatchStockPointContext, IKeyBuilder<String>, String> {

	@Autowired
	private IProductSkuBranchBatchStockPointService productSkuBranchBatchStockPointService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ProductSkuBranchBatchStockPointToProductSkuBranchBatchStockPointModelConverter domainToModelConverter;
	@Autowired
	private ProductSkuBranchBatchStockPointModelToProductSkuBranchBatchStockPointConverter modelToDomainConverter;

	@Override
	@Transactional
	public ProductSkuBranchBatchStockPointModel create(ProductSkuBranchBatchStockPointModel model) {
		ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointService
				.create((ProductSkuBranchBatchStockPoint) conversionService.convert(model, forObject(model),
						valueOf(ProductSkuBranchBatchStockPoint.class)));
		model = convertToProductSkuBranchBatchStockPointModel(productSkuBranchBatchStockPoint);
		return model;
	}

	private ProductSkuBranchBatchStockPointModel convertToProductSkuBranchBatchStockPointModel(
			ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint) {
		return (ProductSkuBranchBatchStockPointModel) domainToModelConverter.convert(productSkuBranchBatchStockPoint);
	}

	private ProductSkuBranchBatchStockPoint convertToProductSkuBranchBatchStockPoint(
			ProductSkuBranchBatchStockPointModel model) {
		return (ProductSkuBranchBatchStockPoint) modelToDomainConverter.convert(model);
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductSkuBranchBatchStockPointContext context) {

	}

	@Override
	public ProductSkuBranchBatchStockPointModel edit(IKeyBuilder<String> keyBuilder,
			ProductSkuBranchBatchStockPointModel model) {
		ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointService
				.getProductSkuBranchBatchStockPoint(keyBuilder.build().toString());

		productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointService.updateProductSkuBranchBatchStockPoint(
				(ProductSkuBranchBatchStockPoint) convertToProductSkuBranchBatchStockPoint(model));
		model = convertToProductSkuBranchBatchStockPointModel(productSkuBranchBatchStockPoint);

		return model;
	}

	@Override
	public ProductSkuBranchBatchStockPointModel getByKey(IKeyBuilder<String> keyBuilder,
			ProductSkuBranchBatchStockPointContext context) {
		ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointService
				.getProductSkuBranchBatchStockPoint(keyBuilder.build().toString());
		ProductSkuBranchBatchStockPointModel model = convertToProductSkuBranchBatchStockPointModel(productSkuBranchBatchStockPoint);
		return model;
	}

	@Override
	public Collection<ProductSkuBranchBatchStockPointModel> getCollection(
			ProductSkuBranchBatchStockPointContext context) {
		List<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoint = new ArrayList<ProductSkuBranchBatchStockPoint>();
		List<ProductSkuBranchBatchStockPointModel> productSkuBranchBatchStockPointModels = (List<ProductSkuBranchBatchStockPointModel>) conversionService
				.convert(productSkuBranchBatchStockPoint, TypeDescriptor.forObject(productSkuBranchBatchStockPoint),
						TypeDescriptor.collection(List.class,
								TypeDescriptor.valueOf(ProductSkuBranchBatchStockPointModel.class)));
		return productSkuBranchBatchStockPointModels;
	}

	@Override
	public ProductSkuBranchBatchStockPointModel edit(IKeyBuilder<String> keyBuilder,
			ProductSkuBranchBatchStockPointModel model, ProductSkuBranchBatchStockPointContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
