package stepdefs;

import common.helper.CommonFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class LoginSteps {

	private ValidatableResponse json;
	private RequestSpecification request;
	private Response response;

	CommonFunctions commonFunctions = new CommonFunctions();

	@Given("a Weather url has been provided")
	public void a_book_exists_with_isbn() {

		request = commonFunctions.getBaseUrl();
		request = commonFunctions.setParams(request,"q", "London,UK");
		request = commonFunctions.setParams(request ,"appid", "2b1fd2d7f77ccf1b7de9b441571b39b8");
		response = commonFunctions.getData(request, "weather");
	}

	@Then("I get the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		json = commonFunctions.getStatusCode(response, statusCode);
	}

}
