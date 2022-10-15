package com.softserve.sportshub.category.service;

import com.softserve.sportshub.category.dao.CategoryDao;
import com.softserve.sportshub.category.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDao categoryDao;

    @Transactional
    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> list() {
        return categoryDao.list();
    }
}
