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
import com.impos.inventory.businessdelegate.context.ProductSkuBranchStockPointContext;
import com.impos.inventory.converters.ProductSkuBranchStockPointModelToProductSkuBranchStockPointConverter;
import com.impos.inventory.converters.ProductSkuBranchStockPointToProductSkuBranchStockPointModelConverter;
import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.model.ProductSkuBranchStockPointModel;
import com.impos.inventory.service.IProductSkuBranchStockPointService;

/*
*@Author varma
*/

@Service

public class ProductSkuBranchStockPointBusinessDelegate implements
		IBusinessDelegate<ProductSkuBranchStockPointModel, ProductSkuBranchStockPointContext, IKeyBuilder<String>, String> {

	@Autowired
	private IProductSkuBranchStockPointService productSkuBranchStockPointService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ProductSkuBranchStockPointToProductSkuBranchStockPointModelConverter domainToModelConverter;
	@Autowired
	private ProductSkuBranchStockPointModelToProductSkuBranchStockPointConverter modelToDomainConverter;

	@Override
	@Transactional
	public ProductSkuBranchStockPointModel create(ProductSkuBranchStockPointModel model) {
		ProductSkuBranchStockPoint productSkuBranchStockPoint = productSkuBranchStockPointService
				.create((ProductSkuBranchStockPoint) conversionService.convert(model, forObject(model),
						valueOf(ProductSkuBranchStockPoint.class)));
		model = convertToProductSkuBranchStockPointModel(productSkuBranchStockPoint);
		return model;
	}

	private ProductSkuBranchStockPointModel convertToProductSkuBranchStockPointModel(
			ProductSkuBranchStockPoint productSkuBranchStockPoint) {
		return (ProductSkuBranchStockPointModel) domainToModelConverter.convert(productSkuBranchStockPoint);
	}

	private ProductSkuBranchStockPoint convertToProductSkuBranchStockPoint(ProductSkuBranchStockPointModel model) {
		return (ProductSkuBranchStockPoint) modelToDomainConverter.convert(model);
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductSkuBranchStockPointContext context) {

	}

	@Override
	public ProductSkuBranchStockPointModel edit(IKeyBuilder<String> keyBuilder, ProductSkuBranchStockPointModel model) {
		ProductSkuBranchStockPoint productSkuBranchStockPoint = productSkuBranchStockPointService
				.getProductSkuBranchStockPoint(keyBuilder.build().toString());

		productSkuBranchStockPoint = productSkuBranchStockPointService
				.updateProductSkuBranchStockPoint((ProductSkuBranchStockPoint) convertToProductSkuBranchStockPoint(model));
		model = convertToProductSkuBranchStockPointModel(productSkuBranchStockPoint);

		return model;
	}

	@Override
	public ProductSkuBranchStockPointModel getByKey(IKeyBuilder<String> keyBuilder,
			ProductSkuBranchStockPointContext context) {
		ProductSkuBranchStockPoint productSkuBranchStockPoint = productSkuBranchStockPointService
				.getProductSkuBranchStockPoint(keyBuilder.build().toString());
		ProductSkuBranchStockPointModel model = convertToProductSkuBranchStockPointModel(productSkuBranchStockPoint);
		return model;
	}

	@Override
	public Collection<ProductSkuBranchStockPointModel> getCollection(ProductSkuBranchStockPointContext context) {
		List<ProductSkuBranchStockPoint> productSkuBranchStockPoint = new ArrayList<ProductSkuBranchStockPoint>();

		List<ProductSkuBranchStockPointModel> productSkuBranchStockPointModels = (List<ProductSkuBranchStockPointModel>) conversionService
				.convert(productSkuBranchStockPoint, TypeDescriptor.forObject(productSkuBranchStockPoint),
						TypeDescriptor.collection(List.class,
								TypeDescriptor.valueOf(ProductSkuBranchStockPointModel.class)));
		return productSkuBranchStockPointModels;
	}

	@Override
	public ProductSkuBranchStockPointModel edit(IKeyBuilder<String> keyBuilder, ProductSkuBranchStockPointModel model,
			ProductSkuBranchStockPointContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
