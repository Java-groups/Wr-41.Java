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
                article.getShowComments()
        );
    }

    public Article toArticle(CreateArticleCommand command) {
        return new Article(
                Language.valueOf(command.getLanguage()),
                command.getPic(),
                command.getAlternativePic(),
                command.getHeadline(),
                command.getCaption(),
                command.getContent(),
                command.getShowComments(),
                command.getCategory(),
                command.getIsPublished()
        );
    }
}
