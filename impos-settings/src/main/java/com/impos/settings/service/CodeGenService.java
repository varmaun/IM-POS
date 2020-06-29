package com.impos.settings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.impos.settings.businessdelegate.context.CodeGenContext;
import com.impos.settings.domain.CodeGen;
import com.impos.settings.repository.CodeGenRepository;

@Component
public class CodeGenService implements ICodeGenService {

	@Autowired
	private CodeGenRepository codeGenRepository;

	@Override
	public CodeGen create(CodeGen codeGen) {
		return null;
	}

	@Override
	public void deleteCodeGen(String codeGenId) {

	}

	@Override
	public CodeGen getCodeGen(String codeGenId) {
		return null;
	}

	@Override
	public List<CodeGen> getAll() {
		return null;
	}

	@Override
	public CodeGen updateCodeGen(CodeGen codeGen) {
		return null;
	}

	@Override
	public List<CodeGen> getAll(CodeGenContext context) {
		return null;
	}

	@Override
	public CodeGen getCodeGenByContext(CodeGenContext context) {
		CodeGen codeGen = codeGenRepository.findByCompanyId(context.getCompanyId());
		codeGen = codeGen.getName().equals(context.getName()) ? codeGen : null; 
		return codeGen;
	}

}
