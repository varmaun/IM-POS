package com.impos.settings.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.settings.businessdelegate.context.UnitOfMeasurementContext;
import com.impos.settings.domain.Department;
import com.impos.settings.domain.UnitOfMeasurement;
import com.impos.settings.repository.UnitOfMeasurementRepository;

/**
 * @author Jay
 *
 */
@Component
public class UnitOfMeasurementService implements IUnitOfMeasurementService{
	
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	@Autowired
	private UnitOfMeasurementRepository unitOfMeasurementRepository;
	@Override
	public UnitOfMeasurement create(UnitOfMeasurement unitOfMeasurement) {
		unitOfMeasurementRepository.save(unitOfMeasurement);
		return unitOfMeasurement;
	}

	@Override
	public void deleteUnitOfMeasurement(String unitOfMeasurementId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UnitOfMeasurement getUnitOfMeasurement(String unitOfMeasurementId) {
		// TODO Auto-generated method stub
		return unitOfMeasurementRepository.findById(unitOfMeasurementId).orElse(null);
	}

	@Override
	public List<UnitOfMeasurement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOfMeasurement updateUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		if(unitOfMeasurement!=null) {
			UnitOfMeasurement uom = getUnitOfMeasurement(unitOfMeasurement.getId());
			try {
				nullAwareBeanUtils.copyProperties(uom, unitOfMeasurement);
				unitOfMeasurementRepository.save(uom);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return unitOfMeasurement;
	}

	@Override
	public List<UnitOfMeasurement> getAll(UnitOfMeasurementContext context) {
		Specification<UnitOfMeasurement> specification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return unitOfMeasurementRepository.findAll(specification);
	}
   
}
