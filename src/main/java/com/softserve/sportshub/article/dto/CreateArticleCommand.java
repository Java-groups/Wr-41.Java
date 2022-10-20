package com.softserve.sportshub.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleCommand {
    String language;
    String pic;
    String alternativePic;
    String headline;
    String caption;
    String content;
    Long categoryId;
    Boolean showComments;
    Boolean isPublished;
}