package common.helper;

import static io.restassured.RestAssured.given;

import common.constatnt.LinkConstant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CommonFunctions {
	private Response response;
	private ValidatableResponse json;

	public RequestSpecification basicAuth() {
		return given().auth().basic("user1", "user1Pass");
	}

	public Response getGetRequestBuilder(RequestSpecification request) {
		return request.when().get(LinkConstant.ENDPOINT_GET_BOOK_BY_ISBN);
	}

	public RequestSpecification getParams(String key, String value) {
		return given().param(key, value);
	}

	public ValidatableResponse getStatusCode(Response response, int statusCode) {
		return response.then().statusCode(statusCode);
	}

	public RequestSpecification getBaseUrl() {
		return RestAssured.given().baseUri(LinkConstant.baseUrl);
	}

	public RequestSpecification setParams(RequestSpecification request, String key, String value) {
		return request.queryParam(key, value);
	}

	public Response getData(RequestSpecification request, String data) {
		return request.get("/" + data);
	}

}
