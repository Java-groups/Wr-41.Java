package com.softserve.sportshub.main;

import com.softserve.sportshub.article.dto.UpdateArticleCategoryCommand;
import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.CreateArticleCommand;
import com.softserve.sportshub.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/main", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
final class MainSectionController {

    private final ArticleService articleService;

    @PostMapping("/create")
    private ResponseEntity<ArticleDto> createArticle(@RequestBody CreateArticleCommand article) {
        var addedArticle = articleService.save(article);
        return new ResponseEntity<>(addedArticle, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<List<ArticleDto>> getArticlesAsList() {
        if (articleService.getAllArticles().isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(articleService.getAllArticles(), HttpStatus.FOUND);
    }

    @PatchMapping("/{articleId}")
    private ResponseEntity<ArticleDto> updateCategory(@PathVariable("articleId") Long id,
                                                      @RequestBody UpdateArticleCategoryCommand command) {
        articleService.updateCategory(id, command);
        return new ResponseEntity(articleService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("/{articleId}")
    private ResponseEntity deleteArticle(@PathVariable("articleId") Long id) {
        articleService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/comments/{articleId}/off")
    private ResponseEntity<ArticleDto> turnOffComments(@PathVariable("articleId") Long id) {
        articleService.turnOffComments(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/comments/{articleId}/on")
    private ResponseEntity<ArticleDto> turnOnComments(@PathVariable("articleId") Long id) {
        articleService.turnOnComments(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{articleId}/publish")
    private ResponseEntity<ArticleDto> publishArticle(@PathVariable("articleId") Long id) {
        articleService.publish(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{articleId}/unpublish")
    private ResponseEntity<ArticleDto> unpublishArticle(@PathVariable("articleId") Long id) {
        articleService.unpublish(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
