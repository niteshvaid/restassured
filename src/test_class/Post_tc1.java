package test_class;


import java.io.IOException;
//import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.CommonMethodUtilities;
import common_method.common_method_api;
import io.restassured.path.json.JsonPath;
import request_repository.post_request_repository;

public class Post_tc1 {
	@Test
	
	public static void orchestrator() throws IOException
	{
		int responsestatuscode = 0;
		String responsebody = "";
		
		String baseURI = post_request_repository.baseURI();
		String resource= post_request_repository.resource();
		String requestBody= post_request_repository.post_request_tc1();
		
		
		 
		for (int i=0 ;i<5 ; i++)
		{
			
			responsestatuscode = common_method_api.responsestatus_extractor(baseURI, resource, requestBody);
			if (responsestatuscode==201)
			{
				 responsebody = common_method_api.responsebody_extractor(baseURI, resource, requestBody);
				responseBodyValidator(responsebody);
				break;
			}
			else
			{
				System.out.println("correct status code is not found in the iteration " + i);
			}
			
		}
		
		CommonMethodUtilities.evidencefilecreator("Post_tc1", requestBody, responsebody);
		Assert.assertEquals(responsestatuscode, 201);
				
	}

	public static void responseBodyValidator(String responsebody) 
	
	{
		//create jsonPath object to extract response body and parameter
		JsonPath jsp = new JsonPath(responsebody);
		
		//extract responsebody parameter
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		String res_id=jsp.getString("id");
		//String res_created=jsp.getString("createdAt");
		
		//validate response body parameter
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"leader");
		Assert.assertNotEquals(res_id,"id is not null");
		
		//date validation
		//String date=res_created.substring(0,10);
		//String newdate=LocalDate.now().toString();
		
		//Assert.assertEquals(date,newdate);
		
		System.out.println("name : " + res_name + "\njob : " + res_job + "\nid : " + res_id );
		
		
	}

}
