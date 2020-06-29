package com.impos.company.controller;

import java.util.List;

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
import com.impos.company.businessdelegate.context.CompanyContext;
import com.impos.company.model.CompanyModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/company", produces = "application/json", consumes = "application/json")
public class CompanyController {

	private IBusinessDelegate<CompanyModel, CompanyContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<CompanyContext> companyContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<CompanyModel> createCompany(@RequestBody CompanyModel company) {

		businessDelegate.create(company);
		return new ResponseEntity<>(company, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyModel> getCompany(@PathVariable(value = "id") final String companyId) {
		CompanyContext departmentContext = companyContextFactory.getObject();
		CompanyModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(companyId),
				departmentContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<CompanyModel>> getDepartments(
			@RequestParam(value = "status", required = false) final Boolean status,
			@RequestParam(value = "gstno", required = false) final String gstNo,
			@RequestParam(value = "en", required = false) final String entityName) {
		CompanyContext companyContext = companyContextFactory.getObject();
		companyContext.getContextParams().put("status", status);
		companyContext.getContextParams().put("gstNo", gstNo);
		companyContext.getContextParams().put("entityName", entityName);
		List<CompanyModel> models = (List<CompanyModel>) businessDelegate.getCollection(companyContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<CompanyModel> editDepartment(@PathVariable(value = "id") final String companyId,
			@RequestBody CompanyModel companyModel) {
		companyModel = businessDelegate.edit(null, companyModel);
		return new ResponseEntity<>(companyModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "companyBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<CompanyModel, CompanyContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setCompanyObjectFactory(final ObjectFactory<CompanyContext> companyContextFactory) {
		this.companyContextFactory = companyContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
