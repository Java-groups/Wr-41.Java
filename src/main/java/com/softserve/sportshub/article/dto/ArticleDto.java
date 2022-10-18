package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.article.domain.Article;
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

    public ArticleDto(Long id, String language, String pic, String alternativePic, String headline, String caption, String content, Boolean showComments) {
        this.id = id;
        this.language = language;
        this.pic = pic;
        this.alternativePic = alternativePic;
        this.headline = headline;
        this.caption = caption;
        this.content = content;
        this.showComments = showComments;
    }

    public static ArticleDto mapArticleToDto(Article article){
        return new ArticleDto(
                article.getId(),
                article.getLanguage().toString(),
                article.getPic(),
                article.getAlternativePic(),
                article.getHeadline(),
                article.getCaption(),
                article.getContent(),
                article.getShowComments()
                );
    }
}
