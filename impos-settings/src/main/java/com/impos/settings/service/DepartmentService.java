package com.impos.settings.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.settings.businessdelegate.context.DepartmentContext;
import com.impos.settings.domain.Department;
import com.impos.settings.repository.DepartmentRepository;

/**
 * @author Jay
 *
 */
@Component
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public Department create(Department department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public void deleteDepartment(String departmentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department getDepartment(String departmentId) {

		return departmentRepository.findById(departmentId).orElse(null);
	}

	@Override
	public List<Department> getAll() {
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department) {
			if(department!=null) {
				Department departm = getDepartment(department.getId());
				try {
					nullAwareBeanUtils.copyProperties(departm, department);
					departmentRepository.save(departm);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return department;
	}

	@Override
	public List<Department> getAll(DepartmentContext context) {
		Specification<Department> departmentSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return departmentRepository.findAll(departmentSpecification);
	}

}
