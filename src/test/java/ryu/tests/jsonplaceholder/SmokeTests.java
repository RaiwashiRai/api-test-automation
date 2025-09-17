package ryu.tests.jsonplaceholder;

import ryu.tests.jsonplaceholder.BaseTest;

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;


public class SmokeTests extends BaseTest {
    
    // Test : Check status code of GET /users
    @Test(groups = {"smoke"})
    public void testGetAllUsers() {
        ValidatableResponse allUsers = api.getAllUsers();
        allUsers.statusCode(200);
    }

    // Test : Check status code of GET /users/{id}
    @Test(groups = {"smoke"})
    public void testGetUserById() {
        ValidatableResponse userById = api.getUserById(1);
        userById.statusCode(200);
    }
}