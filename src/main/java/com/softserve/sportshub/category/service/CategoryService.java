package com.softserve.sportshub.category.service;

import com.softserve.sportshub.category.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> list();
    Category show(long id);
}
