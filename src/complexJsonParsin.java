import apiBodies.APIBodies;
import io.restassured.path.json.JsonPath;

public class complexJsonParsin {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(APIBodies.mockAPI());

		// 1st Task - Print no. of Courses returned by API -

		int numberOfCourses = js.getInt("courses.size()");
		System.out.println(numberOfCourses);

		// 2nd Task - Print Purchase Amount for every courses bought -

		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		// 3rd Task - Print the title of the 1st Course -

		String firstTitle = js.getString("courses[0].title");
		System.out.println(firstTitle);

		// 4th Task - print all courses titles and their respective Prices -

		for (int i = 0; i < numberOfCourses; i++) {

			System.out.println(js.getString("courses[" + i + "].title"));
			System.out.println(js.getInt("courses[" + i + "].price"));
		}

		// 5th Task - Print no. of courses sold by RPA Courses -

		for (int i = 0; i < numberOfCourses; i++) {

			// this will print all the titles returned by API
			String courseName = js.getString("courses[" + i + "].title");

			if (courseName.contains("RPA")) {

				int numberOfCopies = js.getInt("courses[" + i + "].copies");
				System.out.println(numberOfCopies);
				break;
			}
		}

	}

}
