package com.bridgelabz.util;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This class contains JSON functionalities
 * @author Sunidhi Haldar
 * @ created 2019-11-29
 * @version 13.0.1
 */

public class JsonUtil {

	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	
	/**
	 * This method takes the object of the class as input parameter and converts Java object into
	 * Json object
	 * @param object as input parameter
	 * @return String value
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	
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
	
	/**
	 * This method takes Json String value and class name as input parameters and reads the Json file
	 * @param JsonString as input parameter
	 * @param cls takes parameter as classname.class
	 * @return generic <G> type data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	
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
