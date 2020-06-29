package com.avitcore.model;

import java.util.Collection;

import org.springframework.core.convert.TypeDescriptor;

import com.avitcore.converters.CollectionTypeDescriptor;

/**
 * Implementation class for IModel wrapper which hold collection of models along
 * with the type descriptor
 *
 * @author rbuddepu
 */
public class CollectionModelWrapper<T extends IModel> implements
		IModelWrapper<Collection<T>> {
	private TypeDescriptor modelDescriptor;
	private Collection<T> modelObjects;

	/**
	 * Constructor for CollectionModelWrapper
	 *
	 * @param modelClass
	 * @param modelObjects
	 */
	public CollectionModelWrapper(final Class<T> modelClass,
			final Collection<T> modelObjects) {
		super();
		this.modelDescriptor = CollectionTypeDescriptor.forCollection(
				modelObjects, modelClass);
		this.modelObjects = modelObjects;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.avitcore.model.IModelWrapper#getModel()
	 */
	@Override
	public Collection<T> getModel() {
		return modelObjects;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.avitcore.model.IModelWrapper#getModelType()
	 */
	@Override
	public TypeDescriptor getModelType() {
		return modelDescriptor;
	}
}
