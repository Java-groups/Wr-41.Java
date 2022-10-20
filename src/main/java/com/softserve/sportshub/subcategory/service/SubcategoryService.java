package com.softserve.sportshub.subcategory.service;

import com.softserve.sportshub.subcategory.dto.SubcategoryDto;
import com.softserve.sportshub.subcategory.model.Subcategory;

import java.util.List;

public interface SubcategoryService {
    SubcategoryDto getById(long id);

    List<SubcategoryDto> getAll();

    void save(Subcategory subcategory);

    Subcategory update(Subcategory subcategory);

    void delete(Subcategory subcategory);

    void deleteById(long id);
}
