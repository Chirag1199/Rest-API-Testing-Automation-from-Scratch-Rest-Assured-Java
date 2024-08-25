package PojoConcepts;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class RequestSpecificationBuilder {

	public static void main(String args[]) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		addPlaceSerialization a = new addPlaceSerialization();

		a.setAccuracy(50);
		a.setName("Frontline house");
		a.setPhone_number("(+91) 983 893 3937");
		a.setAddress("29, side layout, cohen 09");
		a.setWebsite("https://rahulshettyacademy.com");
		a.setLanguage("French-IN");

		LocationSerialization location = new LocationSerialization();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		a.setLocation(location);

		List<String> typesList = new ArrayList<String>();
		typesList.add("shoe park");
		typesList.add("shop");

		a.setType(typesList);

		// BUILD REQUEST SPEC BUILDER :
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();

		// BUILD RESPONSE SPEC BUILDER :
		ResponseSpecification r = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		RequestSpecification responseString = given().spec(requestSpecification).body(a);

		Response response = responseString.when().post("/maps/api/place/add/json").then().spec(r)
				.extract().response();

	
		System.out.println(response.asString());

	}

}
