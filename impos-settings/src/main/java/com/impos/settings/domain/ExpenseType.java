
package com.impos.settings.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.avitcore.domain.AbstractDomain;

@Table(name = "expense_type")
@Entity
public class ExpenseType extends AbstractDomain {

	private String name;
	private Boolean isActive;
	private String companyId;
	private String description;
	
	

	public ExpenseType() {
	}

	public ExpenseType(String name, Boolean isActive, String companyId,String description) {
		super();
		this.name = name;
		this.isActive = isActive;
		this.companyId = companyId;
		this.description = description;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "company_id")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
