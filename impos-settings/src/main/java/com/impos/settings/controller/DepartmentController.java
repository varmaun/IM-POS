package com.impos.settings.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.settings.businessdelegate.context.DepartmentContext;
import com.impos.settings.model.DepartmentModel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/department", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class DepartmentController {

	private IBusinessDelegate<DepartmentModel, DepartmentContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<DepartmentContext> departmentContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<DepartmentModel> createDepartment(@RequestBody DepartmentModel department) {

		businessDelegate.create(department);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentModel> getDepartment(@PathVariable(value = "id") final String departmentId) {
		DepartmentContext departmentContext = departmentContextFactory.getObject();
		DepartmentModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(departmentId), departmentContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<DepartmentModel>> getDepartments(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		DepartmentContext departmentContext = departmentContextFactory.getObject();
		departmentContext.getContextParams().put("status", status);
		departmentContext.getContextParams().put("companyId", companyId);
		List<DepartmentModel> models = (List<DepartmentModel>) businessDelegate.getCollection(departmentContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<DepartmentModel> editDepartment(@PathVariable(value = "id") final String departmentId,
			@RequestBody DepartmentModel departmentModel) {
		departmentModel = businessDelegate.edit(null, departmentModel);
		return new ResponseEntity<>(departmentModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "departmentBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<DepartmentModel, DepartmentContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setDepartmentObjectFactory(final ObjectFactory<DepartmentContext> departmentContextFactory) {
		this.departmentContextFactory = departmentContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
