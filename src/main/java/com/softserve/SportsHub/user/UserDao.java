package com.softserve.SportsHub.user;

import java.util.List;

public interface UserDao {
   void save(User user);
   List<User> list();
   User getUserById(Long id);
}