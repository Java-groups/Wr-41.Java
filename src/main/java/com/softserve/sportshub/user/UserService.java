package com.softserve.sportshub.user;

import com.softserve.sportshub.user.dto.UserDto;
import com.softserve.sportshub.user.dto.UserDtoUpdates;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserService {
   UserDto save(UserDto user);
   List<UserDto> getAllUsers();
   User getCurrentUser() throws UserPrincipalNotFoundException;
   void addRoleToUser(String username, String roleName);
   UserDto changeUserPassword(String currentPassword, String newPassword, String newPasswordRepeat) throws Exception;
   UserDto updateUser(UserDtoUpdates updates) throws UserPrincipalNotFoundException;
}