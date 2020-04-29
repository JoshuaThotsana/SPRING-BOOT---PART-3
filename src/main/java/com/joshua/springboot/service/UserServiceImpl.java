package com.joshua.springboot.service;
import com.joshua.springboot.repository.FakeRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private FakeRepo repo;

    public UserServiceImpl(FakeRepo repo) {
        this.repo = repo;
    }

    @Override
    public String addUser(String name, String surname) {
        repo.insertUser(repo.getCount(),name,surname);
        System.out.printf("[%s] entered",name);
        System.out.println();
        return "[" + name + "] " + "entered";
    }

    @Override
    public String removeUser(long Id) {
        String update = String.format("[%s] removed",repo.deleteUser(Id));
        System.out.println(update);
        System.out.println();
        return update;
    }

    @Override
    @Cacheable("name")
    public String getUser(long Id) {
        String update = String.format("hello [%s]",repo.findUserById(Id));
        System.out.println(update);
        System.out.println();

        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return update;
    }
}
