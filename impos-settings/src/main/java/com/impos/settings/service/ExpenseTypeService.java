package com.impos.settings.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.settings.businessdelegate.context.ExpenseTypeContext;
import com.impos.settings.domain.ExpenseType;
import com.impos.settings.repository.ExpenseTypeRepository;

/**
 * @author Jay
 *
 */
@Component
public class ExpenseTypeService implements IExpenseTypeService {
	
	
	@Autowired
	private ExpenseTypeRepository expenseTypeRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	@Override
	public ExpenseType create(ExpenseType expenseType) {
		expenseTypeRepository.save(expenseType);
		return expenseType;
		
	}

	@Override
	public void deleteExpenseType(String expenseTypeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExpenseType getExpenseType(String expenseTypeId) {
		return expenseTypeRepository.findById(expenseTypeId).orElse(null);
	}

	@Override
	public List<ExpenseType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseType updateExpenseType(ExpenseType expenseType) {
		if(expenseType!=null) {
			ExpenseType expenseT = getExpenseType(expenseType.getId());
			try {
				nullAwareBeanUtils.copyProperties(expenseT, expenseType);
				expenseTypeRepository.save(expenseT);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return expenseType;
	}

	@Override
	public List<ExpenseType> getAll(ExpenseTypeContext context) {
		
		Specification<ExpenseType> expenseTypeSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return expenseTypeRepository.findAll(expenseTypeSpecification);
	}

	
	
}
