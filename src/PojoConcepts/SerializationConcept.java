package PojoConcepts;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class SerializationConcept {

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

		String responseString = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(a).when().post("/maps/api/place/add/json").then()
				.assertThat().statusCode(200).extract().response()
				.asString();

		System.out.println(responseString);

	}

}
