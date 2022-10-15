package com.softserve.sportshub.category.dao;

import com.softserve.sportshub.category.model.Category;

import java.util.List;

public interface CategoryDao {
    void save(Category category);
    List<Category> list();
}
