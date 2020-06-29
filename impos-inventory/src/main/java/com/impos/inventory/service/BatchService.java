package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.inventory.domain.Batch;
import com.impos.inventory.repository.BatchRepository;

/*
*@Author varma
*/
@Component
public class BatchService implements IBatchService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private BatchRepository batchRepository;

	@Override
	public Batch create(Batch batch) {
		return batchRepository.save(batch);
	}

	@Override
	public void deleteBatch(String batchId) {

	}

	@Override
	public Batch getBatch(String batchId) {
		Optional<Batch> batchOpt = batchRepository.findById(batchId);
		Batch batch = new Batch();
		if (batchOpt.isPresent()) {
			batch = batchOpt.get();
		} else {
			throw new EntityNotFoundException(batchId);
		}
		return batch;
	}

	@Override
	public List<Batch> getAll() {
		List<Batch> batch = (List<Batch>) batchRepository.findAll();
		return batch;
	}

	@Override
	public Batch updateBatch(Batch batch) {
		Batch batchs = getBatch(batch.getId());
		try {
			nonNullBeanUtiles.copyProperties(batchs, batch);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return batchRepository.save(batchs);
	}

}
