package ryu.utils;

import java.util.Map; // needed for using Map

public class TestData {

    // map for put test - existing user, use same for patch
    public static final Map <String, Object> existingUser = Map.of(
        "id", 1,
        "name", "Ice Graham",
        "email", "Sincere@ap"
    );

    // map for put test - new user
    public static final Map <String, Object> newUser = Map.of(
        "id", 12,
        "name", "New User",
        "email", "new@user"
    );
}