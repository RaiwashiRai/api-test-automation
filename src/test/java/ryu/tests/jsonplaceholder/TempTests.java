package ryu.tests.jsonplaceholder;

import ryu.tests.jsonplaceholder.BaseTest;
import ryu.utils.jsonplaceholder.TestData;

import org.testng.annotations.Test;
import ryu.api.JsonPlaceholderApi;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TempTests extends BaseTest {
    

    private JsonPlaceholderApi api = new JsonPlaceholderApi(); // change later if needed -> to @beforClass or keep it in base test class

    // This tests are temperory to test the API class, hence modify later to test it actually.
    @Test(groups = {"temp"}, enabled = false)
    public void testGetAllUsers() {
        ValidatableResponse allUsers = api.getAllUsers();
        // System.out.println(extractResponse(allUsers).asString());
        allUsers.statusCode(200);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testGetUserById() {
        ValidatableResponse userById = api.getUserById(1);
        // System.out.println(extractResponse(userById).asString());
        userById.statusCode(200);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testCreateUser() {
        ValidatableResponse createUser = api.createUser("John Doe", "John.Doe@abc.com");
        // System.out.println(extractResponse(createUser).asString());
        createUser.statusCode(201);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testResetUser() {
        ValidatableResponse resetUser = api.resetUser((Integer) TestData.existingUser.get("id"), TestData.existingUser);
        // System.out.println(extractResponse(resetUser).asString());
        resetUser.statusCode(200);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testResetUserNew() {
        ValidatableResponse resetUserNew = api.resetUser((Integer) TestData.existingUser.get("id"), TestData.newUser);
        // System.out.println(extractResponse(resetUserNew).asString());
        resetUserNew.statusCode(200);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testUpdateUser() {
        ValidatableResponse updateUser = api.updateUser((Integer) TestData.existingUser.get("id"), TestData.existingUser);
        System.out.println(extractResponse(updateUser).asString());
        updateUser.statusCode(200);
    }

    @Test(groups = {"temp"}, enabled = false)
    public void testDeleteUser() {
        ValidatableResponse deleteUser = api.deleteUser(1);
        deleteUser.statusCode(200);
    }  

    @Test(groups = {"temp"}, enabled = false)
    public void tempLoggingTest() {
        api.getAllUsers().statusCode(404); //to make sure the test always fails, so that we can see the logs
    }
}