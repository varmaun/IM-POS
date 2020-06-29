package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.CodeGenContext;
import com.impos.settings.domain.CodeGen;

public interface ICodeGenService {

	CodeGen create(CodeGen codeGen);

	void deleteCodeGen(String codeGenId);

	CodeGen getCodeGen(String codeGenId);
	
	CodeGen getCodeGenByContext(CodeGenContext context);

	List<CodeGen> getAll();

	CodeGen updateCodeGen(CodeGen codeGen);

	List<CodeGen> getAll(CodeGenContext context);
}
