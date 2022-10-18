package com.softserve.sportshub.category.dao;

import com.softserve.sportshub.category.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Override
    public List<Category> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category ");
        return query.getResultList();
    }

    @Override
    public Category show(long id) {
//        TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("select Category from Category c where c.id = ?1");
//        return query.setParameter(1, id).getSingleResult();

        TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("select Category from Category c where c.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();

//        return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    }
}
