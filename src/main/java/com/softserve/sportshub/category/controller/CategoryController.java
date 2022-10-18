package com.softserve.sportshub.category.controller;

import com.softserve.sportshub.category.command.CreateCategoryCommand;
import com.softserve.sportshub.category.dto.CategoryDto;
import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable(name = "id") long id) {
        Category category = categoryService.show(id);
        return ResponseEntity.ok(new CategoryDto(category.getName()));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> add(@RequestBody CreateCategoryCommand command) {
        categoryService.save(new Category(command.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryDto(command.getName()));
    }

}
