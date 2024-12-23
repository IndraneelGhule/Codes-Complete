package F1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Testing5 {

	@BeforeSuite
	public void executionStart() {

		System.out.println("****************Execution Started****************");
	}

	@Test(description = "Get Users", priority = 1, enabled = true)
	public void getUsers() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}

//  Req Payload:
//	{
//	    "name": "pawan",
//	    "job": "leader"
//	}

	@Test(description = "Add Users", priority = 2, enabled = true)
	public void addUser() {
		HashMap map = new HashMap();
		map.put("name", "pawan");
		map.put("job", "leader");

		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
	}

	int newUserId = 0;

	@Test(description = "Add Users", priority = 3, enabled = true)
	public void updateUser() {
		// Create 1 User using : POST
		System.out.println("Create New User: ");
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("name", "pawan-post");
		map1.put("job", "leader");

		JsonPath jsonPath = 
				given()
					.contentType("application/json")
					.body(map1)
				.when()
					.post("https://reqres.in/api/users")
					.jsonPath();
		
		newUserId = jsonPath.getInt("id");
		System.out.println("ID is: " + newUserId);

		// Update previously created User: PUT
		System.out.println("Updated previously created User (Id): " + newUserId);
		long currentTD = System.currentTimeMillis();
		System.out.println("Current TD: " + currentTD);

		HashMap<String, String> map2 = new HashMap<>();
		map2.put("name", "pawan-put-update-" + currentTD);
		map2.put("job", "leader-update-" + currentTD);

		given().
			contentType("application/json")
			.body(map2)
		.when()
			.put("https://reqres.in/api/users/" + newUserId)
		.then()				
			.statusCode(200)
			.log().all();
	}

	@Test(description = "Add Users", priority = 4, dependsOnMethods = { "updateUser" }, enabled = true)
	public void deleteUser() {
		System.out.println("****************Deleting User: "+newUserId+"****************: "+newUserId);
		
		given()
		.when()
			.delete("https://reqres.in/api/users/"+newUserId)
		.then()
			.statusCode(204)
			.log().all();

		System.out.println("User Deleted (Id): " + newUserId);
	}

	@AfterSuite
	public void executionEnd() {

		System.out.println("****************Execution Completed****************");
	}
	
	
	
}
