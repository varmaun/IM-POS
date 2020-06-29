package com.impos.company.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.company.businessdelegate.context.CompanyBranchContext;
import com.impos.company.model.CompanyBranchModel;

/**
 * @author Administrator
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/companybranch", produces = "application/json", consumes = "application/json")
public class CompanyBranchController {

	private IBusinessDelegate<CompanyBranchModel, CompanyBranchContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<CompanyBranchContext> companyBranchContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<CompanyBranchModel> createCompanyBranch(@RequestBody CompanyBranchModel companyBranchModel) {
		companyBranchModel = businessDelegate.create(companyBranchModel);
		return new ResponseEntity<CompanyBranchModel>(companyBranchModel, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<CompanyBranchModel> edit(@PathVariable(value = "id") final String companyBranchId,
			@RequestBody CompanyBranchModel companyBranchModel) {

		companyBranchModel = businessDelegate.edit(keyBuilderFactory.getObject().withId(companyBranchId),
				companyBranchModel);
		return new ResponseEntity<CompanyBranchModel>(companyBranchModel, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Collection<CompanyBranchModel>> getAll(
			@RequestParam(value = "companyid", required = false) final String companyId,
			@RequestParam(value = "isActive", required = false) final Boolean status,
			@RequestParam(value = "gstno", required = false) final String gstNo,
			@RequestParam(value = "fcid", required = false) final String franchiseCompanyId,
			@RequestParam(value = "en", required = false) final String entityName,
			@RequestParam(value = "bt", required = false) final String branchType) {
		CompanyBranchContext companyBranchContext = companyBranchContextFactory.getObject();
		companyBranchContext.getContextParams().put("companyId", companyId);
		companyBranchContext.getContextParams().put("status", status);
		companyBranchContext.getContextParams().put("gstNo", gstNo);
		companyBranchContext.getContextParams().put("franchiseCompanyId", franchiseCompanyId);
		companyBranchContext.getContextParams().put("entityName", entityName);
		companyBranchContext.getContextParams().put("branchType", branchType);
		Collection<CompanyBranchModel> companyBranchModels = businessDelegate.getCollection(companyBranchContext);
		return new ResponseEntity<Collection<CompanyBranchModel>>(companyBranchModels, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyBranchModel> getCompanyBranch(
			@PathVariable(value = "id") final String companyBranchId) {
		CompanyBranchContext companyBranchContext = companyBranchContextFactory.getObject();

		CompanyBranchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(companyBranchId),
				companyBranchContext);
		return new ResponseEntity<CompanyBranchModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "companyBranchBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<CompanyBranchModel, CompanyBranchContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setCompanyBranchObjectFactory(final ObjectFactory<CompanyBranchContext> companyBranchContextFactory) {
		this.companyBranchContextFactory = companyBranchContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
