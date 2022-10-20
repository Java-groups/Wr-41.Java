package com.softserve.sportshub.article.controller;

import com.softserve.sportshub.article.dto.ArticleDto;
import com.softserve.sportshub.article.dto.CreateArticleCommand;
import com.softserve.sportshub.article.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ArticleDto> findALl() {
        return service.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getById(@PathVariable Long id) {
        ArticleDto articleDto = service.findById(id);
        return ResponseEntity.ok(articleDto);
    }

    @PostMapping
    public ResponseEntity<ArticleDto> addArticle(@RequestBody CreateArticleCommand command) {
        ArticleDto articleDto = service.save(command);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/articles/" + articleDto.getId()).build().toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id){
        service.delete(id);
    }
}
