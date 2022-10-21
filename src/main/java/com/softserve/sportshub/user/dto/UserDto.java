package com.softserve.sportshub.user.dto;

import com.softserve.sportshub.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isBlocked;
    private boolean isSubscriber;

    public static UserDto mapUserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setBlocked(user.isBlocked());
        userDto.setSubscriber(user.isSubscriber());
        return userDto;
    }

    public static User mapUserDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setSubscriber(userDto.isSubscriber());
        user.setBlocked(userDto.isBlocked());
        return user;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", isSubscriber=" + isSubscriber +
                '}';
    }
}
