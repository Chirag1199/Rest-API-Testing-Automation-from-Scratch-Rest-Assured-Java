import org.testng.Assert;
import org.testng.annotations.Test;

import apiBodies.APIBodies;
import io.restassured.path.json.JsonPath;

public class totalPurchaseValidation {

	@Test
	public void sumValidation() {
		JsonPath js = new JsonPath(APIBodies.mockAPI());

		int numberOfCourses = js.getInt("courses.size()");
		System.out.println(numberOfCourses);

		int sum = 0;
		for (int i = 0; i < numberOfCourses; i++) {
			int totalPrices = js.getInt("courses[" + i + "].price");
			int totalCopies = js.getInt("courses[" + i + "].copies");

			int totalCosting = totalCopies * totalPrices;

			System.out.println(totalCosting);

			sum = sum + totalCosting;
		}

		System.out.println(sum);
		
		int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum, totalPurchaseAmount);

	}
}
