package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import common_method.GetData;

public class post_request_repository {
	

public static String baseURI()
{
	String baseURI="https://reqres.in/";
			
			return baseURI;
	}
	public static String resource()
	{
		String resource = "api/users";
		return resource;
	}
	
	
	public static String post_request_tc1() throws IOException
	
	{
		ArrayList<String> data =GetData.getDataExcel("post_data","tc1");
		String Name=data.get(2);
		String job=data.get(3);
		
		String requestBody = "{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return requestBody;
	}
		
		public static String post_request_tc2()
		
		{
			String requestBody = "{\r\n"
					+ "    \"name\": \"Morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}";
			return requestBody;
	}
}
