package com.impos.company.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.company.businessdelegate.context.CompanyBranchUsersContext;
import com.impos.company.domain.CompanyBranchUsers;
import com.impos.company.repository.CompanyBranchUsersRepository;
import com.impos.user.service.IUsersService;

/*
*@Author varma
*/
@Component
public class CompanyBranchUsersService implements ICompanyBranchUsersService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private CompanyBranchUsersRepository companyBranchUsersRepository;
	@Autowired
	private IUsersService userService;

	@Override
	public CompanyBranchUsers create(CompanyBranchUsers companyBranchUsers) {

		if (companyBranchUsers.getUserId() != null) {

			userService.create(companyBranchUsers.getUserId());

		}

		return companyBranchUsersRepository.save(companyBranchUsers);
	}

	@Override
	public void deleteCompanyBranchUsers(String companyBranchUsersId) {

	}

	@Override
	public CompanyBranchUsers getCompanyBranchUsers(String companyBranchUsersId) {

		return companyBranchUsersRepository.findById(companyBranchUsersId).orElse(null);
	}

	@Override
	public List<CompanyBranchUsers> getAll(CompanyBranchUsersContext context) {

		Specification<CompanyBranchUsers> companyBranchUserSpecification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty()) {

				if (context.getContextParams().get("compinyId") != null) {
					predicates.add(
							cb.equal(root.get("companyId").get("id"), context.getContextParams().get("compinyId")));
				}
				if (context.getContextParams().get("compinyBranchId") != null) {
					predicates.add(cb.equal(root.get("companyBranchId").get("id"),
							context.getContextParams().get("compinyBranchId")));
				}

			}

			;
			return cb.and(predicates.toArray(new Predicate[] {}));
		};

//		List<CompanyBranchUsers> companyBranchUsers = (List<CompanyBranchUsers>) companyBranchUsersRepository.findAll();

		return companyBranchUsersRepository.findAll(companyBranchUserSpecification);
	}

	@Override
	public CompanyBranchUsers updateCompanyBranchUsers(CompanyBranchUsers companyBranchUsers) {
		CompanyBranchUsers companyBranchUserss = getCompanyBranchUsers(companyBranchUsers.getId());
		try {
			nonNullBeanUtiles.copyProperties(companyBranchUserss, companyBranchUsers);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return companyBranchUsersRepository.save(companyBranchUserss);
	}

}
