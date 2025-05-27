package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class getAndPostExample {
		@Test
		public static void testGet() {
			baseURI="https://reqres.in/api";
			given().
			get("/users").
			then().
			statusCode(200).
			body("data[0].id",equalTo(1)).
			body("data[0].last_name",equalTo("Bluth")).
			body("data[1].first_name",equalTo("Janet"));
		}
		@Test
		public static void testPost() {
			Map<String,Object> map = new HashMap<String,Object>();
			
			JSONObject request = new JSONObject();
			request.put("name","Raghav");
			request.put("job","Teacher");
			System.out.println(request.toString());
			RestAssured.baseURI = "https://reqres.in/api";
			
			given().
	        	header("Content-Type", "application/json").
	        	contentType(ContentType.JSON).
	        	accept(ContentType.JSON).
	        body(request.toString()).
	        when().
	        	post("/users").
	        then().
	        	statusCode(201).
	        log().all();
		}
}
