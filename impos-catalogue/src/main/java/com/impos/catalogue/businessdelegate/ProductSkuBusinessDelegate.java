package com.impos.catalogue.businessdelegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.catalogue.businessdelegate.context.ProductSkuContext;
import com.impos.catalogue.domain.Attribute;
import com.impos.catalogue.domain.Product;
import com.impos.catalogue.domain.ProductAttributes;
import com.impos.catalogue.domain.ProductSku;
import com.impos.catalogue.model.ProductAttributesModel;
import com.impos.catalogue.model.ProductSkuModel;
import com.impos.catalogue.service.IProductSkuService;
import com.impos.settings.domain.TaxGroup;

@Service
public class ProductSkuBusinessDelegate
		implements IBusinessDelegate<ProductSkuModel, ProductSkuContext, IKeyBuilder<String>, String> {

	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public ProductSkuModel create(ProductSkuModel model) {
		ProductSku productSku = new ProductSku();
		converter(model, productSku);
		productSkuService.create(productSku);
		converter(productSku, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductSkuContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductSkuModel edit(IKeyBuilder<String> keyBuilder, ProductSkuModel model) {
		if (model != null && model.getId() != null) {
			ProductSku productSku = new ProductSku();
			converter(model, productSku);
			productSkuService.updateProductSku(productSku);
			converter(productSku, model);
		}
		return model;
	}

	@Override
	public ProductSkuModel edit(IKeyBuilder<String> keyBuilder, ProductSkuModel model, ProductSkuContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSkuModel getByKey(IKeyBuilder<String> keyBuilder, ProductSkuContext context) {
		ProductSku productSku = productSkuService.getProductSku(keyBuilder.build().toString());
		ProductSkuModel model = new ProductSkuModel();
		converter(productSku, model);
		return model;
	}

	@Override
	public Collection<ProductSkuModel> getCollection(ProductSkuContext context) {
		List<ProductSkuModel> models = new ArrayList<ProductSkuModel>();
		for (ProductSku productSku : productSkuService.getAll(context)) {
			ProductSkuModel model = new ProductSkuModel();
			converter(productSku, model);
			models.add(model);
		}
		return models;
	}

	private void converter(ProductSku source, ProductSkuModel target) {

		BeanUtils.copyProperties(source, target);
		if (source.getMrp() != null) {
			target.setMrp(source.getMrp().toString());
		}
		if (source.getSellingPrice() != null) {
			target.setSellingPrice(source.getSellingPrice().toString());
		}
		if (source.getQuantity() != null) {
			target.setQuantity(source.getQuantity().toString());
		}

	}

	private void converter(ProductSkuModel source, ProductSku target) {

		BeanUtils.copyProperties(source, target);

		if (source.getMrp() != null) {
			target.setMrp(new BigDecimal(source.getMrp()));
		}
		if (source.getQuantity() != null) {
			target.setQuantity(Double.parseDouble(source.getQuantity()));
		}
		if (source.getSellingPrice() != null) {
			target.setSellingPrice(new BigDecimal(source.getSellingPrice()));
		}
		if (source.getTaxGroupId() != null) {
			TaxGroup taxGroup = new TaxGroup();
			taxGroup.setId(source.getTaxGroupId());
			target.setTaxGroup(taxGroup);
		}
		if (source.getProductId() != null) {
			Product product = new Product();
			product.setId(source.getProductId());
			target.setProduct(product);
		}
		if (!CollectionUtils.isEmpty(source.getProductAttributeModels())) {

			Set<ProductAttributes> productAttributes = new HashSet<ProductAttributes>();
			for (ProductAttributesModel paModel : source.getProductAttributeModels()) {
				ProductAttributes productAttribute = new ProductAttributes();
				Attribute attribute = new Attribute();
				if (paModel.getAttributeId() != null) {
					attribute.setId(paModel.getAttributeId());
				}
				if (paModel.getAttributeName() != null) {
					attribute.setName(paModel.getAttributeName());
				}
				if (paModel.getAttributeName() != null) {
					attribute.setValue(paModel.getAttributeValue());
				}
				if (paModel.getAttributeType() != null) {
					attribute.setType(paModel.getAttributeType());
				}
				if (paModel.getIsActive() != null) {
					attribute.setIsActive(paModel.getIsActive());
					productAttribute.setIsActive(paModel.getIsActive());
				}

				productAttribute.setSkuProduct(target);
				productAttribute.setAttribute(attribute);
				productAttributes.add(productAttribute);
			}
			target.setProductAttributes(productAttributes);
		}

	}
}
