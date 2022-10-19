package com.softserve.sportshub.user;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;
import com.softserve.sportshub.user.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

class UserServiceImpTest {
    BCryptPasswordEncoder passwordEncoder = Mockito.mock(BCryptPasswordEncoder.class);

    @BeforeEach
    public void before() {
        Mockito.when(passwordEncoder.encode("myPass")).thenReturn("SOME_HASHED_PASSWORD");
    }

    @Test
    public void shouldCreateUserTest(){
        //Given users, userDtos, roles
        Role userRole = new Role("USER");
        Role userRoleSaved = new Role(1L, "USER");

        User user = new User(null, "Karol", "myPass", false, false, new ArrayList<>());
        Collection<Role> roles = new ArrayList<>();
        roles.add(userRoleSaved);
        User userAfterSave = new User(1L, user.getUsername(), user.getPassword(), user.isBlocked(), user.isSubscriber(), roles);

        UserDto userDto = new UserDto(null, user.getUsername(), user.getPassword(), user.isBlocked(), user.isSubscriber());
        UserDto userDtoAfterSave = new UserDto(1L, user.getUsername(), passwordEncoder.encode(user.getPassword()), user.isBlocked(), user.isSubscriber());

        //Given mocks, userServiceImp created
        UserDao userDaoMock = Mockito.mock(UserDao.class);
        RoleDao roleDaoMock = Mockito.mock(RoleDao.class);
        UserServiceImp userServiceImp = new UserServiceImp(userDaoMock, roleDaoMock, passwordEncoder);

        //Given behavior of the mocks
        Mockito.when(roleDaoMock.findByName("USER")).thenReturn(null);
        Mockito.when(roleDaoMock.save(userRole)).thenReturn(userRoleSaved);
        Mockito.when(userDaoMock.save(user)).thenReturn(userAfterSave);

        //Given behavior of the static mocks
        MockedStatic<UserDto> userDtoMockedStatic = Mockito.mockStatic(UserDto.class);
        userDtoMockedStatic.when(() -> UserDto.mapUserDtoToUser(userDto)).thenReturn(user);
        userDtoMockedStatic.when(() -> UserDto.mapUserToDto(userAfterSave)).thenReturn(userDtoAfterSave);

        //When
        UserDto savedUserDto = userServiceImp.save(userDto);
        System.out.println(savedUserDto);
        //Then
        Assertions.assertThat(userDto.getUsername()).isEqualTo(savedUserDto.getUsername());
        Assertions.assertThat(userDto.isBlocked()).isEqualTo(savedUserDto.isBlocked());
        Assertions.assertThat(userDto.isSubscriber()).isEqualTo(savedUserDto.isSubscriber());
        Assertions.assertThat(passwordEncoder.encode(userDto.getPassword())).isEqualTo(savedUserDto.getPassword());
    }

}