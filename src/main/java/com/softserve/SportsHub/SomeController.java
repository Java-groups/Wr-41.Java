package com.softserve.SportsHub;

import com.softserve.SportsHub.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    public SomeController() {
        System.out.println("SOME CONTROLLER CONTRUCTOR");
    }

    @GetMapping("hello")
    public String test(){
        return "Hello";
    }

    @GetMapping
    public User getUser(){
        User user = new User("KArol", true, false);
        return user;
    }
}
