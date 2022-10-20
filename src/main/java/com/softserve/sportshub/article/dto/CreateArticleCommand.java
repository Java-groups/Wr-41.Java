package com.softserve.sportshub.article.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleCommand{
    String language;
    String pic;
    String alternativePic;
    String headline;
    String caption;
    String content;
    Boolean showComments;
}
