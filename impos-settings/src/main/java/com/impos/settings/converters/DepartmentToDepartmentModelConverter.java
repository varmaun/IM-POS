package com.impos.settings.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.settings.domain.Department;
import com.impos.settings.model.DepartmentModel;

@Component("departmentToDepartmentModelConverter")
public class DepartmentToDepartmentModelConverter implements Converter<Department, DepartmentModel> {

	@Autowired
	private ObjectFactory<DepartmentModel> departmentModelFactory;
	@Autowired
	private ConversionService conversionService;
	@Override
	public DepartmentModel convert(Department source) {
		
		DepartmentModel target = departmentModelFactory.getObject();
		BeanUtils.copyProperties(source, target);
		return target;
	}
	

	@Autowired
	public void setDepartmentModelFactory(
			final ObjectFactory<DepartmentModel> departmentModelFactory) {
		this.departmentModelFactory = departmentModelFactory;
	}

}
