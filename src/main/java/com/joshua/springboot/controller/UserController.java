package com.joshua.springboot.controller;

import com.joshua.springboot.service.UserService;
import com.joshua.springboot.service.UserServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Create a an xml file that will handle all the configurations
@ComponentScan(basePackages = {"com.joshua.springboot"}) // Scan the main package and subpackages to create all Beans required.
public class UserController implements Controller {

    private final UserService service; // reference variable

    public UserController(UserServiceImpl service) {
        this.service = service; // Create an instance of UserService by injection the class that implements it.
    }

    public void callService() {

        // Sample data

        service.addUser("Joshua","Mabotsa");
        service.addUser("Joshua2","Mabotsa2");
        service.addUser("Joshua3","Mabotsa3");

        service.removeUser(2);
        service.getUser(3);
    }

}
