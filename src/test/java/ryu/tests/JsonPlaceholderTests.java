package ryu.tests;
import ryu.api.JsonPlaceholderApi;
import org.testng.annotations.Test;

public class JsonPlaceholderTests {

    // This test is temperory to test the API class, hence modify later to test it actually.

    @Test(groups = {"temp"}, enabled = true)
    public void temperoryTests() {

        JsonPlaceholderApi api = new JsonPlaceholderApi();
        String boldRed = "\u001B[1;32m";
        String reset = "\u001B[0m";

        // checks getAllUsers() method
        System.out.println(boldRed + "\ngetAllUsers() response:\n" + reset);
        System.out.println(api.getAllUsers().asString() + "\n");

        // checks getUserById() method
        System.out.println(boldRed + "\ngetUserById() response:\n" + reset);
        System.out.println(api.getUserById(1).asString() + "\n");

        // checks createUser() method
        System.out.println(boldRed + "\ncreateUser() response:\n" + reset);
        System.out.println(api.createUser("John Doe", "John.Doe@abc.com").asString() + "\n");

        // checks deleteUser() method
        System.out.println(boldRed + "\ndeleteUser() response:\n" + reset);
        System.out.println(api.deleteUser(1).asString() + "\n");
    }
}