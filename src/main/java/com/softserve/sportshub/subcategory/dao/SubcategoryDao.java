package com.softserve.sportshub.subcategory.dao;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;

import java.util.List;

public interface SubcategoryDao {
    Subcategory getById(long id);

    List<Subcategory> getAll();

    void save(Subcategory subcategory);

    Subcategory update(Subcategory subcategory);

    void delete(Subcategory subcategory);

    void deleteById(long id);
}
