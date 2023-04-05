package common_method;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class common_method_api {
	
	public static int responsestatus_extractor(String baseURI , String resource , String requestBody)
	{
		RestAssured.baseURI=baseURI;
		
		int response_statuscode = given().header("Content-Type", "application/json")
				.body(requestBody).when().post(resource).then().extract().statusCode();
		
		return response_statuscode;
	}
		
		public static String responsebody_extractor(String baseURI , String resource , String requestBody)
		{
			RestAssured.baseURI=baseURI;
			
			String response_body = given().header("Content-Type", "application/json")
					.body(requestBody).when().post(resource).then().extract().response().asString();
			return response_body;
			
		
		}

}
