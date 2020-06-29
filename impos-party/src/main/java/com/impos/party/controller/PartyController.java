package com.impos.party.controller;

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
import com.impos.party.businessdelegate.context.PartyContext;
import com.impos.party.model.PartyModel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/party", produces = "application/json", consumes = "application/json")

public class PartyController {
	private IBusinessDelegate<PartyModel, PartyContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<PartyContext> partyContextFactory;
	
	@PostMapping(value = "/create")
	public ResponseEntity<PartyModel> createParty(@RequestBody PartyModel party) {

		businessDelegate.create(party);
		return new ResponseEntity<>(party, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PartyModel> getParty(@PathVariable(value = "id") final String partyId) {
		PartyContext partyContext = partyContextFactory.getObject();
		PartyModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(partyId), partyContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<PartyModel>> getParty(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId,
			@RequestParam(value = "type", required = false) final String partyType) {
		PartyContext partyContext = partyContextFactory.getObject();
		partyContext.getContextParams().put("status", status);
		partyContext.getContextParams().put("companyId", companyId);
		partyContext.getContextParams().put("partyType", partyType);
		List<PartyModel> models = (List<PartyModel>) businessDelegate.getCollection(partyContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<PartyModel> editParty(@PathVariable(value = "id") final String partyId,
			@RequestBody PartyModel partyModel) {
		partyModel = businessDelegate.edit(null, partyModel);
		return new ResponseEntity<>(partyModel, HttpStatus.CREATED);
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "partyBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<PartyModel, PartyContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setPartyObjectFactory(final ObjectFactory<PartyContext> partyContextFactory) {
		this.partyContextFactory = partyContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
	


}
