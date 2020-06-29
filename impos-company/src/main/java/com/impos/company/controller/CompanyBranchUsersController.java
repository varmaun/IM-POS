package com.impos.company.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.avitcore.model.CollectionModelWrapper;
import com.avitcore.model.IModelWrapper;
import com.impos.company.businessdelegate.context.CompanyBranchUsersContext;
import com.impos.company.model.CompanyBranchUsersModel;

/**
 * @author Administrator
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/companybranchuser", produces = "application/json", consumes = "application/json")
public class CompanyBranchUsersController {

	private IBusinessDelegate<CompanyBranchUsersModel, CompanyBranchUsersContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<CompanyBranchUsersContext> companyBranchUsersContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<CompanyBranchUsersModel> createCompanyBranchUsers(
			@RequestBody CompanyBranchUsersModel companyBranchUsersModel) {
		companyBranchUsersModel = businessDelegate.create(companyBranchUsersModel);
		return new ResponseEntity<CompanyBranchUsersModel>(companyBranchUsersModel, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<CompanyBranchUsersModel> edit(@PathVariable(value = "id") final String companyBranchUsersId,
			@RequestBody CompanyBranchUsersModel companyBranchUsersModel) {

		companyBranchUsersModel = businessDelegate.edit(keyBuilderFactory.getObject().withId(companyBranchUsersId),
				companyBranchUsersModel);
		return new ResponseEntity<CompanyBranchUsersModel>(companyBranchUsersModel, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Collection<CompanyBranchUsersModel>> getAll(
			@RequestParam(value = "cid", required = false) final String compinyId,
			@RequestParam(value = "cbid", required = false) final String compinyBranchId) {
		CompanyBranchUsersContext companyBranchUsersContext = companyBranchUsersContextFactory.getObject();

		companyBranchUsersContext.getContextParams().put("compinyId", compinyId);
		companyBranchUsersContext.getContextParams().put("compinyBranchId", compinyBranchId);

		Collection<CompanyBranchUsersModel> companyBranchUsersModels = businessDelegate
				.getCollection(companyBranchUsersContext);

		return new ResponseEntity<Collection<CompanyBranchUsersModel>>(companyBranchUsersModels, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyBranchUsersModel> getCompanyBranchUsers(
			@PathVariable(value = "id") final String companyBranchUsersId) {
		CompanyBranchUsersContext companyBranchUsersContext = companyBranchUsersContextFactory.getObject();

		CompanyBranchUsersModel model = businessDelegate
				.getByKey(keyBuilderFactory.getObject().withId(companyBranchUsersId), companyBranchUsersContext);
		return new ResponseEntity<CompanyBranchUsersModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "companyBranchUsersBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<CompanyBranchUsersModel, CompanyBranchUsersContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setCompanyBranchUsersObjectFactory(
			final ObjectFactory<CompanyBranchUsersContext> companyBranchUsersContextFactory) {
		this.companyBranchUsersContextFactory = companyBranchUsersContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
