package ryu.tests.jsonplaceholder;

import ryu.api.jsonplaceholder.UserApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseTest {

    protected UserApi api = new UserApi(); // api object to call api methods;

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