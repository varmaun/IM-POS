package com.avitcore.converters;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {

		return attribute == null ? null : Timestamp.valueOf(attribute.toString());
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {

		return dbData == null ? null : new LocalDateTime(dbData.toLocalDateTime());
	}
}