package com.impos.company.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.impos.user.model.UsersModel;

@Component("companyBranchUsersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyBranchUsersModel extends AbstractModel {
	private String userId, companyId, companyBranchId;
	private UsersModel userModel;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(String companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

	public UsersModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UsersModel userModel) {
		this.userModel = userModel;
	}

}
