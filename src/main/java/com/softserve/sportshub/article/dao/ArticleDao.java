package com.softserve.sportshub.article.dao;

import com.softserve.sportshub.article.domain.Article;

import java.util.List;

public interface ArticleDao {
    Article findOne(long id);
    List<Article> findAll();
    Article save(Article article);
    Article update(Article article);
    void delete(Article article);
    void delete(Long id);
}
