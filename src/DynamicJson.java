import org.junit.validator.PublicClassValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apiBodies.APIBodies;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbnString, String aisleString) {

		RestAssured.baseURI = "http://216.10.245.166";

		String response = given().log().all().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.body(APIBodies.libraryAddAPI(isbnString,aisleString)).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);

		String addedID = js.get("ID");

		System.out.println(addedID);
	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {

		return new Object[][] { { "tejas", "2801" }, { "akash", "2409" }, { "akashShetty", "1509" } };
	}
}
