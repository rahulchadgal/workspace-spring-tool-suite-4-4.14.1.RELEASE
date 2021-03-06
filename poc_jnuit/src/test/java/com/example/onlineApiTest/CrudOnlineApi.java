package com.example.onlineApiTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class CrudOnlineApi {
	private String responsebody;
	public String responseBodyPOST;
	final static Logger logger = Logger.getLogger(TestNg.class);
	private RestTemplate restTemplate;
	private ResponseEntity<String> response;
	private String dataId;
	private String UpdateJson;
	
	@BeforeTest
	void beforeTest() throws IOException, ParseException {
		logger.info("Setting up prerequisite for test execution");
		logger.info("Creating RestTemplate object before tests");
		this.restTemplate = new RestTemplate();
	}
	
	@Test
	public void addValues() throws JSONException {
		String addURI = "https://crudcrud.com/api/202c29609c8a418d9c5269bb517e6c6f";
		//logger.info("Get URL :" + addURI);
	//	System.out.println("addURI :" + addURI);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		logger.info("Add URL :" + addURI);
		String jsonBody = "{\"name\":\"zozo100\",\"age\":\"23\",\"colour\":\"red\"}";
		UpdateJson = jsonBody;
		System.out.println("\n\n" + jsonBody);
		addURI = "https://crudcrud.com/api/202c29609c8a418d9c5269bb517e6c6f" + "/new1";
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);

		response = this.restTemplate.postForEntity(addURI, entity, String.class);
		responseBodyPOST = response.getBody();
		responsebody= response.getBody().toString();
		System.out.println("response :" + response);
		dataId = getIdfromJson(responsebody);
		System.out.println("\ndataId :" + dataId);
		AssertJUnit.assertTrue(responsebody.contains(dataId));
		AssertJUnit.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		
		
		
	}
	
	private String getIdfromJson(String jsonbody) throws JSONException {
		JSONObject obj = new JSONObject(jsonbody);
		String dataId = obj.getString("_id");
		return dataId;
	}
	
	@Test(dependsOnMethods = "addValues", enabled =true)
	public void updateValues() throws JSONException {
		String updateUri = "https://crudcrud.com/api/202c29609c8a418d9c5269bb517e6c6f/new1";
		//logger.info("updateUri: "+updateUri);
		
		String jsonBody = responseBodyPOST;
		String dataId = getIdfromJson(jsonBody.toString());
	//	System.out.println("\ndataId :" + dataId);
		updateUri = "https://crudcrud.com/api/202c29609c8a418d9c5269bb517e6c6f/new1/"+dataId;
	//	System.out.println("\nupdateUri :" + updateUri);
		UpdateJson = UpdateJson.replace("zozo100", "update_zozo100");
	//	System.out.println("\njsonBody :" + jsonBody);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(UpdateJson, headers);
		response = restTemplate.exchange(updateUri, HttpMethod.PUT, entity, String.class);
	//	responsebody = response.getBody().toString();
	//	System.out.println("responsebody :" + responsebody);
		
	//	Assert.assertTrue(responsebody.contains("update_zozo100"));

		AssertJUnit.assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		
	}

	@Test(dependsOnMethods = "updateValues", enabled = true)
	public void getValues() {
		String getURI = "https://crudcrud.com/api/202c29609c8a418d9c5269bb517e6c6f/new1";
		logger.info("Get URL :" + getURI);
		//System.out.println("getURI :" + getURI);
		
		ResponseEntity<String> response= restTemplate.getForEntity(getURI, String.class);
		//System.out.println("response :" + response);
		responsebody = response.getBody().toString();
		System.out.println("responsebody :" + responsebody);
		AssertJUnit.assertTrue(responsebody.contains("zozo100"));
		AssertJUnit.assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
}
