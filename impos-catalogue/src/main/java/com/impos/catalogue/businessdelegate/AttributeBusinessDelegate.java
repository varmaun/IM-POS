package com.impos.catalogue.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.impos.catalogue.domain.Attribute;
import com.impos.catalogue.model.AttributeModel; 
import com.impos.catalogue.service.IAttributeService;
import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.catalogue.businessdelegate.context.AttributeContext;


@Service
public class AttributeBusinessDelegate implements IBusinessDelegate<AttributeModel,AttributeContext, IKeyBuilder<String>, String>{

	@Autowired
	private IAttributeService attributeService;
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public AttributeModel create(AttributeModel model) {
		Attribute attribute = new Attribute();
		converter(model, attribute);
		attributeService.create(attribute);
		converter(attribute, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, AttributeContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttributeModel edit(IKeyBuilder<String> keyBuilder, AttributeModel model) {
		if(model!=null && model.getId()!=null) {
			Attribute attribute = new Attribute();
			converter(model, attribute);
			attributeService.updateAttribute(attribute);
			converter(attribute, model);
		}
		return model;
	}

	@Override
	public AttributeModel edit(IKeyBuilder<String> keyBuilder, AttributeModel model, AttributeContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeModel getByKey(IKeyBuilder<String> keyBuilder, AttributeContext context) {
		Attribute attribute = attributeService.getAttribute(keyBuilder.build().toString());
		AttributeModel model = new AttributeModel();
		converter(attribute,model);
		return model;
	}

	@Override
	public Collection<AttributeModel> getCollection(AttributeContext context) {
		List<AttributeModel> models = new ArrayList<AttributeModel>();
		for(Attribute attribute:attributeService.getAll(context)) {
			AttributeModel model = new AttributeModel();
			converter(attribute,model);
			models.add(model);
		}
		return models;
	}
	private void converter(Attribute source,AttributeModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(AttributeModel source, Attribute target) {

		BeanUtils.copyProperties(source, target);
	}


}