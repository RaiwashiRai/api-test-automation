package ryu.api.jsonplaceholder;

import ryu.utils.Config; // Base URL for the API
import io.restassured.RestAssured;  // RestAssured main class
import io.restassured.response.ValidatableResponse;      // Holds HTTP/HTTPS response
import static io.restassured.RestAssured.*;   // given(), when(), then()

import java.util.HashMap; // needed for using HashMap
import java.util.Map; // needed for using Map


public class UserApi {
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

    public ValidatableResponse createUser (Map <String, Object> user) {
        // create user map

        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users")
                .then();
    }

    public ValidatableResponse resetUser(int id, Map <String, Object> user) {
        // reset user details given id and user details in map, creates new user if id not found

        return given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(user)
                .when()
                .put("/users/{id}")
                .then();
    }

    public ValidatableResponse updateUser(int id, Map <String, Object> user) {
        // update user details given id and user details in map.

        return given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(user)
                .when()
                .patch("/users/{id}")
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