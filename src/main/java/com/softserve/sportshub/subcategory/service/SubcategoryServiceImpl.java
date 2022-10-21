package com.softserve.sportshub.subcategory.service;

import com.softserve.sportshub.subcategory.command.EditSubcategoryCommand;
import com.softserve.sportshub.subcategory.dao.SubcategoryDao;
import com.softserve.sportshub.subcategory.dto.SubcategoryDto;
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
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryDao subcategoryDao;

    @Transactional(readOnly = true)
    @Override
    public SubcategoryDto getDtoById(long id) {
        Subcategory subcategory = subcategoryDao.getById(id);
        return new SubcategoryDto(subcategory.getId(), subcategory.getName(), subcategory.getCategory());
    }

    @Transactional(readOnly = true)
    @Override
    public Subcategory getEntityById(long id) {
        return subcategoryDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubcategoryDto> getAll() {
        return subcategoryDao.getAll().stream().map(s -> new SubcategoryDto(
                s.getId(),
                s.getName(),
                s.getCategory())
        ).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(Subcategory subcategory) {
        subcategoryDao.save(subcategory);
    }

    @Transactional
    @Override
    public Subcategory update(EditSubcategoryCommand command) {
        Subcategory subcategory = getEntityById(command.getId());
        subcategory.setName(command.getName());
        subcategory.setCategory(subcategory.getCategory());
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
