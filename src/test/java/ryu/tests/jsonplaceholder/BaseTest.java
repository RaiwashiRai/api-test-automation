package ryu.tests.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // set the logging level to only log if validation fails
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    protected Response extractResponse(ValidatableResponse response) {
        // helper method to extract Response from ValidatableResponse, so that it wont be repeatedly written
        return response.extract().response();
    }
}