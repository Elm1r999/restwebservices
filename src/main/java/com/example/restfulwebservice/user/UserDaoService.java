package com.example.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    public static int userCount = 5;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "User 1", new Date()));
        users.add(new User(2, "User 2", new Date()));
        users.add(new User(3, "User 3", new Date()));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteByID(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}