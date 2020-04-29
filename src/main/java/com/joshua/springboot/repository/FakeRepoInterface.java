package com.joshua.springboot.repository;

import com.joshua.springboot.entity.User;

public interface FakeRepoInterface {

    User insertUser(long id, String name, String surname);
    String findUserById(long id);
    String deleteUser(long id);

    long getCount();
}
