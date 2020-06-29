package com.impos.catalogue.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import com.avitcore.domain.AbstractDomain;

@Table(name = "brand")
@Entity
@Component
public class Brand extends AbstractDomain{
	
	private String name;
	private String companyId;
	private Boolean isActive;
	
	public Brand() {
		
	}

	public Brand(String name, String companyId, Boolean isActive) {
		super();
		this.name = name;
		this.companyId = companyId;
		this.isActive = isActive;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}

