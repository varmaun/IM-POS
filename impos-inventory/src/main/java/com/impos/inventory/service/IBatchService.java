package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.Batch;
/*
*@Author varma
*/
public interface IBatchService {
	
	Batch create(Batch batch);

	void deleteBatch(String batchId);

	Batch getBatch(String batchId);

	List<Batch> getAll();

	Batch updateBatch(Batch batch);
}
