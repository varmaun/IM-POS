package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.businessdelegate.context.AttributeContext;
import com.impos.catalogue.domain.Attribute;

public interface IAttributeService {
	
	Attribute create(Attribute attribute);

	void deleteAttribute(String partyId);

	Attribute getAttribute(String attributeId);

	List<Attribute> getAll();

	Attribute updateAttribute(Attribute attribute);

	List<Attribute> getAll(AttributeContext attribute);

}
