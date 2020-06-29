package com.avitcore.util;

import org.springframework.stereotype.Component;

@Component
public class CustomUtilService {

	public String generateBatchCode(String codeFormat, String prefix, String suffix) {
		String code = prefix+suffix+codeFormat;
		return code;
	}
}
