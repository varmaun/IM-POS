package com.impos.settings.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.CodeGenContext;
import com.impos.settings.domain.CodeGen;
import com.impos.settings.model.CodeGenModel;
import com.impos.settings.service.ICodeGenService;


	@Service
	public class CodeGenBusinessDelegate
			implements IBusinessDelegate<CodeGenModel, CodeGenContext, IKeyBuilder<String>, String> {

		@Autowired
		private ICodeGenService codeGenService;
		@Autowired
		private ConversionService conversionService;

		@Override
		public CodeGenModel create(CodeGenModel model) {

			CodeGen codeGen = new CodeGen();
			converter(model, codeGen);
			codeGenService.create(codeGen);
			converter(codeGen, model);
			return model;
		}

		@Override
		public void delete(IKeyBuilder<String> keyBuilder, CodeGenContext context) {
			// TODO Auto-generated method stub

		}

		@Override
		public CodeGenModel edit(IKeyBuilder<String> keyBuilder, CodeGenModel model) {
			
			if(model!=null && model.getId()!=null) {
				CodeGen codeGen = new CodeGen();
				converter(model,codeGen);
				codeGenService.updateCodeGen(codeGen);
				converter(codeGen,model);
			}
			return model;
		}

		@Override
		public CodeGenModel edit(IKeyBuilder<String> keyBuilder, CodeGenModel model, CodeGenContext context) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CodeGenModel getByKey(IKeyBuilder<String> keyBuilder, CodeGenContext context) {
			CodeGen codeGen = codeGenService.getCodeGen(keyBuilder.build().toString());
			CodeGenModel model = new CodeGenModel();
			converter(codeGen,model);
			return model;
		}

		@Override
		public Collection<CodeGenModel> getCollection(CodeGenContext context) {
			List<CodeGenModel> models = new ArrayList<CodeGenModel>();
			for(CodeGen codeGen:codeGenService.getAll(context)) {
				CodeGenModel model = new CodeGenModel();
				converter(codeGen,model);
				models.add(model);
			}
			return models;
		}

		private void converter(CodeGen source, CodeGenModel target) {

			BeanUtils.copyProperties(source, target);
		}

		private void converter(CodeGenModel source, CodeGen target) {

			BeanUtils.copyProperties(source, target);
		}

}
