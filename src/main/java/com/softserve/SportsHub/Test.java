package com.softserve.SportsHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


@Component
@Entity
public class Test {

    private String message;

    public String getMessage() {
        return message;
    }

    @Autowired
    public Test(String message) {
        this.message = message;
    }
}
