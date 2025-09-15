package ryu.api;

import ryu.utils.Config; // Base URL for the API
import io.restassured.RestAssured;  // RestAssured main class
import io.restassured.response.ValidatableResponse;      // Holds HTTP/HTTPS response
import static io.restassured.RestAssured.*;   // given(), when(), then()

import java.util.HashMap; // needed for using HashMap
import java.util.Map; // needed for using Map


public class JsonPlaceholderApi {
    // public static final String BASE_URL = Config.JsonPlaceholder_BASE_URL;
    
    static {
        // no need to use baseUri method repeatedly
        RestAssured.baseURI = Config.JsonPlaceholder_BASE_URL; 
    }
    
    public ValidatableResponse getAllUsers(){
        // returns all users

        return given()
                .when()
                .get("/users")
                .then();
    }

    public ValidatableResponse getUserById(int id){
        // taked id and returns user details

        return given()
                .pathParam("id", id)
                .when()
                .get("/users/{id}")
                .then();
    }

    public ValidatableResponse createUser (String name, String email) {
        // create user given name and email

        
        Map<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("email", email);

        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users")
                .then();
    }

    public ValidatableResponse deleteUser(int id) {
        // delete user by id

        return given()
                .pathParam("id", id)
                .when()
                .delete("/users/{id}")
                .then();
    }
}