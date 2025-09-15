package ryu.tests;

import ryu.tests.BaseTest;
import org.testng.annotations.Test;
import ryu.api.JsonPlaceholderApi;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class JsonPlaceholderTests extends BaseTest {
    

    private JsonPlaceholderApi api = new JsonPlaceholderApi(); // change later if needed -> to @beforClass or keep it in base test class

    // This tests are temperory to test the API class, hence modify later to test it actually.
    @Test(groups = {"temp"})
    public void testGetAllUsers() {
        ValidatableResponse allUsers = api.getAllUsers();
        // System.out.println(extractResponse(allUsers).asString());
        allUsers.statusCode(200);
    }

    @Test(groups = {"temp"})
    public void testGetUserById() {
        ValidatableResponse userById = api.getUserById(1);
        // System.out.println(extractResponse(userById).asString());
        userById.statusCode(200);
    }

    @Test(groups = {"temp"})
    public void testCreateUser() {
        ValidatableResponse createUser = api.createUser("John Doe", "John.Doe@abc.com");
        // System.out.println(extractResponse(createUser).asString());
        createUser.statusCode(201);
    }

    @Test(groups = {"temp"})
    public void testDeleteUser() {
        ValidatableResponse deleteUser = api.deleteUser(1);
        deleteUser.statusCode(200);
    }  

    @Test(groups = {"temp"}, enabled = false)
    public void tempLoggingTest() {
        api.getAllUsers().statusCode(404); //to make sure the test always fails, so that we can see the logs
    }
}