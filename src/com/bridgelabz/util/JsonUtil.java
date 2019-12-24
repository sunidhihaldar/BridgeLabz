package com.bridgelabz.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	
	/**
	 * this method takes path and jsonArray as input parameters
	 * @param path as String input parameter
	 * @param jsonArray as input array parameter
	 */
	
	public static void writeDataToJSONArray(String path, JSONArray jsonArray) {
		try(FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(jsonArray.toJSONString());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method takes path as input parameter and read the data present in the file
	 * and converts to JSON array
	 * @param path as input parameter
	 * @return jsonArray
	 */
	
	public static JSONArray readJsonArray(String path) {
		JSONArray jsonArray;
		try(FileReader fileReader = new FileReader(path)) {
			JSONParser jsonParser = new JSONParser();
			jsonArray = (JSONArray) jsonParser.parse(fileReader);
			return jsonArray;
		}
		catch(FileNotFoundException e) {
		}
		catch(IOException | ParseException e) {
		}
		return null;
	}
}
