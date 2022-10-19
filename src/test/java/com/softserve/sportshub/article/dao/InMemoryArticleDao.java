package com.softserve.sportshub.article.dao;

import com.softserve.sportshub.article.domain.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryArticleDao implements ArticleDao {
    private Long genId = 0L;
    Map<Long, Article> articleMap = new HashMap<>();

    @Override
    public Article findOne(long id) {
        return articleMap.get(id);
    }

    @Override
    public List<Article> findAll() {
        return articleMap.values().stream().toList();
    }

    @Override
    public Article save(Article article) {
        if (article.getId() == null) {
            article.setId(genId++);
        }
        articleMap.put(article.getId(), article);
        return articleMap.get(article.getId());
    }

    @Override
    public Article update(Article article) {
        articleMap.put(article.getId(), article);
        return articleMap.get(article.getId());
    }

    @Override
    public void delete(Article article) {
        articleMap.remove(article.getId());
    }

    @Override
    public void delete(Long id) {
        articleMap.remove(id);
    }
}
