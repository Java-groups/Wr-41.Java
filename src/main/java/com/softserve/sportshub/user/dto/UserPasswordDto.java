package com.softserve.sportshub.user.dto;

import lombok.Data;

@Data
public class UserPasswordDto {

    private String password;
    private String newPassword;
    private String newPasswordRepeat;
}
