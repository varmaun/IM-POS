package com.impos.company.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.company.businessdelegate.context.CompanyBranchContext;
import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;
import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.repository.CompanyBranchRepository;

/*
*@Author varma
*/
@Component
public class CompanyBranchService implements ICompanyBranchService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private CompanyBranchRepository companyBranchRepository;
	@Autowired
	private ICompanyBranchUsersService companyBranchUserService;

	@Override
	public CompanyBranch create(CompanyBranch companyBranch) {
		companyBranch = companyBranchRepository.save(companyBranch);
		if (CollectionUtils.isNotEmpty(companyBranch.getCompanyBranchUser())) {

			companyBranch.setCompanyBranchUser(addCompanyBranchuser(companyBranch));
		}

		return companyBranch;
	}

	private Set<CompanyBranchUsers> addCompanyBranchuser(CompanyBranch companyBranch) {
		Set<CompanyBranchUsers> companyBranhUsers = new HashSet<>();
		for (CompanyBranchUsers companyBranchUser : companyBranch.getCompanyBranchUser()) {
			companyBranchUser.setCompanyBranchId(companyBranch);
			companyBranchUser.setCompanyId(companyBranch.getCompanyId());
			companyBranhUsers.add(companyBranchUserService.create(companyBranchUser));

		}

		return companyBranhUsers;
	}

	@Override
	public void deleteCompanyBranch(String companyBranchId) {

	}

	@Override
	public CompanyBranch getCompanyBranch(String companyBranchId) {

		return companyBranchRepository.findById(companyBranchId).orElse(null);
	}

	@Override
	public List<CompanyBranch> getAll(CompanyBranchContext context) {
		Specification<CompanyBranch> companyBranchSpecification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty()) {
				if (context.getContextParams().get("companyId") != null) {
					predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
				}
				if (context.getContextParams().get("status") != null) {
					predicates.add(cb.equal(root.get("status"), context.getContextParams().get("status")));
				}
				if (context.getContextParams().get("gstNo") != null) {
					predicates.add(cb.equal(root.get("gstNo"), context.getContextParams().get("gstNo")));
				}
				if (context.getContextParams().get("franchiseCompanyId") != null) {
					predicates.add(cb.equal(root.get("franchiseCompanyId"),
							context.getContextParams().get("franchiseCompanyId")));
				}
				if (context.getContextParams().get("entityName") != null) {
					predicates.add(cb.equal(root.get("entityName"), context.getContextParams().get("entityName")));
				}
				if (context.getContextParams().get("branchType") != null) {
					predicates.add(cb.equal(root.get("branchType"), context.getContextParams().get("branchType")));
				}
			}
			return cb.and(predicates.toArray(new Predicate[] {}));

		};

		return companyBranchRepository.findAll(companyBranchSpecification);
	}

	@Override
	public CompanyBranch updateCompanyBranch(CompanyBranch companyBranch) {
		CompanyBranch companyBranchs = getCompanyBranch(companyBranch.getId());
		try {
			nonNullBeanUtiles.copyProperties(companyBranchs, companyBranch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return companyBranchRepository.save(companyBranchs);
	}

}
