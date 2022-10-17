package com.softserve.sportshub.role;

public interface RoleDao {
   Role save(Role role);
   Role findByName(String name);
}