package com.softserve.SportsHub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
 
   @Autowired
   private UserDao userDao;
 
   @Transactional
   public void save(User user) {
      userDao.save(user);
   }
 
//   @Transactional(readOnly = true)
   @Transactional
   public List<User> list() {
      return userDao.list();
   }

   @Override
   @Transactional
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }
}