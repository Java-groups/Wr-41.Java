package com.softserve.sportshub.article.service;

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
public class ArticleServiceImpl implements ArticleService {
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
    public void delete(Long id) {
        articleDao.delete(id);
    }
}
