package com.softserve.sportshub.comment.dto;

import com.softserve.sportshub.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadCommentDto {
    private Long id;
    private String content;
    private String createdAt;
    private String owner;
    private Long numberOfLikes;
    private Long numberOfDislikes;
}
