package apiBodies;

import org.codehaus.groovy.runtime.callsite.StaticMetaMethodSite.StaticMetaMethodSiteNoUnwrapNoCoerce;

public class APIBodies {
	
	public static String AddPlace() {
		 return "{\r\n"
		 		+ "    \"name\": \"morpheus\",\r\n"
		 		+ "    \"job\": \"leader\"\r\n"
		 		+ "}";
	}
	
	public static String mockAPI(){
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 1162,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"title\": \"Appium\",\r\n" + 
				"      \"price\": 36,\r\n" + 
				"      \"copies\": 7\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String libraryAddAPI(String isbnString, String aisleString) {
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbnString+"\",\r\n"
				+ "\"aisle\":\""+aisleString+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
//	public static String oAuthCredentials(String access_token) {
//		return "{\r\n"
//				+ "    \"access_token\": \""+access_token+"\",\r\n"
//				+ "    \"token_type\": \"Bearer\",\r\n"
//				+ "    \"expires_in\": 3600,\r\n"
//				+ "    \"refresh_token\": \"4kHstDaxOttmJlhYns+KKg==\",\r\n"
//				+ "    \"scope\": \"create\"\r\n"
//				+ "}";
//	}
	
}
