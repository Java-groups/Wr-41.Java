package com.softserve.sportshub.category.service;

import com.softserve.sportshub.category.model.Category;

import java.util.List;

public interface CategoryService {
    Category getById(long id);

    List<Category> getAll();

    void save(Category category);

    Category update(Category category);

    void delete(Category category);

    void deleteById(long id);
}
