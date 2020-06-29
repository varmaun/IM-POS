package com.impos.catalogue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "attribute")
@Entity
@Component
public class Attribute extends AbstractDomain{
	
	private String name;
	private String value;
	private String type;
	private String companyId;
	private Boolean isActive;
	
	public Attribute() {
		
	}

	public Attribute(String name, String value, String type, String companyId, Boolean isActive) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
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
	@Column(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
