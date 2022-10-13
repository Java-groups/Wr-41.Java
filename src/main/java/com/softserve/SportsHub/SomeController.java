package com.softserve.SportsHub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SomeController {


    public SomeController() {
        System.out.println("<---rest controller is called--->");
    }

    @GetMapping("/justhello")
    public String test(){
        return "Hello";
    }

    @GetMapping("/")
    public String smthElse() { return "not this"; }

    @GetMapping("/hi")
    public String anotherOne() { return "how are you"; }

}
