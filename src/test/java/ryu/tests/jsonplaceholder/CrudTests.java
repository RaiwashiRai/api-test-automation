package ryu.tests.jsonplaceholder;

import ryu.tests.jsonplaceholder.BaseTest;
import ryu.utils.TestData; // import TestData to use test data maps

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import static org.testng.Assert.*; // for assertions
import static org.hamcrest.Matchers.*;
import java.util.Map; // needed for using Map
import java.util.Collections; // needed for using Collections


public class CrudTests extends BaseTest {


    // Test : Create a new user
    @Test(groups = {"crud"})
    public void testCreateUser() {
        String name = (String) TestData.newUser.get("name");
        String email = (String) TestData.newUser.get("email");
        ValidatableResponse createUser = api.createUser(TestData.newUser);
        createUser.statusCode(201)
                  .body("name", equalTo(name))
                  .body("email", equalTo(email));
    }

    // Test : Read an existing user, or users
    @Test(groups = {"crud"})
    public void testGetUserById() {
        ValidatableResponse userById = api.getUserById(1);
        userById.statusCode(200)
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("email", notNullValue());
    }

    @Test(groups = {"crud"})
    public void testGetAllUsers() {
        ValidatableResponse allUsers = api.getAllUsers();
        allUsers.statusCode(200)
                .body("size()", greaterThan(0)); // size() is a groovy method to get size of array
    }

    // Test : Update an existing user using PUT, PATCH
    @Test(groups = {"crud"})
    public void testResetUser() {
        // put method to reset existing user

        int id = (int) TestData.existingUser.get("id");
        ValidatableResponse resetUser = api.resetUser(id, TestData.existingUser);
        resetUser.statusCode(200);

        // Convert JSON object to Map
        Map<String, Object> jsonMap = resetUser.extract().response().as(Map.class);

        // Assert each field in the map
        assertEquals(jsonMap, TestData.existingUser);
    }

    @Test(groups = {"crud"})
    public void testUpdateUser() {
        // patch method to update existing user

        int id = (int) TestData.existingUser.get("id");

        ValidatableResponse updateUser = api.updateUser(id, TestData.existingUser);
        updateUser.statusCode(200)
                  .body("id", equalTo(id))
                  .body("name", equalTo(TestData.existingUser.get("name")))
                  .body("email", equalTo(TestData.existingUser.get("email")));
    }

    // Test : Delete an existing user
    @Test(groups = {"crud"})
    public void testDeleteUser() {
        ValidatableResponse deleteUser = api.deleteUser(1);
        deleteUser.statusCode(200).body("", equalTo(Collections.emptyMap()));;
    }
}