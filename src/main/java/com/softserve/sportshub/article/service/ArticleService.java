package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dto.UpdateArticleCategoryCommand;
import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.CreateArticleCommand;

import java.util.List;

public interface ArticleService {
    ArticleDto findById(Long id);

    List<ArticleDto> getAllArticles();

    ArticleDto save(CreateArticleCommand article);

    void delete(Long id);

    void updateCategory(Long id, UpdateArticleCategoryCommand command);

    void turnOffComments(Long id);

    void turnOnComments(Long id);

    void publish(Long id);

    void unpublish(Long id);
}
