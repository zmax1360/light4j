package com.networknt.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClassMapper {
	
	public static String mapper(Object value) throws JsonProcessingException{
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(value);
	}

}
