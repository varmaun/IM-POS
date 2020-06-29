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
import com.impos.catalogue.businessdelegate.context.ProductContext;
import com.impos.catalogue.domain.Attribute;
import com.impos.catalogue.domain.Brand;
import com.impos.catalogue.domain.Category;
import com.impos.catalogue.domain.Product;
import com.impos.catalogue.domain.ProductAttributes;
import com.impos.catalogue.domain.ProductSku;
import com.impos.catalogue.model.ProductAttributesModel;
import com.impos.catalogue.model.ProductModel;
import com.impos.catalogue.model.ProductSkuModel;
import com.impos.catalogue.service.IProductService;
import com.impos.settings.domain.TaxGroup;

@Service
public class ProductBusinessDelegate
		implements IBusinessDelegate<ProductModel, ProductContext, IKeyBuilder<String>, String> {

	@Autowired
	private IProductService productService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public ProductModel create(ProductModel model) {
		Product product = new Product();
		converter(model, product);
		productService.create(product);
		converter(product, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductModel edit(IKeyBuilder<String> keyBuilder, ProductModel model) {
		if (model != null && model.getId() != null) {
			Product product = new Product();
			converter(model, product);
			productService.updateProduct(product);
			converter(product, model);
		}
		return model;
	}

	@Override
	public ProductModel edit(IKeyBuilder<String> keyBuilder, ProductModel model, ProductContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel getByKey(IKeyBuilder<String> keyBuilder, ProductContext context) {
		Product party = productService.getProduct(keyBuilder.build().toString());
		ProductModel model = new ProductModel();
		converter(party, model);
		return model;
	}

	@Override
	public Collection<ProductModel> getCollection(ProductContext context) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productService.getAll(context)) {
			ProductModel model = new ProductModel();
			converter(product, model);
			models.add(model);
		}
		return models;
	}

	private void converter(Product source, ProductModel target) {

		BeanUtils.copyProperties(source, target);

	}

	private void converter(ProductModel source, Product target) {

		BeanUtils.copyProperties(source, target);
		if (source.getCategoryId() != null) {
			Category category = new Category();
			category.setId(source.getCategoryId());
			target.setCategory(category);
		}
		if (source.getBrandId() != null) {
			Brand brand = new Brand();
			brand.setId(source.getBrandId());
			target.setBrand(brand);
		}

		if (CollectionUtils.isNotEmpty(source.getSkuProductModels())) {

			Set<ProductSku> skuProducts = new HashSet<ProductSku>();
			for (ProductSkuModel model : source.getSkuProductModels()) {
				ProductSku skuProduct = new ProductSku();
				BeanUtils.copyProperties(model, skuProduct);
				if (model.getMrp() != null) {
					skuProduct.setMrp(new BigDecimal(model.getMrp()));
				}
				if (model.getQuantity() != null) {
					skuProduct.setQuantity(Double.parseDouble(model.getQuantity()));
				}
				if (model.getSellingPrice() != null) {
					skuProduct.setSellingPrice(new BigDecimal(model.getSellingPrice()));
				}
				if (model.getTaxGroupId() != null) {
					TaxGroup taxGroup = new TaxGroup();
					taxGroup.setId(model.getTaxGroupId());
					skuProduct.setTaxGroup(taxGroup);
				}
				skuProduct.setProduct(target);
				if (!CollectionUtils.isEmpty(model.getProductAttributeModels())) {

					Set<ProductAttributes> productAttributes = new HashSet<ProductAttributes>();
					for (ProductAttributesModel paModel : model.getProductAttributeModels()) {
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
						if(paModel.getAttributeType()!=null) {
							attribute.setType(paModel.getAttributeType());
						}
						if(paModel.getIsActive()!=null) {
							attribute.setIsActive(paModel.getIsActive());
							productAttribute.setIsActive(paModel.getIsActive());
						}
						
						productAttribute.setSkuProduct(skuProduct);
						productAttribute.setAttribute(attribute);
						productAttributes.add(productAttribute);
					}
					skuProduct.setProductAttributes(productAttributes);
				}
				skuProducts.add(skuProduct);
			}
			target.setSkuProducts(skuProducts);
		}
	}

}
