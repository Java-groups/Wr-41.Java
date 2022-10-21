package com.softserve.sportshub.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserDao implements UserDao{

    private Map<Long, User> users = new HashMap<>();
    private Long key = 1L;

    @Override
    public User save(User user) {
        user.setId(key);
        users.put(key, user);
        key++;
        users.values().forEach(System.out::println);
        return user;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void removeUser(User user) {
        return;
    }
}
