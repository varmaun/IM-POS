package com.impos.company.businessdelegate.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.businessdelegate.context.IBusinessDelegateContext;

/*
*@Author varma
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyBranchContext implements IBusinessDelegateContext {

	private Map<String, Object> contextParams = new HashMap<>();

	public Map<String, Object> getContextParams() {
		return contextParams;
	}

	public void setContextParams(Map<String, Object> contextParams) {
		this.contextParams = contextParams;
	}

	private String companyBranchId;

	public String getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(String companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

}
