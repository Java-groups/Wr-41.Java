package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.team.Team;
import lombok.Value;

import java.util.List;

@Value
public class ArticleDto {
    Long id;
    String language;
    String pic;
    String alternativePic;
    String headline;
    String caption;
    String content;
    Category category;
    Team team;
    List<Comment> comments;
    Boolean showComments;
    Boolean isPublished;
}
