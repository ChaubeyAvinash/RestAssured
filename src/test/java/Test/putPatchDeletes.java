package Test;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class putPatchDeletes {
	@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		
		request.put("name", "Avinash");
		request.put("Job", "Engineer");
		
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		    header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			put("/user/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void testPatch() {
		JSONObject request = new JSONObject();
		
		request.put("name", "Avinash");
		request.put("Job", "Engineer");
		
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
		when().
			patch("/user/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void testDelete() {
				
		baseURI = "https://reqres.in/api";
		
		
		when().
			delete("/user/2").
		then().
			statusCode(204).
			log().all();
	}
}
