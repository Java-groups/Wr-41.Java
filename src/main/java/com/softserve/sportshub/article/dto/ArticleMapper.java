package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.article.domain.Article;
import com.softserve.sportshub.article.domain.Language;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDto toDto(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getLanguage().toString(),
                article.getPic(),
                article.getAlternativePic(),
                article.getHeadline(),
                article.getCaption(),
                article.getContent(),
                article.getShowComments(),
                article.getCategory(),
                article.getIsPublished()
        );
    }

    public Article toArticle(CreateArticleCommand command) {
        return Article
                .builder()
                .language(Language.valueOf(command.getLanguage()))
                .pic(command.getPic())
                .alternativePic(command.getAlternativePic())
                .headline(command.getHeadline())
                .caption(command.getCaption())
                .content(command.getContent())
                .showComments(command.getShowComments())
                .isPublished(command.getIsPublished())
                .build();
    }
}
