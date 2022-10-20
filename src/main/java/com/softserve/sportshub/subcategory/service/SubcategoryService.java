package com.softserve.sportshub.subcategory.service;

import com.softserve.sportshub.subcategory.command.EditSubcategoryCommand;
import com.softserve.sportshub.subcategory.dto.SubcategoryDto;
import com.softserve.sportshub.subcategory.model.Subcategory;

import java.util.List;

public interface SubcategoryService {
    SubcategoryDto getDtoById(long id);

    Subcategory getEntityById(long id);

    List<SubcategoryDto> getAll();

    void save(Subcategory subcategory);

    Subcategory update(EditSubcategoryCommand command);

    void delete(Subcategory subcategory);

    void deleteById(long id);
}
