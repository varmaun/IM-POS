package com.impos.party.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.party.businessdelegate.context.PartyContext;
import com.impos.party.domain.Party;
import com.impos.party.repository.PartyRepository;

/**
 * @author Jay
 *
 */
@Component
public class PartyService implements IPartyService{

	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public Party create(Party party) {
		partyRepository.save(party);
		return party;
	}
	@Override
	public void deleteParty(String partyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Party getParty(String partyId) {
		// TODO Auto-generated method stub
		return partyRepository.findById(partyId).orElse(null);
	}

	@Override
	public List<Party> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Party updateParty(Party party) {
		if(party!=null) {
			Party partym = getParty(party.getId());
			try {
				nullAwareBeanUtils.copyProperties(partym, party);
				partyRepository.save(partym);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return party;
	}

	@Override
	public List<Party> getAll(PartyContext context) {
		Specification<Party> partySpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("partyType") != null) {
				predicates.add(cb.equal(root.get("partyType"), context.getContextParams().get("partyType")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return partyRepository.findAll(partySpecification);
	}
	

}
