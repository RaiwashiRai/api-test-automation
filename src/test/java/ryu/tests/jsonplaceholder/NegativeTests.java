package ryu.tests.jsonplaceholder;

import ryu.tests.jsonplaceholder.BaseTest;
import ryu.utils.TestData; // import TestData to use test data maps

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*; // for assertions


public class NegativeTests extends BaseTest {

    // GET /users/999 → returns {} (empty object).
    @Test(groups = {"negative"})
    public void testGetNonExistentUserById() {
        ValidatableResponse userById = api.getUserById(999);
        userById.statusCode(404)
                .body("isEmpty()", is(true)); // Check if the response body is an empty object
    }

    //POST /users with empty body → still returns 201 (mock behavior, but document it).
    @Test(groups = {"negative"})
    public void testCreateUserWithEmptyBody() {
        ValidatableResponse createUser = api.createUser(TestData.emptyMap);
        createUser.statusCode(201)
                  .body("id", notNullValue()); // Check if an id is returned
    }

}