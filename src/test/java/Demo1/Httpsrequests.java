package Demo1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import javax.management.InvalidApplicationException;

public class Httpsrequests {
	
	int id;
	
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
	@Test(priority = 2)
	void createUser() {
		
		HashMap Data=new HashMap();
		Data.put("name", "thejas");
		Data.put("job", "tester");
		
		id=given()
		    .contentType("application/json")
		    .body(Data)
		
		
		.when()
		
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
     //	.then()
//	       .statusCode(201)
//	       .log().all();
		 //psot(method)
		
	}
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap Data=new HashMap();
		Data.put("name", "gaynappa");
		Data.put("job", "qaanlayst");
		
		given()
	    .contentType("application/json")
	    .body(Data)
		
          .when()
		
		     .put("https://reqres.in/api/users"+id)
	
		
		
       	  .then()
	       .statusCode(200)
          .log().all();
		
		
		
	}
	@Test(priority = 4)
	
	void deleteUser() {
		
		given()
		
		.when()
		.delete("\"https://reqres.in/api/users\"+id")
		
		
		.then()
		.statusCode(204)
		.log().all();
		
	}
	
	

	
}
