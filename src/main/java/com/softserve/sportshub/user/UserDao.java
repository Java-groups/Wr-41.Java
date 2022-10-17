package com.softserve.sportshub.user;

import java.util.List;

public interface UserDao {
   User save(User user);
   List<User> list();
   User findByUsername(String username);
}