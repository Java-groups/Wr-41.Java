package com.softserve.sportshub.subcategory.dao;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubcategoryDaoImpl implements SubcategoryDao {

    private final SessionFactory sessionFactory;


    @Override
    public Subcategory getById(long id) {
        return sessionFactory.getCurrentSession().get(Subcategory.class, id);
    }

    @Override
    public List<Subcategory> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Subcategory> query = sessionFactory.getCurrentSession().createQuery("from Subcategory ");
        return query.getResultList();
    }

    @Override
    public void save(Subcategory subcategory) {
        sessionFactory.getCurrentSession().save(subcategory);
    }

    @Override
    public Subcategory update(Subcategory subcategory) {
        return (Subcategory) sessionFactory.getCurrentSession().merge(subcategory);
    }

    @Override
    public void delete(Subcategory subcategory) {
        sessionFactory.getCurrentSession().delete(subcategory);
    }

    @Override
    public void deleteById(long id) {
        Subcategory subcategory = getById(id);
        delete(subcategory);
    }
}
