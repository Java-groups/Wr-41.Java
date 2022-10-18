package com.softserve.sportshub.role;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class RoleServiceImpl implements RoleService {

   private final RoleDao roleDao;

   public RoleServiceImpl(RoleDao roleDao) {
      this.roleDao = roleDao;
   }

   @Override
   public Role save(Role role) {
      return roleDao.save(role);
   }

   @Override
   public Role findByName(String roleName) {
      return roleDao.findByName(roleName);
   }
}