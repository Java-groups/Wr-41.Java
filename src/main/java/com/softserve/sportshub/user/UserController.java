package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleService;
import com.softserve.sportshub.user.dto.UserDto;
import com.softserve.sportshub.user.dto.UserDtoUpdates;
import com.softserve.sportshub.user.dto.UserPasswordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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

  @PatchMapping("/users/me/password")
  public ResponseEntity<UserDto> updatePassword(@RequestBody UserPasswordDto passwordDto) throws Exception {
    UserDto user = userService.changeUserPassword(
            passwordDto.getPassword(),
            passwordDto.getNewPassword(),
            passwordDto.getNewPasswordRepeat());
    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/users/me")
  public ResponseEntity<UserDto> getUserProfile() throws UserPrincipalNotFoundException {
    User userFromContext = userService.getCurrentUser();
    return ResponseEntity.ok().body(UserDto.mapUserToDto(userFromContext));
  }

  @PatchMapping("/users/me")
  public ResponseEntity<UserDto> updateUserProfile(@RequestBody UserDtoUpdates updates) throws UserPrincipalNotFoundException {
    UserDto updatedUser = userService.updateUser(updates);
    return ResponseEntity.ok().body(updatedUser);
  }
}