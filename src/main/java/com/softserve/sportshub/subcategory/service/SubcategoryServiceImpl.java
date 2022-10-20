package com.softserve.sportshub.subcategory.service;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.dao.SubcategoryDao;
import com.softserve.sportshub.subcategory.dto.SubcategoryDto;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryDao subcategoryDao;

    @Transactional(readOnly = true)
    @Override
    public SubcategoryDto getById(long id) {
        Subcategory subcategory = subcategoryDao.getById(id);
        return new SubcategoryDto(subcategory.getName());
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubcategoryDto> getAll() {
        return subcategoryDao.getAll().stream().map(s -> new SubcategoryDto(s.getName())).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(Subcategory subcategory) {
        subcategoryDao.save(subcategory);
    }

    @Transactional
    @Override
    public Subcategory update(Subcategory subcategory) {
        return subcategoryDao.update(subcategory);
    }

    @Transactional
    @Override
    public void delete(Subcategory subcategory) {
        subcategoryDao.delete(subcategory);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        subcategoryDao.deleteById(id);
    }

}
