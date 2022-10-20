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

    @Transactional(readOnly = true)
    @Override
    public Category getById(long id) {
        return categoryDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Transactional
    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Transactional
    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Transactional
    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Transactional(readOnly = true)
    @Override
    public void deleteById(long id) {
        categoryDao.deleteById(id);
    }

}
