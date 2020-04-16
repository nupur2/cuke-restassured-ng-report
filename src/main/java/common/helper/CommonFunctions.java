package common.helper;

import static io.restassured.RestAssured.given;

import common.constatnt.LinkConstant;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CommonFunctions {
	private Response response;
	private ValidatableResponse json;

	public Response getGetRequestBuilder(RequestSpecification request) {
		return request.when().get(LinkConstant.ENDPOINT_GET_BOOK_BY_ISBN);
	}
	public RequestSpecification getParams(String key , String value) {
		return given().param(key, value);
	}
	public ValidatableResponse getStatusCode(Response response, int statusCode) {
		return response.then().statusCode(statusCode);
	}
}
