package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.CreateArticleCommand;

import java.util.List;

public interface ArticleService {
    ArticleDto findById(Long id);

    List<ArticleDto> getAllArticles();

    ArticleDto save(CreateArticleCommand article);

    void delete(Long id);
}
