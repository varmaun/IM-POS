package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.impos.catalogue.service.IAttributeService;
import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.AttributeContext;
import com.impos.catalogue.domain.Attribute;
import com.impos.catalogue.repository.AttributeRepository;

/**
 * @author Jay
 *
 */
@Component
public class AttributeService implements IAttributeService{
	
	@Autowired
	private AttributeRepository attributeRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	
	
	@Override
	public Attribute create(Attribute attribute) {
		attributeRepository.save(attribute);
		return attribute;
	}
	@Override
	public void deleteAttribute(String partyId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Attribute getAttribute(String attributeId) {
		// TODO Auto-generated method stub
		return attributeRepository.findById(attributeId).orElse(null);
	}
	@Override
	public List<Attribute> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Attribute updateAttribute(Attribute attribute) {
		if(attribute!=null) {
			Attribute attributem = getAttribute(attribute.getId());
			try {
				nullAwareBeanUtils.copyProperties(attributem, attribute);
				attributeRepository.save(attributem);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return attribute;
	}
	
	@Override
	public List<Attribute> getAll(AttributeContext context) {
		Specification<Attribute> attributeSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return attributeRepository.findAll(attributeSpecification);
	}

}
