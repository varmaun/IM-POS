package com.impos.settings.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.impos.company.domain.Company;

@Table(name = "code_gen")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class CodeGen extends AbstractDomain implements Serializable {
	@Column
	private String prefix, suffix, name, codeFormat;
	@Version
	private LocalDateTime version;
	@Column
	private boolean isActive, codeFlag;
	private Company companyId;

	public CodeGen() {

	}

	public CodeGen(String id, String name, String codeFormat, String prefix, String suffix, LocalDateTime version,
			boolean isActive, boolean codeFlag, Company companyId, LocalDateTime createdDate,
			LocalDateTime modifiedDate, String userCreated, String userModified) {
		this.id = id;
		this.name = name;
		this.codeFormat = codeFormat;
		this.prefix = prefix;
		this.suffix = suffix;
		this.version = version;
		this.codeFlag = codeFlag;
		this.isActive = isActive;
		this.companyId = companyId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.userCreated = userCreated;
		this.userModified = userModified;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

}
