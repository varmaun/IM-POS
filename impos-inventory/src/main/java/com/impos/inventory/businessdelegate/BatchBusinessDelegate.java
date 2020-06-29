package com.impos.inventory.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.util.CustomUtilService;
import com.impos.inventory.businessdelegate.context.BatchContext;
import com.impos.inventory.converters.BatchModelToBatchConverter;
import com.impos.inventory.converters.BatchToBatchModelConverter;
import com.impos.inventory.domain.Batch;
import com.impos.inventory.model.BatchModel;
import com.impos.inventory.service.IBatchService;
import com.impos.settings.businessdelegate.context.CodeGenContext;
import com.impos.settings.domain.CodeGen;
import com.impos.settings.service.CodeGenService;

/*
*@Author varma
*/

@Service
public class BatchBusinessDelegate implements IBusinessDelegate<BatchModel, BatchContext, IKeyBuilder<String>, String> {

	@Autowired
	private IBatchService batchService;
	@Autowired
	private BatchModelToBatchConverter batchModelToBatchConverter;
	@Autowired
	private BatchToBatchModelConverter batchToBatchModelConverter;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private CodeGenService codeGenService;

	@Autowired
	private CustomUtilService customUtilService;

	@Override
	@Transactional
	public BatchModel create(BatchModel model) {
		CodeGenContext context = new CodeGenContext();
		context.setCompanyId(model.getCompanyId());
		context.setName(model.getName());
		CodeGen codeGen = codeGenService.getCodeGenByContext(context);
		String batchCode = customUtilService.generateBatchCode(codeGen.getCodeFormat(), codeGen.getPrefix(), codeGen.getSuffix());
		model.setBatchCode(batchCode);
		Batch batch = batchService.create((Batch) convertToBatch(model));
		model = convertToBatchModel(batch);
		return model;
	}

	private BatchModel convertToBatchModel(Batch batch) {
		return (BatchModel) batchToBatchModelConverter.convert(batch);
	}

	private Batch convertToBatch(BatchModel model) {
		return (Batch) batchModelToBatchConverter.convert(model);
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, BatchContext context) {

	}

	@Override
	public BatchModel edit(IKeyBuilder<String> keyBuilder, BatchModel model) {
		Batch batch = batchService.getBatch(keyBuilder.build().toString());

		batch = batchService.updateBatch((Batch) convertToBatch(model));
		model = convertToBatchModel(batch);

		return model;
	}

	@Override
	public BatchModel getByKey(IKeyBuilder<String> keyBuilder, BatchContext context) {
		Batch batch = batchService.getBatch(keyBuilder.build().toString());
		BatchModel model = convertToBatchModel(batch);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<BatchModel> getCollection(BatchContext context) {
		List<Batch> batch = new ArrayList<Batch>();
		batch = batchService.getAll();
		List<BatchModel> batchModels = (List<BatchModel>) conversionService.convert(batch,
				TypeDescriptor.forObject(batch),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BatchModel.class)));
		return batchModels;
	}

	@Override
	public BatchModel edit(IKeyBuilder<String> keyBuilder, BatchModel model, BatchContext context) {
		return null;
	}

}
