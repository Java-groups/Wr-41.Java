package com.softserve.sportshub.category.service;

import com.softserve.sportshub.category.command.AddSubcategoryCommand;
import com.softserve.sportshub.category.command.EditCategoryCommand;
import com.softserve.sportshub.category.dao.CategoryDao;
import com.softserve.sportshub.category.dto.CategoryDto;
import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.dao.SubcategoryDao;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final SubcategoryDao subcategoryDao;

    @Transactional(readOnly = true)
    @Override
    public CategoryDto getDtoById(long id) {
        Category category = getEntityById(id);
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getSubcategories().stream().map(Subcategory::getName).collect(Collectors.toList())
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Category getEntityById(long id) {
        return categoryDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryDto> getAll() {
        return categoryDao.getAll().stream().map(
                c -> new CategoryDto(c.getId(),
                        c.getName(),
                        c.getSubcategories().stream().map(Subcategory::getName).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Transactional
    @Override
    public Category update(EditCategoryCommand command) {
        Category category = getEntityById(command.getId());
        category.setName(command.getName());
        category.setSubcategories(command.getSubcategories());
        return categoryDao.update(category);
    }

    @Transactional
    @Override
    public void addSubcategory(AddSubcategoryCommand command) {
        Category category = getEntityById(command.getIdOfCategory());
        Subcategory subcategory = subcategoryDao.getById(command.getIdOfSubcategory());

        if (!category.getSubcategories().contains(subcategory)) {
            category.addSubcategory(subcategory);
        }

        categoryDao.update(category);
    }

    @Transactional
    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        categoryDao.deleteById(id);
    }

}
