package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dao.ArticleDao;
import com.softserve.sportshub.article.domain.Article;
import com.softserve.sportshub.article.domain.Language;
import com.softserve.sportshub.article.dto.ArticleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    @Override
    public ArticleDto FindById(Long id) {
        Article article = articleDao.findOne(id);
        return ArticleDto.mapArticleToDto(article);
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        return articleDao.findAll()
                .stream()
                .map(ArticleDto::mapArticleToDto)
                .toList();
    }

    @Override
    public ArticleDto save(CreateArticleCommand command) {
        Article article= new Article(
                Language.valueOf(command.getLanguage()),
                command.getPic(),
                command.getAlternativePic(),
                command.getHeadline(),
                command.getCaption(),
                command.getContent(),
                command.getShowComments()
        );
        return ArticleDto.mapArticleToDto(articleDao.save(article));
    }

    @Override
    public void delete(Long id) {
        articleDao.delete(id);
    }
}
