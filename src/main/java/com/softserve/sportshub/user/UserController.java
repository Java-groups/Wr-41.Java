package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleService;
import com.softserve.sportshub.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

  private final UserService userService;
  private final RoleService roleService;

  public UserController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

//  ROLES
  @PostMapping("/roles")
  public ResponseEntity<Role> saveRole(@RequestBody Role role){
    Role savedRole = roleService.save(role);
    URI savedEntityLocation = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedRole.getId())
            .toUri();
    return ResponseEntity.created(savedEntityLocation).body(savedRole);
  }

// USERS
  @GetMapping("/users")
  public ResponseEntity<List<UserDto>> getUserList(){
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @PostMapping("/users")
  public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
    UserDto savedUser = userService.save(userDto);
    URI savedEntityLocation = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(savedEntityLocation).body(savedUser);
  }
}