package com.avitcore.converters;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.springframework.stereotype.Component;

@Component
public class DateConverter {

	private static final DateTimeFormatter formatters = new DateTimeFormatterBuilder()
			.append(null,
					new DateTimeParser[] {
							DateTimeFormat.forPattern("dd-MM-YYYY").getParser(),
							DateTimeFormat.forPattern("dd/MM/YYYY").getParser(),
							DateTimeFormat.forPattern("dd MMMM,YYYY")
									.getParser(),
							DateTimeFormat.forPattern("YYYY/MM/dd").getParser(),
							DateTimeFormat.forPattern("dd-MM-YYYY hh:mm:ss a")
									.getParser(),
							DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss")
									.getParser(),
//							DateTimeFormat
//									.forPattern("yyyy-MM-ddTHH:mm:ss.SSS")
//									.getParser(),
							DateTimeFormat.forPattern("YYYY-MM-dd").getParser() })
			.toFormatter();

	public static LocalDate dateFormater(String date) {

		return formatters.parseLocalDate(date);

	}

	public static LocalTime timeFormater(String time) {

		return formatters.parseLocalTime(time);

	}

	public static LocalDateTime dateTimeFormater(String dateTime) {
		return formatters.parseLocalDateTime(dateTime);
	}
}
