package com.imposweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan({ "com.impos.*","com.avcore.*","com.avitcore.*" })
@EntityScan({"com.impos.*"})
@EnableJpaRepositories({"com.impos.*"})
@SpringBootApplication
public class ImposWebApplication {

	public final static String CONVERSION_SERVICE_BEANNAME = "conversionService";
	private static Class<ImposWebApplication> applicationClass = ImposWebApplication.class;
	
	public static void main(String[] args) {
		SpringApplication.run(ImposWebApplication.class, args);
	}

	/**
	 * Creating the Spring Conversion service bean
	 */
	@Bean(name = CONVERSION_SERVICE_BEANNAME)
	@Primary
	public GenericConversionService conversionService() {
		return new GenericConversionService();
	}
	
	@Bean
	@Primary
	public ObjectMapper jacksonObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}
}
