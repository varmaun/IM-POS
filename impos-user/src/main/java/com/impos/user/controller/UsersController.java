package com.impos.user.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.user.businessdelegate.context.UsersContext;
import com.impos.user.model.UsersModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/users", produces = "application/json", consumes = "application/json")
public class UsersController {

	private IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<UsersContext> usersContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<UsersModel> createUsers(@RequestBody UsersModel usersModel) {
		usersModel = businessDelegate.create(usersModel);
		return new ResponseEntity<UsersModel>(usersModel, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<UsersModel> edit(@PathVariable(value = "id") final String usersId,
			@RequestBody UsersModel usersModel) {

		usersModel = businessDelegate.edit(keyBuilderFactory.getObject().withId(usersId), usersModel);
		return new ResponseEntity<UsersModel>(usersModel, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Collection<UsersModel>> getAll() {
		UsersContext usersContext = usersContextFactory.getObject();
		Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);

		return new ResponseEntity<Collection<UsersModel>>(usersModels, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsersModel> getUsers(@PathVariable(value = "id") final String usersId) {
		UsersContext usersContext = usersContextFactory.getObject();

		UsersModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(usersId), usersContext);
		return new ResponseEntity<UsersModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "usersBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setUsersObjectFactory(final ObjectFactory<UsersContext> usersContextFactory) {
		this.usersContextFactory = usersContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
