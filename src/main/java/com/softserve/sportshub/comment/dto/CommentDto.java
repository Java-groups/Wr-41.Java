package com.softserve.sportshub.comment.dto;

import com.softserve.sportshub.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;
    private String createdAt;
    private User owner;
    private Long numberOfLikes;
    private Set<User> listOfUserLikes;
    private Set<User> listOfUserDislikes;
}
