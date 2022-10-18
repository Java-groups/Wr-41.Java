package com.softserve.sportshub.category.controller;

import com.softserve.sportshub.category.command.CreateCategoryCommand;
import com.softserve.sportshub.category.command.EditCategoryCommand;
import com.softserve.sportshub.category.dto.CategoryDto;
import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.category.service.CategoryService;
import com.softserve.sportshub.status.StatusDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable(name = "id") long id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(mapper.map(category, CategoryDto.class));
    }

    @PostMapping
    public ResponseEntity<StatusDto> add(@RequestBody CreateCategoryCommand command) {
        categoryService.save(new Category(command.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new StatusDto("Category created successfully!"));
    }

    @PutMapping
    public ResponseEntity<CategoryDto> edit(@RequestBody EditCategoryCommand command) {
        Category updatedCategory = categoryService.update(new Category(command.getName()));
        return ResponseEntity.ok(mapper.map(updatedCategory, CategoryDto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StatusDto> delete(@PathVariable(name = "id") long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok(new StatusDto("Category was removed successfully!"));
    }

}
