package com.softserve.sportshub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private boolean isBlocked;

    @Column
    private boolean isSubscriber;

    public User(String username, boolean isBlocked, boolean isSubscriber) {
        this.username = username;
        this.isBlocked = isBlocked;
        this.isSubscriber = isSubscriber;
    }
}
