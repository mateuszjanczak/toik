package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<Integer, User> usersDatabase;

    public UserRepository() {
        usersDatabase = new HashMap<>();

        usersDatabase.put(1, new User("cracker", "cracker1234", true, 0));
        usersDatabase.put(2, new User("marry", "marietta!#09", true, 0));
        usersDatabase.put(3, new User("silver", "$silver$", true, 0));
    }

    public Type checkLogin(final String login, final String password) {

         for(Map.Entry<Integer, User> entry: usersDatabase.entrySet()) {

             int key = entry.getKey();
            User user = entry.getValue();

            if(user.getLogin().equals(login)) {
                if(user.getIncorrectLoginCounter() >= 3) return Type.IncorrectLoginCounter;

                if(user.getPassword().equals(password)) {
                    user.setIncorrectLoginCounter(0);
                    usersDatabase.replace(key, user);
                    return Type.SuccessfulLogin;
                } else {
                    user.setIncorrectLoginCounter(user.getIncorrectLoginCounter() + 1);
                    usersDatabase.replace(key, user);
                    return Type.FailureLogin;
                }
            }
         }

        return Type.FailureLogin;
    }
}
