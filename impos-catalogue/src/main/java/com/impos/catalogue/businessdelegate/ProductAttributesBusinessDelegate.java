package com.impos.catalogue.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.catalogue.businessdelegate.context.ProductAttributesContext;
import com.impos.catalogue.model.ProductAttributesModel;
import com.impos.catalogue.service.IProductAttributesService;
import com.impos.catalogue.domain.ProductAttributes;

@Service
public class ProductAttributesBusinessDelegate 
implements IBusinessDelegate<ProductAttributesModel,ProductAttributesContext, IKeyBuilder<String>, String>{

	@Autowired
	private IProductAttributesService productAttributesService;
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public ProductAttributesModel create(ProductAttributesModel model) {
		ProductAttributes productAttributes = new ProductAttributes();
		converter(model, productAttributes);
		productAttributesService.create(productAttributes);
		converter(productAttributes, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductAttributesContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductAttributesModel edit(IKeyBuilder<String> keyBuilder, ProductAttributesModel model) {
		if(model!=null && model.getId()!=null) {
			ProductAttributes productAttributes = new ProductAttributes();
			converter(model,productAttributes);
			productAttributesService.updateProductAttributes(productAttributes);
			converter(productAttributes,model);
		}
		return model;
	}

	@Override
	public ProductAttributesModel edit(IKeyBuilder<String> keyBuilder,ProductAttributesModel model,ProductAttributesContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductAttributesModel getByKey(IKeyBuilder<String> keyBuilder, ProductAttributesContext context) {
		ProductAttributes productAttributes = productAttributesService.getProductAttributes(keyBuilder.build().toString());
		ProductAttributesModel model = new ProductAttributesModel();
		converter(productAttributes,model);
		return model;
	}

	@Override
	public Collection<ProductAttributesModel> getCollection(ProductAttributesContext context) {
		List<ProductAttributesModel> models = new ArrayList<ProductAttributesModel>();
		for(ProductAttributes productAttributes:productAttributesService.getAll(context)) {
			ProductAttributesModel model = new ProductAttributesModel();
			converter(productAttributes,model);
			models.add(model);
		}
		return models;
	}
	
	private void converter(ProductAttributes source,ProductAttributesModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(ProductAttributesModel source, ProductAttributes target) {

		BeanUtils.copyProperties(source, target);
	}


}
