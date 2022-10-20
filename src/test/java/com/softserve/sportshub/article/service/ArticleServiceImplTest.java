package com.softserve.sportshub.article.service;

import com.softserve.sportshub.article.dao.ArticleDao;
import com.softserve.sportshub.article.dao.InMemoryArticleDao;
import com.softserve.sportshub.article.domain.Article;
import com.softserve.sportshub.article.domain.Language;
import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.ArticleMapper;
import com.softserve.sportshub.article.dto.CreateArticleCommand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleServiceImplTest {

    ArticleDao articleDao = new InMemoryArticleDao();

    ArticleMapper articleMapper = new ArticleMapper();

    ArticleServiceImpl articleService = new ArticleServiceImpl(articleDao, articleMapper);

//    @Test
//    public void findArticleById() {
//        //given
//        Article article = givenArticle("Breaking news! We're testing our code!");
//
//        //when
//        ArticleDto articleDto = articleService.findById(article.getId());
//
//        //then
//        assertEquals(article.getContent(), articleDto.getContent());
//        assertEquals(article.getId(), articleDto.getId());
//        assertEquals(article.getLanguage(), Language.valueOf(articleDto.getLanguage()));
//    }
//
//    @Test
//    public void getAllArticles() {
//        //given
//        Article article = givenArticle("Breaking news! We're testing our code!");
//        Article article2 = givenArticle("Breaking news! We're testing our code!");
//        List<Article> articles = List.of(article, article2);
//
//        //when
//        List<ArticleDto> allArticles = articleService.getAllArticles();
//
//        //then
//        assertEquals(articles.size(), allArticles.size());
//        assertEquals(article.getHeadline(), allArticles.get(0).getHeadline());
//    }

//    @Test
//    public void addArticle() {
//        //given
//        CreateArticleCommand command =
//                new CreateArticleCommand(
//                        "ENGLISH",
//                        "picture.png",
//                        "picture of picture",
//                        "Breaking news! We're testing our code!",
//                        "caption",
//                        "It's unbelievable but we do",
//                        true
//                );
//        //when
//        ArticleDto savedArticle = articleService.save(command);
//
//        //then
//        assertEquals(command.getPic(), savedArticle.getPic());
//        assertEquals(command.getLanguage(), savedArticle.getLanguage());
//    }

//    private Article givenArticle(String headline) {
//        return articleDao.save(new Article(
//                Language.ENGLISH,
//                "picture.png",
//                "picture of picture",
//                headline,
//                "caption",
//                "It's unbelievable but we do",
//                true
//        ));
//    }

}