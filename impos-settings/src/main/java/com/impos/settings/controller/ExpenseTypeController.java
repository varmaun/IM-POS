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
import com.impos.settings.businessdelegate.context.ExpenseTypeContext;
import com.impos.settings.model.ExpenseTypeModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/expenseType", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class ExpenseTypeController {

	private IBusinessDelegate<ExpenseTypeModel, ExpenseTypeContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<ExpenseTypeContext> expenseTypeContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<ExpenseTypeModel> createExpenseType(@RequestBody ExpenseTypeModel expenseType) {
		businessDelegate.create(expenseType);
		return new ResponseEntity<>(expenseType, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ExpenseTypeModel> getExpenseType(@PathVariable("id") final String expenseTypeId) {
		ExpenseTypeContext context = expenseTypeContextFactory.getObject();
		ExpenseTypeModel expenseTypeModel = businessDelegate
				.getByKey(keyBuilderFactory.getObject().withId(expenseTypeId), context);

		return new ResponseEntity<ExpenseTypeModel>(expenseTypeModel, HttpStatus.OK);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<ExpenseTypeModel>> getExpenseTypes(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		ExpenseTypeContext context = expenseTypeContextFactory.getObject();
		context.getContextParams().put("status", status);
		context.getContextParams().put("companyId", companyId);
		List<ExpenseTypeModel> models = (List<ExpenseTypeModel>) businessDelegate.getCollection(context);
		return new ResponseEntity<List<ExpenseTypeModel>>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<ExpenseTypeModel> editExpenseType(@PathVariable(value = "id") final String departmentId,
			@RequestBody ExpenseTypeModel expenseTypeModel) {
		expenseTypeModel = businessDelegate.edit(null, expenseTypeModel);
		return new ResponseEntity<>(expenseTypeModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "expenseTypeBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<ExpenseTypeModel, ExpenseTypeContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setExpenseTypeObjectFactory(final ObjectFactory<ExpenseTypeContext> expenseTypeContextFactory) {
		this.expenseTypeContextFactory = expenseTypeContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
