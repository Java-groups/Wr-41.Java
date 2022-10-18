package com.softserve.sportshub.user;

import com.softserve.sportshub.user.dto.UserDto;

import java.util.List;

public interface UserService {
   UserDto save(UserDto user);
   List<UserDto> getAllUsers();
   UserDto findUserByUsername(String username);
   void addRoleToUser(String username, String roleName);
   User changeUserPassword(String username, String currentPassword, String newPassword, String newPasswordRepeat) throws Exception;

}