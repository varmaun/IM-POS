package com.impos.settings.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.ExpenseTypeContext;
import com.impos.settings.domain.Department;
import com.impos.settings.domain.ExpenseType;
import com.impos.settings.model.DepartmentModel;
import com.impos.settings.model.ExpenseTypeModel;
import com.impos.settings.service.IExpenseTypeService;

@Service
public class ExpenseTypeBusinessDelegate  implements IBusinessDelegate<ExpenseTypeModel, ExpenseTypeContext, IKeyBuilder<String>, String>{
    
	@Autowired
	private IExpenseTypeService expenseTypeService;
	@Override
	public ExpenseTypeModel create(ExpenseTypeModel model) {
		ExpenseType expenseType = new ExpenseType();
		converter(model,expenseType);
		expenseTypeService.create(expenseType);
		converter(expenseType,model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ExpenseTypeContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExpenseTypeModel edit(IKeyBuilder<String> keyBuilder, ExpenseTypeModel model) {
		if(model!=null && model.getId()!=null) {
//			 existingDepartment = departmentService.getDepartment(model.getId());
			ExpenseType expenseType = new ExpenseType();
			converter(model,expenseType);
			expenseTypeService.updateExpenseType(expenseType);
			converter(expenseType,model);
		}
		return model;
	}

	@Override
	public ExpenseTypeModel edit(IKeyBuilder<String> keyBuilder, ExpenseTypeModel model, ExpenseTypeContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseTypeModel getByKey(IKeyBuilder<String> keyBuilder, ExpenseTypeContext context) {
		ExpenseType expenseType = expenseTypeService.getExpenseType(keyBuilder.build().toString());
		ExpenseTypeModel model = new ExpenseTypeModel();
		converter(expenseType,model);
		return model;
	}

	@Override
	public Collection<ExpenseTypeModel> getCollection(ExpenseTypeContext context) {
		List<ExpenseTypeModel> models = new ArrayList<ExpenseTypeModel>();
		for(ExpenseType expenseType:expenseTypeService.getAll(context)) {
			ExpenseTypeModel model = new ExpenseTypeModel();
			converter(expenseType,model);
			models.add(model);
		}
		return models;
	}
	
	private void converter(ExpenseType source, ExpenseTypeModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(ExpenseTypeModel source, ExpenseType target) {

		BeanUtils.copyProperties(source, target);
	}

}
