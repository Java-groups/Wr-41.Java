package com.softserve.sportshub.article.dao;

import com.softserve.sportshub.article.domain.Article;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class ArticleDaoImpl implements ArticleDao {
    SessionFactory sessionFactory;

    @Override
    public Article findOne(long id) {
        Query query = getCurrentSession()
                        .createQuery(" SELECT a " +
                                " FROM Article a " +
                                " LEFT JOIN FETCH a.comments " +
                                " LEFT JOIN FETCH a.team " +
                                " LEFT JOIN FETCH a.category c " +
                                " LEFT JOIN FETCH c.subcategories " +
                                " WHERE a.id = :id ")
                        .setParameter("id", id);
        return (Article) query.getResultList().get(0);
    }

    @Override
    public List<Article> findAll() {
        return getCurrentSession().createQuery(" SELECT a " +
                " FROM Article a " +
                " LEFT JOIN FETCH a.comments " +
                " LEFT JOIN FETCH a.team " +
                " LEFT JOIN FETCH a.category c " +
                " LEFT JOIN FETCH c.subcategories ").list();
    }

    @Override
    public Article save(Article article) {
        getCurrentSession().saveOrUpdate(article);
        return article;
    }

    @Override
    public Article update(Article article) {
        return (Article) getCurrentSession().merge(article);
    }

    @Override
    public void delete(Article article) {
        getCurrentSession().delete(article);
    }

    @Override
    public void delete(Long id) {
        getCurrentSession().delete(findOne(id));
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
