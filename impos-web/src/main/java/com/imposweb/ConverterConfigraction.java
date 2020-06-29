package com.imposweb;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.ConverterRegistry;

import com.avitcore.converters.TypeConverter;

@Configuration
public class ConverterConfigraction {
	@Autowired(required = false)
	@TypeConverter
	private Set<Converter<?, ?>> autoRegester;
	@Autowired(required = false)
	@TypeConverter
	private Set<ConverterFactory<?, ?>> autoRegConverterFact;

	@Autowired
	private ConverterRegistry converterRegistry;

	@PostConstruct
	public void convers() {

		if (autoRegester != null) {
			for (Converter<?, ?> conver : autoRegester) {
				converterRegistry.addConverter(conver);
			}
		}

		if (autoRegConverterFact != null) {
			for (ConverterFactory<?, ?> conFact : autoRegConverterFact) {
				converterRegistry.addConverterFactory(conFact);
			}

		}
	}

}
