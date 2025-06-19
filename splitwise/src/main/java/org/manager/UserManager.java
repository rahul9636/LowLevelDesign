package org.manager;

import org.exceptions.UserNotFoundException;
import org.models.User;

import java.util.HashMap;

public class UserManager {

    private HashMap<String , User> userHashMap = new HashMap<>();

    public User getUser(String id) throws UserNotFoundException {
        if(!userHashMap.containsKey(id)) {
            throw new UserNotFoundException();
        }

        return userHashMap.get(id);
    }

    public void registerUser(User user) {
        userHashMap.put(user.getUserId(), user);
    }
}
