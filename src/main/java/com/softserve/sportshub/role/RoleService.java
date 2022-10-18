package com.softserve.sportshub.role;

public interface RoleService {
   Role save(Role role);
   Role findByName(String roleName);
}