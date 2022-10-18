package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.category.model.Category;
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
    Boolean showComments;
    Category category;
    Boolean isPublished;
}