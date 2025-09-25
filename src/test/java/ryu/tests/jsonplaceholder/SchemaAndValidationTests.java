package ryu.tests.jsonplaceholder;

import ryu.tests.jsonplaceholder.BaseTest;
import ryu.utils.TestData; // import TestData to use test data maps

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.matchesPattern;

// For schema validation
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class SchemaAndValidationTests extends BaseTest {

    @Test(groups = {"schema"})
    public void testUserSchemaValidation() {
        ValidatableResponse userById = api.getUserById(1);
        userById.statusCode(200)
                .body(matchesJsonSchemaInClasspath("ryu/schemas/UserSchema.json"))
                .body("email", matchesPattern("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"));
    }
}