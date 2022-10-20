package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.category.model.Category;
import lombok.Value;

@Value
public class ArticleDto {
    Long id;
    String language;
    String pic;
    String alternativePic;
    String headline;
    String caption;
    String content;
    Boolean showComments;
    Category category;
    Boolean isPublished;
}
