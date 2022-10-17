package com.softserve.sportshub.role;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImpl implements RoleDao {

   private final SessionFactory sessionFactory;

   public RoleDaoImpl(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public Role save(Role role) {
      Long id = (Long) sessionFactory.getCurrentSession().save(role);
      role.setId(id);
      return role;
   }

   @Override
   public Role findByName(String name) {
      TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("select r from Role r where r.name = :name");
      query.setParameter("name", name);
      return query.getSingleResult();
   }
}