package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestGetApi {
	
	Properties pro; 
	
	@BeforeTest(description = "Pick URL")
	public void testSetup() throws IOException
	{
		File src = new File(".\\src/main\\resources\\properties\\URL.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test(description = "get() Demo")
	public void getApiTest()
	{
		RestAssured.baseURI= pro.getProperty("URL");	
			
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		
		Assert.assertEquals(200, res.statusCode());		
	}

}
