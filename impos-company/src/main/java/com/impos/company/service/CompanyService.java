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
import com.impos.company.businessdelegate.context.CompanyContext;
import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;
import com.impos.company.repository.CompanyBranchRepository;
import com.impos.company.repository.CompanyRepository;

@Component
public class CompanyService implements ICompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	@Autowired
	private CompanyBranchRepository companyBranchesRepository;
	@Autowired
	private ICompanyBranchService companyBranchService;

	@Override
	public Company create(Company company) {
		company = companyRepository.save(company);
		if (CollectionUtils.isNotEmpty(company.getCompanyBranchs())) {
			company.setCompanyBranchs(addCompanyBranchs(company, company.getCompanyBranchs()));

		}

		return company;
	}

	private Set<CompanyBranch> addCompanyBranchs(Company company, Set<CompanyBranch> companyBranchs) {
		Set<CompanyBranch> companyBraches1 = new HashSet<>();

		for (CompanyBranch branch : companyBranchs) {
			branch.setCompanyId(company);
			branch = companyBranchService.create(branch);
			companyBraches1.add(branch);
		}
//		companyBranchesRepository.saveAll(companyBraches1);
		return companyBraches1;
	}

	@Override
	public void deleteCompany(String companyId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompany(String companyId) {

		return companyRepository.findById(companyId).orElse(null);
	}

	@Override
	public List<Company> getAll() {
		return (List<Company>) companyRepository.findAll();
	}

	@Override
	public Company updateCompany(Company company) {
		if (company != null) {
			Company company1 = getCompany(company.getId());
			try {
				nullAwareBeanUtils.copyProperties(company1, company);
				companyRepository.save(company1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return company;
	}

	@Override
	public List<Company> getAll(CompanyContext context) {
		Specification<Company> companyBranchSpecification = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty()) {

				if (context.getContextParams().get("status") != null) {
					predicates.add(cb.equal(root.get("status"), context.getContextParams().get("status")));
				}
				if (context.getContextParams().get("gstNo") != null) {
					predicates.add(cb.equal(root.get("gstNo"), context.getContextParams().get("gstNo")));
				}

				if (context.getContextParams().get("entityName") != null) {
					predicates.add(cb.equal(root.get("entityName"), context.getContextParams().get("entityName")));
				}

			}
			return cb.and(predicates.toArray(new Predicate[] {}));

		};
		return companyRepository.findAll(companyBranchSpecification);
	}

}
