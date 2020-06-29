package com.impos.settings.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.settings.domain.Department;
import com.impos.settings.model.DepartmentModel;
@Component("departmentModelToDepartmentConverter")
public class DepartmentModelToDepartmentConverter implements Converter<DepartmentModel,Department>{

	@Autowired
    private ObjectFactory<Department> departmentFactory;
    @Autowired
    private ConversionService conversionService;
	@Override
	public Department convert(DepartmentModel source) {
		Department department = departmentFactory.getObject();
		BeanUtils.copyProperties(source, department);
		return department;
	}

	  @Autowired
	    public void setDepartmentFactory(final ObjectFactory<Department> departmentFactory) {
	        this.departmentFactory = departmentFactory;
	    }
}
