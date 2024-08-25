package OAuthTesting;

import PojoConcepts.API;
import PojoConcepts.WebAutomation;
import PojoConcepts.objectJson;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class oAuthTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String response = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);

		String accessCode = jsonPath.getString("access_token");

		System.out.println(accessCode);

		objectJson getResponseString = given().queryParam("access_token", accessCode).when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(objectJson.class);

		System.out.println(getResponseString.getInstructor());
		System.out.println(getResponseString.getLinkedIn());

		// "SoapUI Webservices testing"
		System.out.println(getResponseString.getCourses().getApi().get(1).getCourseTitle());

		List<API> titlesOfAllAPICourses = getResponseString.getCourses().getApi();

		for (int i = 0; i < titlesOfAllAPICourses.size(); i++) {
			if (titlesOfAllAPICourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(titlesOfAllAPICourses.get(i).getPrice());
			}
		}

		// Assignment 2 - Fetch all the titles of the WebAutomation Cousre.

		List<WebAutomation> getTitlesOfAllCourseTitles = getResponseString.getCourses().getWebAutomation();

		for (int i = 0; i < getTitlesOfAllCourseTitles.size(); i++) {
			System.out.println(getTitlesOfAllCourseTitles.get(i).getCourseTitle());
		}
		
		
	}

}
