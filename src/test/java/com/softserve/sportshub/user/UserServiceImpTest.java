package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;
import com.softserve.sportshub.role.RoleServiceImpl;
import com.softserve.sportshub.user.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;

class UserServiceImpTest {

    private final UserDao userDao = new InMemoryUserDao();
    private final RoleDao roleDao = new InMemoryRoleDao();
    BCryptPasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
    private final RoleServiceImpl roleService = new RoleServiceImpl(roleDao);
    UserServiceImp userService;
    @BeforeEach
    public void before(){
        Mockito.when(passwordEncoder.encode(any())).thenReturn("hashedPassword");
        userService = new UserServiceImp(userDao, roleDao, passwordEncoder);
    }

    @Test
    public void shouldCreateUserTest(){
        //Given
        UserDto inputUserData = new UserDto(null, "Karol", "myPass123", false, false);
        Role userRole = new Role("USER");

        Mockito.when(passwordEncoder.encode(any())).thenReturn("hashedPassword");
        //When
        roleService.save(userRole);
        UserDto savedUserDto = userService.save(inputUserData);
//        //Then
        Assertions.assertThat(savedUserDto.getUsername()).isEqualTo(inputUserData.getUsername());
        Assertions.assertThat(savedUserDto.getPassword()).isEqualTo("hashedPassword");
    }

}