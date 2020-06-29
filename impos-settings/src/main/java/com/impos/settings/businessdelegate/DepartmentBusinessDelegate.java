package com.impos.settings.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.DepartmentContext;
import com.impos.settings.domain.Department;
import com.impos.settings.model.DepartmentModel;
import com.impos.settings.service.IDepartmentService;

@Service
public class DepartmentBusinessDelegate
		implements IBusinessDelegate<DepartmentModel, DepartmentContext, IKeyBuilder<String>, String> {

	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public DepartmentModel create(DepartmentModel model) {

		Department department = new Department();
//		conversionService.convert(model, Department.class);
		converter(model, department);
		departmentService.create(department);
		converter(department, model);

		/*
		 * Department department = departmentService.create((Department)
		 * conversionService .convert(model, forObject(model),
		 * valueOf(Department.class)));
		 */

//		Department department = new Department();
//		converter(model, department);
//		departmentService.create(department);

		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, DepartmentContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public DepartmentModel edit(IKeyBuilder<String> keyBuilder, DepartmentModel model) {
		
		if(model!=null && model.getId()!=null) {
//			 existingDepartment = departmentService.getDepartment(model.getId());
			Department department = new Department();
			converter(model,department);
			departmentService.updateDepartment(department);
			converter(department,model);
		}
		return model;
	}

	@Override
	public DepartmentModel edit(IKeyBuilder<String> keyBuilder, DepartmentModel model, DepartmentContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentModel getByKey(IKeyBuilder<String> keyBuilder, DepartmentContext context) {
		Department department = departmentService.getDepartment(keyBuilder.build().toString());
		DepartmentModel model = new DepartmentModel();
		converter(department,model);
		return model;
	}

	@Override
	public Collection<DepartmentModel> getCollection(DepartmentContext context) {
		List<DepartmentModel> models = new ArrayList<DepartmentModel>();
		for(Department department:departmentService.getAll(context)) {
			DepartmentModel model = new DepartmentModel();
			converter(department,model);
			models.add(model);
		}
		return models;
	}

	private void converter(Department source, DepartmentModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(DepartmentModel source, Department target) {

		BeanUtils.copyProperties(source, target);
	}

}
