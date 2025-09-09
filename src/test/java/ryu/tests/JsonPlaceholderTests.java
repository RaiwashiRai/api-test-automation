package ryu.tests;
import ryu.api.JsonPlaceholderApi;
import org.testng.annotations.Test;

public class JsonPlaceholderTests {

    @Test
    public void testGetAllUsers() {
        JsonPlaceholderApi api = new JsonPlaceholderApi();
        System.out.println(api.getAllUsers().getStatusCode());
    }
}