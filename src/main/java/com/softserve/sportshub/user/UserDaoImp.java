package com.softserve.sportshub.user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
 
   @Autowired
   private SessionFactory sessionFactory;
 
   @Override
   public User save(User user) {
      Long id = (Long) sessionFactory.getCurrentSession().save(user);
      user.setId(id);
      return user;
   }

   @Override
   public List<User> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findByUsername(String username) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.username = :username");
      query.setParameter("username", username);
      return query.getSingleResult();
   }
}