package com.bridgelabz.util;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	
	public static String convertJavaToJson(Object object) {
		String jsonResult = "";
			try {
				jsonResult = mapper.writeValueAsString(object);
			} catch (JsonGenerationException e) {
				System.out.println("Exception occured while converting Java object into Json --> " + e.getMessage());
			} catch (JsonMappingException e) {
				System.out.println("Exception occured while converting Java object into Json --> " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Exception occured while converting Java object into Json --> " + e.getMessage());
			}
		return jsonResult;
	}
	
	public static <G> G convertJsonToJava(String jsonString, Class<G> cls) {
		G result = null;
			try {
				result = mapper.readValue(jsonString, cls);
			} catch (JsonParseException e) {
				System.out.println("Exception occured while converting Json into Java --> " + e.getMessage());
			} catch (JsonMappingException e) {
				System.out.println("Exception occured while converting Json into Java --> " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Exception occured while converting Json into Java --> " + e.getMessage());
			}
		return result;
	}
}
