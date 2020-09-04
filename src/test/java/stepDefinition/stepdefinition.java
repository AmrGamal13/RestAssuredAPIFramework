package stepDefinition;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utilis;

public class stepdefinition extends Utilis{
	RequestSpecification req;
	Response response;
	
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String Language, String address) throws IOException {
		//creating an object from that class for getting the POJO output for the body
		TestDataBuild tes = new TestDataBuild();
		 req= given().spec(requestspecificationgroup())
				.body(tes.addPlacePlayload(name, Language, address));
	}

	@When("user calls AddPlaceAPI with POST HTTP request")
	public void user_calls_AddPlaceAPI_with_POST_HTTP_request() {
		 response = req
					.when().post("/maps/api/place/add/json")
					.then().extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
		 String responsebody = response.asString();
		   JsonPath js = new JsonPath(responsebody);
		  Assert.assertEquals(js.getString(keyvalue), expectedvalue);

	}


}
