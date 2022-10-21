package com.softserve.sportshub.comment.dao;

import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) {
        sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public List<Comment> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Comment> query = sessionFactory.getCurrentSession().createQuery("from Comment");
        return query.getResultList();
    }

    @Override
    public boolean delete(Long id) {
        Comment comment = sessionFactory.getCurrentSession().find(Comment.class, id);
        if (comment == null) {
            return false;
        }
        sessionFactory.getCurrentSession().delete(comment);
        return true;
    }

    @Override
    public Comment findById(Long id) {
        return sessionFactory.getCurrentSession().find(Comment.class, id);
    }



}
