package com.joshua.springboot.repository;

import com.joshua.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeRepo implements FakeRepoInterface {

    private int count = 0; // this variable will be used to auto increment the id field when we insert a new user.

    private User user;

    List<User> users = new ArrayList<>();

    public long getCount() {
        return count;
    }

    @Override
    public User insertUser(long id, String name, String surname) {
        count++;
        user = new User(count, name, surname);
        users.add(user);
        return user;
    }

    @Override
    public String findUserById(long id) {
        for (int i = 0; i < users.size(); i++){
            if (user.getId() == id) {
                return user.getName();
            }
        }
        return null;
    }

    @Override
    public String deleteUser(long id) {
        for (User value : users) {
            if (value.getId() == id) {
                return value.getName();
            }
        }
        return null;
    }

}
