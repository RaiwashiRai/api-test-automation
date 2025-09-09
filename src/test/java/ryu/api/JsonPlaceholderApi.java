package ryu.api;

import ryu.utils.Config; // Base URL for the API
import io.restassured.response.Response;      // Holds HTTP/HTTPS response
import static io.restassured.RestAssured.*;   // given(), when(), then()


public class JsonPlaceholderApi {
    public static final String BASE_URL = Config.JsonPlaceholder_BASE_URL;
    
    public Response getAllUsers(){
        return given()
                .baseUri(BASE_URL)
                .when()
                .get("/users")
                .then()
                .extract().response();
    }
}