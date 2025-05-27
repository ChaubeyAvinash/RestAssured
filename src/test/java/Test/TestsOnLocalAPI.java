package Test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	//@Test
	public void get() {
		baseURI ="http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();
	}
	//@Test
	public void post() {
		JSONObject request =new JSONObject();
		
		request.put("name", "khan");
		request.put("id", "37932");
		request.put("job", "wbduwh");
		request.put("company", "suh");
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toString())
		.when()
			.post("/users")
			
		.then()
			.statusCode(201);
	}
	
	@Test
	public void patch() {
		JSONObject request =new JSONObject();
		
		
		
		request.put("job", "Developer");
		request.put("company", "Capgeminin");
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toString())
		.when()
			.patch("/users/3")
			
		.then()
			.statusCode(200);
	}
}
