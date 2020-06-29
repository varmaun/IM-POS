package com.impos.party.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.party.businessdelegate.context.PartyContext;
import com.impos.party.domain.Party;
import com.impos.party.model.PartyModel;
import com.impos.party.service.IPartyService;

@Service
public class PartyBusinessDelegate
implements IBusinessDelegate<PartyModel,PartyContext, IKeyBuilder<String>, String>{
    

	@Autowired
	private IPartyService partyService;
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public PartyModel create(PartyModel model) {
		Party party = new Party();
		converter(model, party);
		partyService.create(party);
		converter(party, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, PartyContext context) {
		
	}

	@Override
	public PartyModel edit(IKeyBuilder<String> keyBuilder, PartyModel model) {
		if(model!=null && model.getId()!=null) {
//			 existingDepartment = departmentService.getDepartment(model.getId());
			Party party = new Party();
			converter(model,party);
			partyService.updateParty(party);
			converter(party,model);
		}
		return model;
	}

	@Override
	public PartyModel edit(IKeyBuilder<String> keyBuilder, PartyModel model, PartyContext context) {
	   return null;
	}

	@Override
	public PartyModel getByKey(IKeyBuilder<String> keyBuilder, PartyContext context) {
		Party party = partyService.getParty(keyBuilder.build().toString());
		PartyModel model = new PartyModel();
		converter(party,model);
		return model;
	}

	@Override
	public Collection<PartyModel> getCollection(PartyContext context) {
		List<PartyModel> models = new ArrayList<PartyModel>();
		for(Party party:partyService.getAll(context)) {
			PartyModel model = new PartyModel();
			converter(party,model);
			models.add(model);
		}
		return models;
	}

	private void converter(Party source,PartyModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(PartyModel source, Party target) {

		BeanUtils.copyProperties(source, target);
	}

}
