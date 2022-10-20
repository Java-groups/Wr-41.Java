package com.softserve.sportshub.category.controller;

import com.softserve.sportshub.category.command.AddSubcategoryCommand;
import com.softserve.sportshub.category.command.CreateCategoryCommand;
import com.softserve.sportshub.category.command.EditCategoryCommand;
import com.softserve.sportshub.category.dto.CategoryDto;
import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.category.service.CategoryService;
import com.softserve.sportshub.status.StatusDto;
import com.softserve.sportshub.subcategory.model.Subcategory;
import com.softserve.sportshub.subcategory.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable(name = "id") long id) {
        CategoryDto categoryDto = categoryService.getDtoById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping
    public ResponseEntity<StatusDto> add(@RequestBody CreateCategoryCommand command) {
        categoryService.save(new Category(command.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new StatusDto("Category was created successfully!"));
    }

    @PutMapping
    public ResponseEntity<StatusDto> edit(@RequestBody EditCategoryCommand command) {
        categoryService.update(command);
        return ResponseEntity.ok(new StatusDto("Category updatd succesfully!"));
    }

    @PutMapping("/add-subcategory")
    public ResponseEntity<StatusDto> addSubcategory(@RequestBody AddSubcategoryCommand command) {
        categoryService.addSubcategory(command);
        return ResponseEntity.ok(new StatusDto("Subcategory addded succesfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> delete(@PathVariable(name = "id") long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok(new StatusDto("Category was removed successfully!"));
    }

}
