package TestUtils;


public class payload {
	
	
	public static String sampleJSON()
	{
		return "{\r\n" + 
				"    \"tool\": \r\n" + 
				"    {\r\n" + 
				"        \"jsonpath\": \r\n" + 
				"        {\r\n" + 
				"            \"creator\": \r\n" + 
				"            {\r\n" + 
				"                \"name\": \"Jayway Inc.\",\r\n" + 
				"                \"location\": \r\n" + 
				"                [\r\n" + 
				"                    \"Malmo\",\r\n" + 
				"                    \"San Francisco\",\r\n" + 
				"                    \"Helsingborg\"\r\n" + 
				"                ]\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    },\r\n" + 
				"\r\n" + 
				"    \"book\": \r\n" + 
				"    [\r\n" + 
				"        {\r\n" + 
				"            \"title\": \"Beginning JSON\",\r\n" + 
				"            \"price\": 49.99\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"        {\r\n" + 
				"            \"title\": \"JSON at Work\",\r\n" + 
				"            \"price\": 29.99\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
	}
	
	public static String dashboardJSON()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 40000,\r\n" + 
				"    \"website\": \"www.testingshastra.com\",\r\n" + 
				"    \"studentId\" : \"911\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": {\r\n" + 
				"    \"webautomation\":[\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Selenium\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Cypress\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Protractor\",\r\n" + 
				"        \"price\": 7000\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"api\":[\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Rest API\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Soap UI\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"Mobile_Automation\":[\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"C-Test\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Appium\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"\r\n" + 
				"}";
	}

}
