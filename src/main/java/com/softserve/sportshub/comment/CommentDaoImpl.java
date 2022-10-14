package com.softserve.sportshub.comment;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public List<Comment> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Comment> query = sessionFactory.getCurrentSession().createQuery("from Comment");
        return query.getResultList();
    }
}
