package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {
	@Test
		public void testget() {
						
			baseURI = "http://reqres.in/api";
			given()
				.get("/users?page=2")
				.then()
				.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
				.body("data[4].name", equalTo("George"))
				.body("data.name", hasItems("George","Rachel"))
				.statusCode(201);
		}
}
