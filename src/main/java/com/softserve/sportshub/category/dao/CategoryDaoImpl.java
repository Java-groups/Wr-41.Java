package com.softserve.sportshub.category.dao;

import com.softserve.sportshub.category.command.AddSubcategoryCommand;
import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao{

    private final SessionFactory sessionFactory;

    @Override
    public Category getById(long id) {
         return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public List<Category> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category ");
        return query.getResultList();
    }

    @Override
    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }


    @Override
    public Category update(Category category) {
        return (Category) sessionFactory.getCurrentSession().merge(category);
    }

    @Override
    public void delete(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }

    @Override
    public void deleteById(long id) {
        Category category = getById(id);
        delete(category);
    }

}
