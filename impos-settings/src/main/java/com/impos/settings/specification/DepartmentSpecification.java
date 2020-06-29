package com.impos.settings.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.impos.settings.domain.Department;

@Component
public class DepartmentSpecification {

	public static Specification<Department> getDeparmentSpecificationByStatus(Boolean isActive){
		
		return (root,query,cb) -> {
			return cb.equal(root.get("isActive"), isActive);
			
		};
		
	}
	public static Specification<Department> getDepartmentSpecificationByCompany(String companyId){
		
		return (root,query,cb) -> {
			
			return cb.equal(root.get("companyId"), companyId);
		};
	}
}
