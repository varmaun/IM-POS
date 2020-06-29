package com.impos.settings.model;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("codeGenModel")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CodeGenModel extends AbstractModel {

	private String prefix, suffix, name, codeFormat;
	private LocalDateTime version;
	private boolean isActive, codeFlag;
	private String companyId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeFormat() {
		return codeFormat;
	}

	public void setCodeFormat(String codeFormat) {
		this.codeFormat = codeFormat;
	}

	public boolean isCodeFlag() {
		return codeFlag;
	}

	public void setCodeFlag(boolean codeFlag) {
		this.codeFlag = codeFlag;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public LocalDateTime getVersion() {
		return version;
	}

	public void setVersion(LocalDateTime version) {
		this.version = version;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
