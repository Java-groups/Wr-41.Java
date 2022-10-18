package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;
import com.softserve.sportshub.user.dto.UserDto;
import com.softserve.sportshub.utils.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
      // DB might have no USER role saved
      try {
         roleDao.findByName(USER_ROLE);
      } catch (Exception e){
         System.out.println("No USER role found id db, creating new");
         roleDao.save(new Role(USER_ROLE));
      }
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
   public UserDto findUserByUsername(String username) {
      return UserDto.mapUserToDto(userDao.findByUsername(username));
   }

   @Override
   public void addRoleToUser(String username, String roleName) {
      User user = userDao.findByUsername(username);
      Role role = roleDao.findByName(roleName);
      user.getRoles().add(role);
   }

   @Override
   public User changeUserPassword(String username, String currentPassword, String newPassword, String newPasswordRepeat) throws Exception {
      if(!newPassword.equals(newPasswordRepeat)){
         throw new Exception("Passwords must be the same!");
      }
      User user = userDao.findByUsername(username);
      if(passwordEncoder.matches(currentPassword, user.getPassword())){
         user.setPassword(passwordEncoder.encode(newPassword));
      }
      return user;
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