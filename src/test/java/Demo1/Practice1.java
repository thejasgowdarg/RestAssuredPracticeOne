package Demo1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Practice1 {
	
	@Test(priority = 1)
	void getUser() {
		
		given()
		.when()

		 .get("https://reqres.in/api/users?page=2")
		
		.then()
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();
		//get(method)
	}
}
