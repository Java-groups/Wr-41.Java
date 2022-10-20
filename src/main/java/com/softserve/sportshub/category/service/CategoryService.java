package com.softserve.sportshub.category.service;

import com.softserve.sportshub.category.command.AddSubcategoryCommand;
import com.softserve.sportshub.category.command.EditCategoryCommand;
import com.softserve.sportshub.category.dto.CategoryDto;
import com.softserve.sportshub.category.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto getDtoById(long id);

    Category getEntityById(long id);

    List<CategoryDto> getAll();

    void save(Category category);

    Category update(EditCategoryCommand command);

    void addSubcategory(AddSubcategoryCommand command);

    void delete(Category category);

    void deleteById(long id);
}
