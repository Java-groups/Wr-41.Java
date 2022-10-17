package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;
import com.softserve.sportshub.user.dto.UserDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional
public class UserServiceImp implements UserService, UserDetailsService {

   private final String USER_ROLE = "USER";
   private final UserDao userDao;
   private final RoleDao roleDao;
   private final PasswordEncoder passwordEncoder;

   public UserServiceImp(UserDao userDao, RoleDao roleDao, @Lazy PasswordEncoder passwordEncoder) {
      this.userDao = userDao;
      this.roleDao = roleDao;
      this.passwordEncoder = passwordEncoder;
   }

   @Override
   public UserDto save(UserDto userDto) {
      User user = UserDto.mapUserDtoToUser(userDto);
      Role role = roleDao.findByName(USER_ROLE);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.getRoles().add(role);
      User savedUser = userDao.save(user);
      return UserDto.mapUserToDto(savedUser);
   }

   @Override
   public List<UserDto> getAllUsers() {
      List<User> list = userDao.list();
      return list.stream().map(UserDto::mapUserToDto).toList();
   }

   @Override
   public User getCurrentUser() throws UserPrincipalNotFoundException {
      String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      try {
         return userDao.findByUsername(username);
      } catch (Exception e){
         throw new UserPrincipalNotFoundException(e.getMessage());
      }
   }


   @Override
   public void addRoleToUser(String username, String roleName) {
      User user = userDao.findByUsername(username);
      Role role = roleDao.findByName(roleName);
      user.getRoles().add(role);
   }

   @Override
   public UserDto changeUserPassword(String currentPassword, String newPassword, String newPasswordRepeat) throws Exception {
      if(!newPassword.equals(newPasswordRepeat)){
         throw new Exception("Passwords must be the same!");
      }
      User user = getCurrentUser();
      if(passwordEncoder.matches(currentPassword, user.getPassword())){
         user.setPassword(passwordEncoder.encode(newPassword));
      }
      return UserDto.mapUserToDto(user);
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userDao.findByUsername(username);
      if(user == null){
         throw new UsernameNotFoundException("User not found in db!");
      } else {
         System.out.println("User has been found");
      }
      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
   }
}