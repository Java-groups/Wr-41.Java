package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean isBlocked;
    @Column
    private boolean isSubscriber;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(String username, String password, boolean isBlocked, boolean isSubscriber) {
        this.username = username;
        this.password = password;
        this.isBlocked = isBlocked;
        this.isSubscriber = isSubscriber;
    }
}
