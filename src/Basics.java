
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


import static org.hamcrest.Matchers.*;

import apiBodies.APIBodies;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Start writing your code.

		RestAssured.baseURI = "https://reqres.in/";

		// validate the assertions generated in the API response. -> HTTP METHOD - POST
		String response = given().log().all().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.body(APIBodies.AddPlace()).when().post("api/users").then().log().all().statusCode(201)
				.body("name", equalTo("morpheus")).header("Server", "cloudflare").extract().response().asString();

		System.out.println(response);

		// Parsing a JSON output.
		JsonPath js = new JsonPath(response);
		String job = js.getString("job");

		System.out.println(job);

		String newJob = "zion resident";

		// UPDATE METHOD
		given().log().all().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"" + newJob + "\"\r\n" + "}").when()
				.put("api/users/2").then().log().all().assertThat().statusCode(200)
				.body("job", equalTo("zion resident"));

		// http method - GET
		String responseJob = given().log().all().queryParam("page", "2").when().get("api/users").then().log().all()
				.statusCode(200).extract().response().asString();
		
		System.out.println(responseJob);
		
		JsonPath js1 = new JsonPath(responseJob);
		String validationJobName = js1.getString("job");
		System.out.println(validationJobName); // null value since job is not present in a response been generated. 
		
	}

}
