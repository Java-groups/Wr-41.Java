package com.softserve.sportshub.category.dao;

import com.softserve.sportshub.category.model.Category;


import java.util.List;

public interface CategoryDao {

    Category getById(long id);

    List<Category> getAll();

    void save(Category category);

    Category update(Category category);

    void delete(Category category);

    void deleteById(long id);

}
