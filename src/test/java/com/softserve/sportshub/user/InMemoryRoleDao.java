package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryRoleDao implements RoleDao {

    private Map<Long, Role> roles = new HashMap<>();
    private Long key = 1L;



    @Override
    public Role save(Role role) {
        List<Role> rolesFiltered = roles.values().stream().filter(r -> r.getName().equals(role.getName())).toList();
        if(rolesFiltered.size() == 0){
            role.setId(key);
            key++;
            roles.put(key, role);
            System.out.println(role);
        } else {
//            return rolesFiltered.get(0);
            return null;
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        List<Role> roleList = roles.values().stream().filter(role -> role.getName().equals(name)).toList();
        System.out.println(roleList);
        if(roleList.size() == 0){
            return null;
        } else {
            return roleList.get(0);
        }
    }
}
