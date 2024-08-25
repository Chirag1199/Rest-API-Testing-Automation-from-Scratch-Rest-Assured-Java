package demo;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.classgen.BytecodeExpression;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoEcommerce.EcommerceLoginRequest;
import pojoEcommerce.EcommerceLoginResponse;
import pojoEcommerce.OrderDetails;
import pojoEcommerce.Orders;

public class EcommerceAPIProject {

	public static void main(String args[]) {

		// login into the website :
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		// Send username and email on the login page:
		EcommerceLoginRequest loginRequest = new EcommerceLoginRequest();
		loginRequest.setUserEmail("cak9763@gmail.com");
		loginRequest.setUserPassword("3,@5#!w3x#82QmA");

		RequestSpecification reqLoginString = given().log().all().spec(requestSpecBuilder).body(loginRequest);

		EcommerceLoginResponse responseLogin = reqLoginString.when().post("api/ecom/auth/login").then().log().all()
				.extract().response().as(EcommerceLoginResponse.class);

		String token = responseLogin.getToken();
		System.out.println(token);

		String userID = responseLogin.getUserId();
		System.out.println(userID);

		// Create/Add a product on the Product listing Page:-

		RequestSpecification addProductRequest = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();

		RequestSpecification reqCreateAddingProduct = given().log().all().spec(addProductRequest)
				.formParam("productName", "qwerty").formParam("productAddedBy", userID)
				.formParam("productCategory", "fashion").formParam("productSubCategory", "shirts")
				.formParam("productPrice", 11500).formParam("productDescription", "Addias Originals")
				.formParam("productFor", "women")
				.multiPart("productImage", new File("C://Users//ADMIN//Downloads//451.png"));

		String addProductResponse = reqCreateAddingProduct.when().post("api/ecom/product/add-product").then().log()
				.all().extract().response().asString();

		JsonPath jsonPath = new JsonPath(addProductResponse);
		String productID = jsonPath.get("productId");
		System.out.println(productID);

		// Create a Order { Place Order }

		RequestSpecification addOrderRequirement = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).build();

		// Add the Order by sending the data:
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCountry("India");
		orderDetails.setProductOrderedId(productID);

		// Fetch all the added Orders in the form of a List:
		List<OrderDetails> ordersList = new ArrayList<OrderDetails>();
		ordersList.add(orderDetails);

		// Orders return type is List which we have stored earlier in the form of a
		// List:
		Orders orders = new Orders();
		orders.setOrders(ordersList);

		RequestSpecification createOrderRequest = given().log().all().spec(addOrderRequirement).body(orders);

		String orderPlacedResponse = createOrderRequest.when().post("api/ecom/order/create-order").then().log().all()
				.extract().response().asString();

		System.out.println(orderPlacedResponse);

		// Final Stage - Deleting a product : { Assignment }

		RequestSpecification deleteProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).build();

		RequestSpecification deleteProductResponse = given().log().all().spec(deleteProduct).pathParam("productId",
				productID);

		String productDeletion = deleteProductResponse.when().delete("api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();

		JsonPath jsonPath2 = new JsonPath(productDeletion);
		String deleteMessageConfirmation = jsonPath2.get("message");

		Assert.assertEquals("Product Deleted Successfully", deleteMessageConfirmation);
		
		// Additional Stage - delete the orders too. 
		
		

	}
}
