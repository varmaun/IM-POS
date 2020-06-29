package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.DepartmentContext;
import com.impos.settings.domain.Department;

public interface IDepartmentService {

	Department create(Department department);

	void deleteDepartment(String departmentId);

	Department getDepartment(String departmentId);

	List<Department> getAll();

	Department updateDepartment(Department department);

	List<Department> getAll(DepartmentContext context);
}
