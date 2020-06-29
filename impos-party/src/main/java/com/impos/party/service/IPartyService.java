package com.impos.party.service;

import java.util.List;

import com.impos.party.businessdelegate.context.PartyContext;
import com.impos.party.domain.Party;

public interface IPartyService {
	
	Party create(Party party);

	void deleteParty(String partyId);

	Party getParty(String partyId);

	List<Party> getAll();

	Party updateParty(Party party);

	List<Party> getAll(PartyContext context);

}
