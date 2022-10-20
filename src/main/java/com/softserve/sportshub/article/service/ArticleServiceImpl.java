package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dto.UpdateArticleCategoryCommand;
import com.softserve.sportshub.article.dao.ArticleDao;
import com.softserve.sportshub.article.domain.Article;
import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.ArticleMapper;
import com.softserve.sportshub.article.dto.CreateArticleCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleDto findById(Long id) {
        Article article = articleDao.findOne(id);
        return articleMapper.toDto(article);
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        return articleDao.findAll()
                .stream()
                .map(articleMapper::toDto)
                .toList();
    }

    @Override
    public ArticleDto save(CreateArticleCommand command) {
        Article article = articleMapper.toArticle(command);
        return articleMapper.toDto(articleDao.save(article));
    }

    @Override
    public void updateCategory(Long id, UpdateArticleCategoryCommand command) {
        Article article = articleDao.findOne(id);
        article.getCategory().setName(command.getCategory().getName());
    }

    @Override
    public void turnOffComments(Long id) {
        Article article = articleDao.findOne(id);
        article.setShowComments(false);
    }

    @Override
    public void turnOnComments(Long id) {
        Article article = articleDao.findOne(id);
        article.setShowComments(true);
    }

    @Override
    public void publish(Long id) {
        Article article = articleDao.findOne(id);
        article.setIsPublished(true);

    }

    @Override
    public void unpublish(Long id) {
        Article article = articleDao.findOne(id);
        article.setIsPublished(false);
    }

    @Override
    public void delete(Long id) {
        articleDao.delete(id);
    }
}
