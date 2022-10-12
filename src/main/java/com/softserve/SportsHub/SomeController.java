package com.softserve.SportsHub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
