package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dto.ArticleDto;
import lombok.Value;

import java.util.List;

public interface ArticleService {
    ArticleDto FindById(Long id);
    List<ArticleDto> getAllArticles();
    ArticleDto save(CreateArticleCommand article);
    void delete(Long id);

    @Value
    class CreateArticleCommand{
        String language;
        String pic;
        String alternativePic;
        String headline;
        String caption;
        String content;
        Boolean showComments;
    }
}
