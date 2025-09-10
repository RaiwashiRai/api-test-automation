package ryu.api;

import ryu.utils.Config; // Base URL for the API
import io.restassured.RestAssured;  // RestAssured main class
import io.restassured.response.Response;      // Holds HTTP/HTTPS response
import static io.restassured.RestAssured.*;   // given(), when(), then()


public class JsonPlaceholderApi {
    // public static final String BASE_URL = Config.JsonPlaceholder_BASE_URL;
    
    static {
        // no need to use baseUri method repeatedly
        RestAssured.baseURI = Config.JsonPlaceholder_BASE_URL; 
    }
    
    public Response getAllUsers(){
        return given()
                .when()
                .get("/users")
                .then()
                .extract().response();
    }

    public Response getUserById(int id){
        return given()
                .pathParam("id", id)
                .when()
                .get("/users/{id}")
                .then()
                .extract().response();
    }
}